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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import kiet.dev.data.dao.DatabaseDao;
import kiet.dev.data.dao.OrderDao;
import kiet.dev.data.dao.OrderItemDao;
import kiet.dev.data.model.Order;
import kiet.dev.data.model.OrderItem;
import kiet.dev.data.model.User;
import kiet.dev.util.StringHelper;


/**
 *
 * @author Phi Kiet
 */

public class CheckoutServlet extends BaseServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("LoginServlet");
    } else {
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        if (cart != null) {
            request.setAttribute("cart", cart); // Gửi giỏ hàng qua request
            
            // Tính tổng tiền
            double total = 0;
            for (OrderItem item : cart) {
                total += item.getPrice() * item.getQuantity();
            }
            request.setAttribute("total", total);  // Gửi tổng tiền qua request
        }
        request.getRequestDispatcher("checkout.jsp").forward(request, response); // Điều hướng đến trang checkout.jsp
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void proccessCheckout(HttpServletRequest request, User user) {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        String code = StringHelper.randomString(10);
        Order order = new Order(code, "pending", user.getId());     
        orderDao.insert(order);
        
        order = orderDao.findByCode(code);
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        
        
        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();
        
        if(cart != null ){
            for(OrderItem orderItem:cart){
                orderItem.setOrderId(order.getId());
                orderItemDao.insert(orderItem);
            }
        }
        session.setAttribute("message", "checkout sucssess");
        session.removeAttribute("cart");
    }

}
