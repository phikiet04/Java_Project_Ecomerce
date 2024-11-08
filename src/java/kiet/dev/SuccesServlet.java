package kiet.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;



public class SuccesServlet extends BaseServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        

        // Tạo nội dung email
        String orderDetails = "Order Confirmation:\n"
                            + "Name: " + firstName + " " + lastName + "\n"
                            + "Phone: " + phone + "\n"
                            + "Address: " + address + "\n"
                            + "Thank you for your order!";

        // Gửi email
        try {
            sendEmail(email, "Order Confirmation", orderDetails);
            response.sendRedirect("success.jsp");  // Điều hướng đến trang thành công
        } catch (MessagingException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");  // Điều hướng đến trang lỗi nếu gửi email thất bại
        }
    }

    private void sendEmail(String recipientEmail, String subject, String messageText) throws MessagingException {
        // Cấu hình SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Thông tin đăng nhập email của bạn
        final String username = "kietvophi@gmail.com"; // Thay bằng email của bạn
        final String password = "Kietlac410"; // Thay bằng mật khẩu của bạn

        // Tạo session email
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Tạo email
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject(subject);
        message.setText(messageText);

        // Gửi email
        Transport.send(message);
    }
}
