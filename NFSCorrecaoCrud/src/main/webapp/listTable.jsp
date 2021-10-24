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
		<button type="submit" name="btnOption" value="newform">Cadastrar Usuário</button>
	</form>
	
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${listUser}">
					<tr>
						<form action="CRUDController" method="post">
							<td>
								<c:out value="${usuario.id}"/>
								<input type="hidden" name="txtId" value="${usuario.id}"/>
							</td>
							<td><c:out value="${usuario.name}"/></td>
							<td><button type="submit" name="btnOption" value="delete">Deletar</button><button type="submit" name="btnOption" value="updateform">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
</body>
</html>