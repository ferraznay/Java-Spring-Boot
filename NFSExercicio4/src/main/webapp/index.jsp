<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Calculadora triângulo</h2>
		<form action="Projeto2Servlet" name="calculadora" method="post">
			
			  <label for="fname">Primeiro Lado:</label>
			  <input type="text" id="fname" name="valor1"><br><br>
			  <label for="lname" >Segundo Lado:</label>			  
			  <input type="text" id="lname" name="valor2"><br><br>
			  <label for="lname" >Terceiro Lado:</label>			  
			  <input type="text" id="jname" name="valor3"><br><br>
			  <input type="reset" value="Limpar" name="reset">
			  <input type="submit" value="Calcular" name="calcular">
		</form>

</body>
</html>