/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package kiet.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import kiet.dev.BaseServlet;


/**
 *
 * @author Phi Kiet
 */

public class FacebookLoginServlet extends BaseServlet {

        private static final String CLIENT_ID = "YOUR_FACEBOOK_APP_ID";
    private static final String CLIENT_SECRET = "YOUR_FACEBOOK_APP_SECRET";
    private static final String REDIRECT_URI = "http://localhost:8080/YourApp/FacebookLoginCallback";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorizationUrl = "https://www.facebook.com/v12.0/dialog/oauth" +
                "?client_id=" + CLIENT_ID +
                "&redirect_uri=" + REDIRECT_URI +
                "&response_type=code" +
                "&scope=email";

        response.sendRedirect(authorizationUrl);
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
