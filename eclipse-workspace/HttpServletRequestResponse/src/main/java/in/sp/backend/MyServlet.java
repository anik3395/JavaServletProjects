package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aaa")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String myName = req.getParameter("name1");
		String myEmail = req.getParameter("email1");
		
		PrintWriter out = resp.getWriter();
		out.println("Name is : " + myName);
		out.println("Name is : " + myEmail);
				
	}

}
