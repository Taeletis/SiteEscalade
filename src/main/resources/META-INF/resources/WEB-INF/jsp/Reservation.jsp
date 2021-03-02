<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<jsp:include page="Menu.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<body>

		
		
	
			<div class="container">
			<div class="row">
			
		<c:forEach items="${resa}" var="r">
		<c:choose>
         
         <c:when test = "${r.statut.idStatut==1}">
			<div class="card mb-3 bg-light mr-3 border-success"> 
				<a href="/grimpeur?id=${r.emprunteur.idGrimpeur}">De : ${r.emprunteur.nom}</a>
				<p>email : ${r.emprunteur.email}</p>
					<p>Statut : ${r.statut.statut}</p>
				
         <form method="post" action="">
            <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="choix" id="accepter" value="accepter">
  <label class="form-check-label" for="accepter">Accepter</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio"  name="choix" id="refuser" value="refuser">
  <label class="form-check-label" for="accepter">Refuser</label>
</div>
<input name="reservation" type="hidden" id="reservation" value="${r.idReservation}">
<button type="submit" class="btn btn-success mb-1 mr-1">Valider</button>
 </form></div>
         </c:when>
         </c:choose>
				
			</c:forEach>
			</div>
			<div class="container">		
				<div class="row">
			
		<c:forEach items="${resa}" var="r">
		<c:choose>
         
         <c:when test = "${r.statut.idStatut==2}">
			<div class="card mb-3 mr-3 bg-light border-danger"> 
				<a href="/grimpeur?id=${r.emprunteur.idGrimpeur}">De : ${r.emprunteur.nom}</a>
				<p>email : ${r.emprunteur.email}</p>
					<p>Statut : ${r.statut.statut}</p>
				
         </div>
         </c:when>
          <c:when test = "${r.statut.idStatut==3}">
			<div class="card mb-3 mr-3 bg-light border-info"> 
				<a href="/grimpeur?id=${r.emprunteur.idGrimpeur}">De : ${r.emprunteur.nom}</a>
				<p>email : ${r.emprunteur.email}</p>
					<p>Statut : ${r.statut.statut}</p>
				
         </div>
         </c:when>
         </c:choose>
					
			
			</c:forEach>
		
		</div>
		
		</div>
		</div>
		
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>



</body>
</html>