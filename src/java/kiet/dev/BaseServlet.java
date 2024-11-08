/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package kiet.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import kiet.dev.data.dao.CategoryDao;
import kiet.dev.data.dao.Database;
import kiet.dev.data.dao.DatabaseDao;
import kiet.dev.data.model.Category;

/**
 *
 * @author Phi Kiet
 */
@WebServlet(name = "BaseServlet", urlPatterns = {"/BaseServlet"})
public class BaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        DatabaseDao.init(new Database());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categorylist = categoryDao.findAll();
        
        req.setAttribute("categorylist", categorylist);
        
    }
    
    
    

}
