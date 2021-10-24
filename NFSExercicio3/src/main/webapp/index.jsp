<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercicio 3</title>
</head>
<body>
	
          
 	<c:set var="n1" value = "10"/>
 	<c:set var="n2" value = "30"/>
    <c:set var="conta" value = "${n1*n2}"/> 
    <c:set var="multiplicacao" value = "true"/> 
    
     <c:if test="${multiplicacao}">
     <p> O programa conseguiu fazer a multiplicação: <c:out value="${multiplicacao}"/></p>
     </c:if>
        
    <h2> A multiplicação dos números <c:out value="${n1}"/> * <c:out value="${n2}"/> = <c:out value="${conta}"/></h2>
              
     <c:choose>
     	   	
     
      	 <c:when test = "${conta < 100}">
           <h2> A multiplicação dos números é menor que 100 </h2> 
         </c:when>
         
         <c:when test = "${conta > 100}">
           <h2> A multiplicação dos números é maior que 100  </h2> 
         </c:when>
          <c:otherwise>
           <c:out value="${conta}"/>
         </c:otherwise>
      </c:choose>
      
  
</body>
</html>