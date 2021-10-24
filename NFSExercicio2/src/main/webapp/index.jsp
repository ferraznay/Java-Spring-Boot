<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="jdk.internal.misc.FileSystemOption"%>
<%@page import="jdk.internal.misc.FileSystemOption"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%--Declaração --%>
	<%! int x = 5; %>
	<%! int y = 6; %>
	<%! int z = 7; %>
	
	<%--Scriptlet --%>
	<% x++; %>
	<% y++; %>
	<% z++; %>
	<%--Expression --%>
	<h2> Incrementando os numeros :<%= x %> </h2>
	<h2> Incrementando os  numeros :<%= y %> </h2>
	<h2> Incrementando os  numeros :<%= z %> </h2>
	
	
	
	<%@page import="java.util.Calendar" %>

	<%!	
		String mostrarPareImpar (){
		Calendar hoje = Calendar.getInstance();
		int segundos = hoje.get(Calendar.SECOND);
		
		if ((segundos %2) == 0){
			return("os segundos são pares");
			} else{
				return("os segundos são impares"); 
				}
			} %>
			<%= new java.util.Date() %>			
			<%= mostrarPareImpar() %>
			

</body>
</html>