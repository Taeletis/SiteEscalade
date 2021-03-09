<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Menu.jsp"></jsp:include>
<link 
  href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
  rel="stylesheet"  type='text/css'>
</head>

<body>
	<div class="container">
	

<div class="row">
			<div class="col mb-3">
				<a  href="/site?id=${site.idSite}" class="text-info"><i class="fa fa-arrow-left"></i>revenir au site </a>
			</div>
			
		</div>
<div class="row">
<div class="table-responsive">
<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">nom</th>
											<th scope="col">lieu</th>
											<th scope="col">Date de parution</th>
											<th scope="col">Cr�er par</th>
											<th scope="col"></th>
											

									</thead>
	<c:forEach items="${topos}" var="t">
									<tbody>
		
							

											<c:set var="count" value="${count + 1}" scope="page" />
										


		
				<tr>
<th scope="row">${count}</th>
					<td>${t.nom}</td>
					<td>${t.lieu}</td>
					<td>${t.dateParution}</td>
					<td>${t.proprietaire.nom}</td>
					<td> ${ t.disponible ? '<i class="fa fa-check-circle" style="color:green"></i>' : '<i class="fa fa-minus-circle" style="color:red"></i>' }
				

		<c:choose>
			<c:when test="${t.disponible}">
				<form method="post" action="">
					
						
						<input name="idTopo" type="hidden" value="${t.idTopo}">
						<input name="idGrimpeur" type="hidden" value="${grimpeur.idGrimpeur}">
						<input type="submit" value="reserver" class="sansLabel" />

				
				</form>
				</c:when>
				<c:otherwise>
				
			</c:otherwise>
		</c:choose>
		</td>
		</tr>
		</c:forEach>

									</tbody>
								</table>
								</div>
</div>
</div>
</body>
</html>