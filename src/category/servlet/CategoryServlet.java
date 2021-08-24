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
            default:
                break;
        }
    }

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
