package manager.servlet;

import manager.model.Manager;
import manager.service.ManagerService;
import manager.service.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ManagerServlet extends HttpServlet {

    ManagerService managerService = new ManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String path = req.getServletPath();
        switch (path){
            case"/login.manager":
                //登录
                login(req,resp);
                break;
            case"/logout.manager":
                //退出
                logout(req,resp);
            default:
                break;
        }

    }

    /*退出登录*/
    private void logout(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("manager");
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    /*用户登录*/
    private void login(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        List<Manager> managers = managerService.queryByUsernamePassword(username,password);
        if(managers!=null&&managers.size()>0){
            //登录成功
            HttpSession session = req.getSession();
            session.setAttribute("manager",managers.get(0));
            resp.sendRedirect(req.getContextPath()+"/main.jsp");
        }else {
            //登录失败
            req.setAttribute("message","对不起，用户名或密码输入错误！");
            req.getRequestDispatcher("/index.jsp");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

}
