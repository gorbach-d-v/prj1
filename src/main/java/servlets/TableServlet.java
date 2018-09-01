package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.ApplicationDao;

@WebServlet("/users")
public class TableServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //call dao and get profile details
        ApplicationDao dao = new ApplicationDao();
        User user = dao.getProfileDetails("admin");

        //store all information in request object
        request.setAttribute("user", user);

        //forward control to profile jsp
        request.getRequestDispatcher("/pages/users.jsp").forward(request, response);
    }
}