import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewFeedback")
public class ViewFeedbackServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Start HTML output
        out.println("<html><body>");
        out.println("<h1>All Feedback</h1>");

        // Get feedback list from FeedbackServlet
        List<Feedback> feedbackList = FeedbackServlet.getFeedbackList();

        // Debugging: Print feedback list size and contents to server logs
//        System.out.println("Feedback list size: " + feedbackList.size());
//        for (Feedback fb : feedbackList) {
//            System.out.println("Feedback from: " + fb.getName() + " - " + fb.getFeedback());
//        }

        if (feedbackList.isEmpty()) {
            out.println("<p>No feedback available yet.</p>");
        } else {
            // Create a table for displaying feedback
            out.println("<table border='1' cellpadding='10'>");
            out.println("<tr><th>S.No</th><th>Name</th><th>Email</th><th>Feedback</th></tr>");

            int i = 1;
            for (Feedback fb : feedbackList) {
                out.println("<tr>");
                out.println("<td>" + i++ + "</td>");
                out.println("<td>" + fb.getName() + "</td>");
                out.println("<td>" + fb.getEmail() + "</td>");
                out.println("<td>" + fb.getFeedback() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }

        // End HTML output
        out.println("</body></html>");
    }
}
