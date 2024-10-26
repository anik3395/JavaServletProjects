package com.anik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Check if any fields are missing or empty
        if (name == null || email == null || message == null || 
            name.isEmpty() || email.isEmpty() || message.isEmpty()) {
            
            response.getWriter().println("<h3>All fields are required!</h3>");
            response.getWriter().println("<a href='index.html'>Go back to the form</a>");
        } else {
            // Display submitted data
            response.getWriter().println("<h2>Thank you for contacting us!</h2>");
            response.getWriter().println("<p><strong>Name:</strong> " + name + "</p>");
            response.getWriter().println("<p><strong>Email:</strong> " + email + "</p>");
            response.getWriter().println("<p><strong>Message:</strong> " + message + "</p>");
        }
    }
}
