<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Menu.jsp"></jsp:include>
</head>

<body>
	<div class="container">
	<div class="row">
			
			<div class="col">
				<a class="btn btn-light" href="/site?id=${site.idSite}" role="button">revenir au site </a>
			</div>
		</div>


<div class="row">

<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">nom</th>
											<th scope="col">lieu</th>
											<th scope="col">Date de parution</th>
											<th scope="col">Créer par</th>
											<th scope="col">disponibilité</th>
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
					<td> ${ t.disponible ? 'disponible' : 'indisponible' }</td>
				
<td>
		<c:choose>
			<c:when test="${t.disponible}">
				<form method="post" action="">
					
						
						<input name="idTopo" type="hidden" value="${t.idTopo}">
						<input name="idGrimpeur" type="hidden" value="${grimpeur.idGrimpeur}">
						<input type="submit" value="reserver" class="sansLabel" />

				
				</form>
				</c:when>
				<c:otherwise>
				<P>Vous ne pouvez pas reserver ce topo</P>
			</c:otherwise>
		</c:choose>
		</td>
		</tr>
		</c:forEach>

									</tbody>
								</table>
</div>
</div>
</body>
</html>