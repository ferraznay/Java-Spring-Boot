<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciamento usuario RD</title>
<link rel="stylesheet" href="webjars/bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

<nav class="navbar navbar-expand-lg ">
            <a class="navbar-brand" href="#">Raia Drogasil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link " href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            Usuario
                        </a>
                       
                    </li>
                </ul>
            </div>
</nav>
        
        <h2> Lista de usuários</h2>
        <hr>
        

  
  
  	<form action="ProjetoFinal2" method="post">
		<button type="submit" name="btnOption" value="newform" class="btn btn-primary display-flex">Adicionar Usuário</button>
	</form>
	<hr>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nome</th>
					<th scope="col">E-mail</th>
					<th scope="col">País</th>					
					<th scope="col">Ações</th>
				</tr>
			</thead>
			
  			<tbody>
    			<c:forEach var="usuario" items="${listaUsuario}">
					<tr>
						<form action="ProjetoFinal2" method="post">
							<td>
								<c:out value="${usuario.id}"/>
								<input type="hidden" name="id" value="${usuario.id}"/>
							</td>
							<td><c:out value="${usuario.nome}"/></td>
							<td><c:out value="${usuario.email}"/></td>
							<td><c:out value="${usuario.pais}"/></td>
							<td><button type="submit" name="btnOption" value="delete" class="btn btn-primary display-flex">Deletar</button><button type="submit" name="btnOption" value="updateform" class="btn btn-primary display-flex">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
  </tbody>
</table>
</div>
	      
        
</body>
</html>