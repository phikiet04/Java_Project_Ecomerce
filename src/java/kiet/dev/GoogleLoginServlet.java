/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package kiet.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Phi Kiet
 */

public class GoogleLoginServlet extends BaseServlet {

    private static final String CLIENT_ID = "74835849327-bg9881r9d6anmjl15hrsamkqcqvjgqrh.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "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";
    private static final String REDIRECT_URI = "http://localhost:8080/doan/HomeServlet";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorizationUrl = "https://accounts.google.com/o/oauth2/auth" +
                "?client_id=" + CLIENT_ID +
                "&redirect_uri=" + REDIRECT_URI +
                "&response_type=code" +
                "&scope=openid%20email%20profile";

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
