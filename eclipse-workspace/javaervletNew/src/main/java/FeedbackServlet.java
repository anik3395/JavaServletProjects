import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/submitFeedback")
public class FeedbackServlet extends HttpServlet {

    private static final List<Feedback> feedbackList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedback = request.getParameter("feedback");

        // Print received values to check
//        System.out.println("Name: " + name);
//        System.out.println("Email: " + email);
//        System.out.println("Feedback: " + feedback);


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

        // Create a object and store all the value in the list
        Feedback fb = new Feedback(name, email, feedback);
        feedbackList.add(fb);

        // Send response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Thank you for your feedback, " + name + "!</h3>");
        out.println("<p>Your feedback: \"" + feedback + "\" has been submitted successfully.</p>");
        out.println("<a href='viewFeedback'>View All Feedback</a>"); // Link to view feedback
        out.println("</body></html>");
    }

    // Static method to get the list of all feedback
    public static List<Feedback> getFeedbackList() {
        return feedbackList;
    }
}
