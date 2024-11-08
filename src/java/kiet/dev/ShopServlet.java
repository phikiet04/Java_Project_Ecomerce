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
import kiet.dev.util.Constants;


/**
 *
 * @author Phi Kiet
 */
@WebServlet(name = "BlogServlet", urlPatterns = {"/BlogServlet"})
public class ShopServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
         super.doGet(request, response);   
       ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.findAll();

        int page = 1; // Mặc định trang đầu tiên là 1
        if (request.getParameter("page") != null) {
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1; // Nếu không thể chuyển đổi số trang, mặc định là trang 1
            }
        }

        int total = productList.size();
        int numberPage = (int) Math.ceil((double) total / Constants.PER_PAGE); // Làm tròn lên số trang

        // Lấy danh sách sản phẩm cho trang hiện tại
        productList = productDao.getProducts((page - 1) * Constants.PER_PAGE, Constants.PER_PAGE);

        // Gửi dữ liệu phân trang về JSP
        request.setAttribute("page", page);
        request.setAttribute("total", total);
        request.setAttribute("numberPage", numberPage); // Chỉnh lại tên biến từ 'nunberPage' thành 'numberPage'
        request.setAttribute("productList", productList);

        // Điều hướng tới trang shop.jsp
        request.getRequestDispatcher("shop.jsp").include(request, response);

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
