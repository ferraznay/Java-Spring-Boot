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
            <a class="navbar-brand" href="#">CRUD Carros</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link " href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            Carros
                        </a>
                       
                    </li>
                          <li class="nav-item dropdown">
                        <a class="nav-link " href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            IPVA
                        </a>
                       
                    </li>
                </ul>
            </div>
</nav>
     

   <!---------------- LISTA CARRO------------------>

	<hr>
	<div class="container">
        <h2> Lista de Carros</h2>
          <div class="container">
    	<form action="CRUDControllerCarro" method="post">
		<button type="submit" name="btnOption" value="newform" class="btn btn-primary display-flex">Adicionar Carro</button>	
		</form>
	</div>
       
        </div>
        

	<hr>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Modelo</th>
					<th scope="col">Ano</th>
					<th scope="col">IPVA</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			
  			<tbody>
    			<c:forEach var="carro" items="${listCarro}">
                            <tr>
                                <form action="CRUDControllerCarro" method="post">
                                    <td><c:out value="${carro.id}" />
                                    <input type="hidden" name="txtId" value="${carro.id}" />
                                    </td>
                                    <td><c:out value="${carro.getModel()}" /></td>
                                    <td><c:out value="${carro.getAno()}" /></td>
                                    
                                    <td>  
                                    
	                                    <c:if test="${listIpva.getAno() == null}">
	                                    	<c:out value="PAGA IPVA" />
	                                    </c:if>
	                                    <c:if test="${carro.getAno() > listIpva.getAno()}" >
	                                    <c:out value="PAGA IPVA" />
	                                    </c:if>
	                                     <c:if test="${carro.getAno() <=  listIpva.getAno()}" >
	                                    	<c:out value="NÃO PAGA IPVA" />
	                                    </c:if>
                                                                       
                                     </td>
                                    <td>
	                                    <button type="submit" name="btnOption" value="delete" class="btn btn-secondary me-2 ms-2">
	                                    Deletar</button>
	                                    <button type="submit" name="btnOption" value="updateform" class="btn btn-secondary">
	                                    Atualizar</button>
                                    </td>
                                    
                                </form>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            
            <!----------------LISTA IPVA------------------>

<hr>

			<div class="container">
			<h2> Lista IPVA</h2>
				<div class="row d-flex justify-contente-center">
					<c:if test="${listIpva == null }">
					<form action="CRUDControllerCarro" method="post">
						<button type="submit" name="btnOption" value="newform2" class="btn btn-primary display-flex">
						Adicionar IPVA</button>	
					</form>
					</c:if>
					<c:if test="${listIpva != null }">
						<form action="CRUDControllerCarro" method="post">
							<button type="submit" name="btnOption" value="newform2" class="btn btn-primary display-flex" disabled>
							Adicionar IPVA</button>	
						</form>
					</c:if>
					
					<div class="row">
						<table class="table table-bordered">
							<thead>
								<th scope="col">Id</th>
								<th scope="col">Ano</th>
								<th scope="col">Ações</th>														
							
							</thead>
							<br><br>
							<tbody>
							
								<c:choose>
									<c:when test="${listIpva == null }">
									</c:when>
									<c:otherwise>
										<tr>
											<form action="CRUDControllerCarro" method="post">
											<input type="hidden" name="id" value="${listIpva.id}" />
											<td> <c:out value="${listIpva.id}"></c:out></td>
											<td> <c:out value="${listIpva.ano}"></c:out></td>
											
									  
											
									  <td>
									  
	                                    <button type="submit" name="btnOption" value="delete2" class="btn btn-secondary me-2 ms-2">
	                                    Deletar</button>
	                                    <button type="submit" name="btnOption" value="updateform2" class="btn btn-secondary">
	                                    Atualizar</button>
                                    </td>
                                    </form>
								</tr>	
									</c:otherwise>
								
								</c:choose>
			
						
	 				</tbody>
				</table>
</div>
	      
        
</body>
</html>