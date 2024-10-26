package com.anik;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view")
public class ViewStudentServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type to HTML
        response.setContentType("text/html");

        // Get the PrintWriter to write HTML output
        PrintWriter out = response.getWriter();

        // Start HTML document
        out.println("<html><body>");
        out.println("<h1>Registered Students</h1>");
        
        // Table headers for displaying students
        out.println("<table border='1'>");
        out.println("<tr><th>S.No</th><th>Name</th><th>Email</th><th>Course</th></tr>");

        // Retrieve the list of students stored in the StudentServlet
        List<Student> students = StudentServlet.students;

        // Iterate through the student list and create rows for each student
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            out.println("<tr>");
            out.println("<td>" + (i + 1) + "</td>");  // Serial Number
            out.println("<td>" + student.getName() + "</td>");  // Student Name
            out.println("<td>" + student.getEmail() + "</td>");  // Student Email
            out.println("<td>" + student.getCourse() + "</td>");  // Course Name
            out.println("</tr>");
        }

        // End of the table
        out.println("</table>");

        // Add a link to register a new student
        out.println("<br><a href='register'>Register New Student</a>");

        // End HTML document
        out.println("</body></html>");
	}

	

}
