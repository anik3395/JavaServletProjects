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


@WebServlet("/register")
public class StudentServlet extends HttpServlet {
	
	// A list to store registered students in memory
    static final List<Student> students = new ArrayList<>();
    
   // doGet method to display the registration form
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type to HTML
        response.setContentType("text/html");
        
        // Use PrintWriter to send the registration form as an HTML response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Student Registration</h1>");
        out.println("<form action='register' method='post'>");
        out.println("Name: <input type='text' name='name' required><br><br>");
        out.println("Email: <input type='email' name='email' required><br><br>");
        out.println("Course: <select name='course'>");
        out.println("<option >Java</option>");
        out.println("<option value='Python'>Python</option>");
        out.println("<option value='JavaScript'>JavaScript</option>");
        out.println("<option >C</option>");
        out.println("<option >C++</option>");
        out.println("</select><br><br>");
        out.println("<input type='submit' value='Register'>");
        out.println("</form>");
        out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
        String course = request.getParameter("course");
        
        if (name == null || name.isEmpty() || email == null || email.isEmpty() || course == null || course.isEmpty()) {
            // If validation fails, send an error message back to the client
            response.getWriter().println("<h3>All fields are required!</h3>");
            return;
        }
        
        // Create a new student object using the submitted data
        Student student = new Student(name, email, course);
        
        // Add the new student to the list
        students.add(student);
        
     // Redirect to the '/view' page to display all registered students
        response.sendRedirect("view");
	}
	
	// Method to get the list of registered students (to be used in Part 2)
    public static List<Student> getStudents() {
        return students;
    }

}
