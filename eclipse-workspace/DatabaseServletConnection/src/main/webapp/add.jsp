<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   String url = "jdbc:postgresql://localhost:5432/data1";
   String username="postgres";
   String password="123456789";
   String query = "select * from student where id =3";
   Class.forName("org.postgresql.Driver");
   Connection conn = DriverManager.getConnection(url,username,password);
   Statement stmt = conn.createStatement();
   ResultSet rs= stmt.executeQuery(query);
   rs.next();
%>

ID: <%= rs.getInt(1) %><br>
Name: <%= rs.getString(2) %>


</body>
</html>