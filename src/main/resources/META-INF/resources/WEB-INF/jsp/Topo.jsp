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
	Bienvenu ${grimpeur.nom}
	</br>
	</br>
	</br>
	</br>
	<button onclick="window.location.href = '/site?id=${site.idSite}';">revenir
		au site</button>
	</br>
	</br>
	</br> liste des topo du site ${site.nom}
	</br>
	</br>
	===================================================================================================================
	</br>
	</br>


	<c:forEach items="${topos}" var="t">
		<div>
			<table>
				<tr>

					<td>${t.nom}</td>
					<td>${t.lieu}</td>
					<td>${t.dateParution}</td>
					<td>par ${t.proprietaire.nom}</td>
					<td>// topo ${ t.disponible ? 'disponible' : 'indisponible' }</td>
				</tr>

			</table>
		</div>
		<c:choose>
			<c:when test="${t.disponible}">
				<form method="post" action="">
					<fieldset>
						<legend>Voulez vous reserver?</legend>
								<input name="idTopo" type="hidden" value="${t.idTopo}">
						<br /> <input name="idGrimpeur" type="hidden" value="${grimpeur.idGrimpeur}">
						<input type="submit" value="reserver" class="sansLabel" /> <br />

					</fieldset>
				</form>
				</c:when>
				<c:otherwise>
				<fieldset>Vous ne pouvez pas reserver ce topo</fieldset>
			</c:otherwise>
		</c:choose>
		=====================================================================
				</c:forEach>



</body>
</html>