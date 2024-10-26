package com.anik;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet {
	public class Myservlet extends HttpServlet {
		
		

		

		private ServletResponse response;

		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			
			PrintWriter out= response.getWriter();
			out.print("Hi ");
			
			ServletContext ctx = getServletContext();
			String str = ctx.getInitParameter("name");
			out.println(str);
		}
		
	}

}
