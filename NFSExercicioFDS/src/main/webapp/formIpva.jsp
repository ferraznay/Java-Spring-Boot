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
        
        <h2>Adicionar Ipva </h2>
        
    	<div class="container"> 
    	
    	<form action="CRUDControllerCarro" method="post">
    	<c:choose>

          <c:when test="${listIpva == null }">
			<div class="mb-3">
                <label for="exampleAno" class="form-label">Ano </label>
                <input type="text" class="form-control" id="exampleAno" name="ano2"  required>
             </div>
             
 			 <button type="submit" class="btn btn-primary" name="btnOption" value="create2">
			  Salvar </button>
         </c:when>

                    <c:otherwise>

                        <tr>
                                <form action="CRUDControllerCarro" method="post">
                                    <input type="hidden" name="id" value="${listIpva.id}" />
                                    <div class="mb-3">
						                <label for="exampleAno" class="form-label">Ano </label>
						                <input type="text" class="form-control" id="exampleAno" name="ano2" value="${listIpva.getAno()}" required>
					             	</div>
                                                                 
                            
                                        <button type="submit" name="btnOption" value="update2" class="btn btn-secondary">
                                        Atualizar</button></td>
                                </form>
                            </tr>

                    </c:otherwise>

                </c:choose>
		</form>

   </div>
   
        
        

</body>
</html>