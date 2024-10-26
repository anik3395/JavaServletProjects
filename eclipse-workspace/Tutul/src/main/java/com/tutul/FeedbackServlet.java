package com.tutul;

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


@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

    // Store feedback in memory
    private static final List<Feedback> feedbackList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Boolean hasSubmitted = (Boolean) session.getAttribute("hasSubmitted");

        if (hasSubmitted != null && hasSubmitted) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h2>You have already submitted feedback.</h2>");
            out.println("<a href='view-feedback'>View All Feedback</a>");
        } else {
        	// Redirect to the feedback form (HTML page)
        	resp.sendRedirect(req.getContextPath() + "/feedback.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String message = req.getParameter("message");

        // Validate form fields
        if (name != null && email != null && message != null && !name.isEmpty() && !email.isEmpty() && !message.isEmpty()) {
            // Create a new feedback object
            Feedback feedback = new Feedback(name, email, message);

            // Add feedback to the list
            getFeedbacklist().add(feedback);

            // Set session attribute to mark that feedback has been submitted
            HttpSession session = req.getSession();
            session.setAttribute("hasSubmitted", true);

            // Display a thank you message
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>Thank you for your feedback, " + name + "!</h2>");
            out.println("<a href='view-feedback'>View All Feedback</a>");
            out.println("</body></html>");
        } else {
            // Handle invalid submission (missing fields)
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>Error: All fields are required!</h2>");
            out.println("<a href='feedback'>Go back to the form</a>");
            out.println("</body></html>");
        }
    }

	/**
	 * @return the feedbacklist
	 */
	public static List<Feedback> getFeedbacklist() {
		return feedbackList;
	}
}
