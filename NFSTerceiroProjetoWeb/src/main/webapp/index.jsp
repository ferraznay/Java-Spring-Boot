<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Primeira p?gina JSP
	<%@page import="java.util.Date" %>
	<%! boolean formatar = true; %> <%--Declara??o --%>
	<%!
		String today(){
		// java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dt.format(new java.util.Date());
			
	}
	%>
	
	<h1> A data de hoje ? :<%=new Date() %></h1>
	<h1> A data de hoje ? :<%= today() %> </h1>
	<h1> A data de hoje ? :<% if (formatar){
				out.println(today());
	} else{
		out.println(new java.util.Date());
		}%>
	</h1>
	
</body>
</html>