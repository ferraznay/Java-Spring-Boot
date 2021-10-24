<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 
<title>Insert title here</title>
</head>
<body>

	<h2>Calculadora</h2>
<form action="PrimeiroServlet" name="calculadora" method="post">
  <label for="fname">Valor 1:</label>
  <input type="text" id="fname" name="valor1"><br><br>
  <label for="fname">Operador (+, -, *, /):</label>
  <input type="text" id="operador" name="operador"><br><br>
  <label for="lname" >Valor 2:</label>
  <input type="text" id="lname" name="valor2"><br><br>
  <input type="reset" value="Limpar" name="reset">
  <input type="submit" value="Calcular" name="reset">
  <h2> Resultado = ${requestScope.res}</h2>
 
</form>
   
</body>
</html>