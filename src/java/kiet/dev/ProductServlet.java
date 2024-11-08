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
import kiet.dev.data.dao.DatabaseDao;
import kiet.dev.data.dao.ProductDao;
import kiet.dev.data.model.Product;


/**
 *
 * @author Phi Kiet
 */

public class ProductServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          super.doGet(request, response); 
               int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);
        
        List<Product> relatedProductList = productDao.relatedProductList(product);
        
        productDao.updateView(product);
        request.setAttribute("product", product);
        request.setAttribute("relatedProductList", relatedProductList);
        request.getRequestDispatcher("single-product.jsp").include(request, response);


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
