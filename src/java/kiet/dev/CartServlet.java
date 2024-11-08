package kiet.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import kiet.dev.data.model.OrderItem;
import kiet.dev.util.Helper;

public class CartServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          super.doGet(request, response); 
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<OrderItem>(); // Nếu giỏ hàng chưa có, khởi tạo mới
        }

        request.setAttribute("cart", cart);
        request.setAttribute("total", Helper.total(cart));
        request.getRequestDispatcher("cart.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        // Kiểm tra nếu action bị null
        if (action == null || action.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action is missing");
            return;
        }

        // Xử lý theo từng hành động
        switch (action) {
            case "create":
                createOrder(request);
                break;
            case "update":
                updateOrder(request);
                break;
            case "delete":
                deleteOrder(request);
                break;
            default:
                // Nếu action không hợp lệ, trả về lỗi
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                return;
        }

        // Sau khi xử lý, chuyển hướng về lại giỏ hàng
        response.sendRedirect("CartServlet");
    }

    // Tạo mới sản phẩm vào giỏ hàng
    private void createOrder(HttpServletRequest request) {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        double price = Double.parseDouble(request.getParameter("price"));

        OrderItem orderItem = new OrderItem(quantity, price, 0, productId);

        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        boolean isExistInCart = false;

        if (cart == null) {
            cart = new ArrayList<>();
        } else {
            for (OrderItem ord : cart) {
                if (ord.getProductId() == productId) {
                    ord.setQuantity(ord.getQuantity() + quantity);
                    isExistInCart = true;
                    break;
                }
            }
        }

        if (!isExistInCart) {
            cart.add(orderItem);
        }
        session.setAttribute("cart", cart);
    }

    // Cập nhật số lượng sản phẩm trong giỏ hàng
    private void updateOrder(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            for (OrderItem ord : cart) {
                if (ord.getProductId() == productId) {
                    ord.setQuantity(quantity);
                }
            }
        }

        session.setAttribute("cart", cart);
    }

    // Xóa sản phẩm khỏi giỏ hàng
    private void deleteOrder(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        if (cart != null) {
            cart.removeIf(ord -> ord.getProductId() == productId); // Sử dụng lambda để đơn giản hóa việc xóa
        }

        session.setAttribute("cart", cart);
    }

    @Override
    public String getServletInfo() {
        return "CartServlet to manage shopping cart";
    }
}
