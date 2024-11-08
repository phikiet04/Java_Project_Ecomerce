/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package kiet.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import kiet.dev.data.model.Product;
import kiet.dev.data.dao.DatabaseDao;
import kiet.dev.data.dao.ProductDao;



/**
 *
 * @author Phi Kiet
 */
@WebServlet(name = "BlogServlet", urlPatterns = {"/BlogServlet"})
public class SearchServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          super.doGet(request, response); 
        String keyword = request.getParameter("keyword");
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.findByName(keyword);
        
        
         request.setAttribute("keyword", keyword);
        request.setAttribute("productList", productList);
        
        
        request.getRequestDispatcher("search.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
