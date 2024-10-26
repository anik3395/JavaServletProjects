package com.anik;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/submitFeedback")
public class FeedbackServlet extends HttpServlet {
    // In-memory list to store feedback
    private static final List<Feedback> feedbackList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if user has already submitted feedback
        if (session.getAttribute("hasSubmitted") != null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>You have already submitted feedback.</h3>");
            out.println("<a href='viewFeedback'>View All Feedback</a>");
            out.println("</body></html>");
            return;
        }

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedback = request.getParameter("feedback");

        // Validate form data
        if (name == null || name.isEmpty() || email == null || email.isEmpty() || feedback == null || feedback.isEmpty()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>All fields are required. Please try again.</h3>");
            out.println("<a href='feedbackForm.html'>Go back to form</a>");
            out.println("</body></html>");
            return;
        }

        // Create Feedback object and store it in the list
        Feedback fb = new Feedback(name, email, feedback);
        feedbackList.add(fb);

        // Mark session as feedback submitted
        session.setAttribute("hasSubmitted", true);

        // Send response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Thank you for your feedback, " + name + "!</h3>");
        out.println("<p>Your feedback: \"" + feedback + "\" has been submitted successfully.</p>");
        out.println("<a href='viewFeedback'>View All Feedback</a>"); // Link to view feedback
        out.println("</body></html>");
    }

    // Static method to get all feedback
    public static List<Feedback> getFeedbackList() {
        return feedbackList;
    }
}
