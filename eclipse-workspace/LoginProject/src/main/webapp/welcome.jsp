<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

response.setHeader("Expires", "0");
if(session.getAttribute("username")==null){
	
	response.sendRedirect("login.jsp");
}
%>
welcome ${username}
<a href="videos.jsp">Video here</a>

<form action="Logout">
<input type="submit" value = "Logout">
</form>
</body>
</html>