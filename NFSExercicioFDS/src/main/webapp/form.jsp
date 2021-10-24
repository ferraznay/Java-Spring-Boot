<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciamento de usuarios RD</title>
<link rel="stylesheet" href="webjars/bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg ">
            <a class="navbar-brand" href="index.jsp">CRUD Carros</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link " href="index.jsp" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            Carros
                        </a>
                       
                    </li>
                       <li class="nav-item dropdown">
                        <a class="nav-link " href="index.jsp" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            IPVA
                        </a>
                       
                    </li>
                </ul>
            </div>
        </nav>
        
        <h2>Adicionar Carro </h2>
        
    	<div class="container"> 
    	
    	<form action="CRUDControllerCarro" method="post">
    	<c:choose>
			<c:when test="${ carro == null }">
		       	<div class="mb-3">
			        <label for="inputNome" class="form-label">Modelo </label>
			        <input type="text" class="form-control" id="inputNome" name="model"  required>
		        </div>
	        
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Ano </label>
			    <input type="text" class="form-control" id="exampleInputEmail1" name="ano"  required>
			  </div>
			  
			
			
			  <button type="submit" class="btn btn-primary" name="btnOption" value="create">
			  Salvar </button>
		  
		 </c:when>
		  	<c:otherwise>
		  	<input type="hidden" name="txtId" value="${carro.id}"/>
		  		<div class="mb-3">
			        <label for="inputNome" class="form-label">Modelo </label>
			        <input type="text" class="form-control"  name="model" value="${carro.model}"   required>
	           	</div>
	        
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Ano </label>
			    <input type="text" class="form-control"  name="ano"   value="${carro.ano}" required >
			  </div>
			
			
			  <button type="submit" class="btn btn-primary" name="btnOption" value="update">
			  Atualizar </button>
		  			  	
		  </c:otherwise>
	</c:choose>
		  
		</form>

   </div>
   
        
        

</body>
</html>