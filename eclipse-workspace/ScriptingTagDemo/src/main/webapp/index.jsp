<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
  int a = 10;
  String name = "Anik Das";
  
  int square(){
	  return a*a;
  }
%>

<%
out.println("a is " + a);
out.println("name is " + name);
out.println( square());
int b = 20;
if(b<100){
	out.println("b is smaller than 100");
}
else{
	out.println("b is greater");
}

try{
	int k = 9/0;
}catch(Exception e){
	out.println("Error : " + e.getMessage());
}


%>

<%= a %>
<%= name %>
<%= square() %>

</body>
</html>