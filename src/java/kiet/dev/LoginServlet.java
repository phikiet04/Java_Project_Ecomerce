/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package kiet.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kiet.dev.data.dao.DatabaseDao;
import kiet.dev.data.dao.UserDAO;
import kiet.dev.data.model.User;


/**
 *
 * @author Phi Kiet
 */
public class LoginServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          super.doGet(request, response); 
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            response.sendRedirect("HomeServlet");
        } else {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(email, password);

        if (user == null) {
            session.setAttribute("error", "Login Failedl");
            response.sendRedirect("LoginServlet");

        } else {
            session.setAttribute("user", user);
            if (user.getRole().equals("admin")) {

                response.sendRedirect("DashboardServlet");

            } else {
                response.sendRedirect("HomeServlet");
            }

        }

            
        }
        
        
       

    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
