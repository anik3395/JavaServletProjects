package com.tutul;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view-feedback")
public class ViewFeedbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>All Feedback</h2>");

        if (FeedbackServlet.getFeedbacklist().isEmpty()) {
            out.println("<p>No feedback has been submitted yet.</p>");
        } else {
            out.println("<table border='1'>");
            out.println("<tr><th>Name</th><th>Email</th><th>Feedback</th></tr>");

            // Loop through all feedback and display it
            for (Feedback feedback : FeedbackServlet.getFeedbacklist()) {
                out.println("<tr>");
                out.println("<td>" + feedback.getName() + "</td>");
                out.println("<td>" + feedback.getEmail() + "</td>");
                out.println("<td>" + feedback.getMessage() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }

        out.println("<a href='feedback'>Submit New Feedback</a>");
        out.println("</body></html>");
    }
}
