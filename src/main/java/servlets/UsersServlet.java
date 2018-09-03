package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.ApplicationDao;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

//    private ApplicationDao dao = new UserService();
//
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        sendUsers(req,0,10);

        req.setAttribute("firstRow", 0);
        req.setAttribute("countRow", 10);

        //forward control to profile jsp
        req.getRequestDispatcher("/pages/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get the username from the login form
        int firstRow =0;
        int countRow =10;
        if ("create".equals(req.getParameter("page"))) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            int age = Integer.parseInt(req.getParameter("age"));
            String activity = req.getParameter("activity");

            ApplicationDao dao = new ApplicationDao();
            dao.createUser(username, password, firstName, lastName, age, activity);
        } else if("next".equals(req.getParameter("page"))){
            firstRow = Integer.parseInt(req.getParameter("firstRow"))+10;
            countRow = Integer.parseInt(req.getParameter("countRow"));

            req.setAttribute("firstRow", firstRow);
            req.setAttribute("countRow", countRow);
        } else {
            firstRow = Integer.parseInt(req.getParameter("firstRow"))-10;
            countRow = Integer.parseInt(req.getParameter("countRow"));

            req.setAttribute("firstRow", firstRow);
            req.setAttribute("countRow", countRow);
        }
        sendUsers(req,firstRow,countRow);
//        doGet(req, resp);
        req.getRequestDispatcher("/pages/users.jsp").forward(req, resp);
    }

    private void sendUsers(HttpServletRequest req, int start, int count){
        ApplicationDao dao = new ApplicationDao();
        List<User> users = dao.getUserList(start, count);
        int countUser = dao.getUsersCount();
        req.setAttribute("users", users);
        req.setAttribute("countUser", countUser);
    }
}