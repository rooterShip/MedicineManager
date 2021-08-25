package category.servlet;

import category.model.Category;
import category.service.CategoryService;
import category.service.CategoryServiceImpl;
import util.PageModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        String path = req.getServletPath();
        switch (path){
            case "/selectByPage.category":
                //分页查询
                selectByPage(req,resp);
                break;
            case "/toadd.category"://跳转到编辑页面
                toAdd(req,resp);
                break;
            case "/addorupdate.category"://新增或修改
                addorupdate(req,resp);
                break;
            case "/delete.category":
                /*删除一条记录*/
                delete(req,resp);
                break;
            default:
                break;
        }
    }
    private void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        //判断能不能删除

        String categoryId =  req.getParameter("id");
        if(categoryService.iscontaintDrug(categoryId)){
            req.setAttribute("messageDelete","对不起，该类别还包含药品，请先删除对应的药品");

        }else {
            categoryService.deleteByCategoryId(categoryId);

        }
        req.getRequestDispatcher("/selectByPage.category?pageNo=1").forward(req,resp);
    }


    /*新增或修改*/
    private void addorupdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String id = req.getParameter("id");
        String cname = req.getParameter("cname");
        String description = req.getParameter("description");
        Category category = new Category(id,cname,null,description);
        if(id!=null&&!"".equals(id)){
            categoryService.updateOne(category);
        }
        else{
            categoryService.addOne(category);//新增操作
        }
        resp.sendRedirect(req.getContextPath()+"/selectByPage.category?pageNo=1");
    }


    /*跳转到编辑页面*/
    private void toAdd(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String id = req.getParameter("id");
        if(id!=null&&!"".equals(id)){
            String cname = req.getParameter("cname");
            String description = req.getParameter("description");
            Category category = new Category(id,cname,null,description);
            req.setAttribute("category",category);

        }
        req.getRequestDispatcher("/Category/Category_toAdd.jsp").forward(req,resp);

    }


    /*分页查询*/
    private void selectByPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        PageModel pageModel = new PageModel();
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        String likeValue = req.getParameter("likeValue");
        pageModel.setPageNo(pageNo);
        pageModel.setLikeValue(likeValue);
        List<Category> categories = categoryService.selectByPage(pageModel);
        pageModel.setRecordList(categories);
        req.setAttribute("pageModel",pageModel);
        req.getRequestDispatcher("/Category/Category_selectByPage.jsp").forward(req,resp);
    }
}
