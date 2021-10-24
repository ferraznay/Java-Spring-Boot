<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="CRUDController" method="post">
		<c:choose>
			<c:when test="${ user == null }">
				<label>Nome:</label><input type="text" name="txtName" required/>
			
				<button type="submit" name="btnOption" value="create">Salvar</button>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="txtId" value="${user.id}"/>
				<label>Nome:</label><input type="text" name="txtName" value="${user.name}" required/>
			
				<button type="submit" name="btnOption" value="update">Atualizar</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>