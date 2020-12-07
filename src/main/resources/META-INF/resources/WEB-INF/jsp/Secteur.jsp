<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	Bienvenu ${grimpeur.nom}
	</br>
	</br>
	</br>
	</br>
	<button onclick="window.location.href = '/recherche';">Afficher
		les sites</button>
	<button onclick="window.location.href = '/site?id=${idSite}';">revenir
		au site</button>
	</br>
	</br>
	<div>
		<table>
			<tr>
				<th>nom</th>
				<th>descrption</th>
				<th>carte</th>

			</tr>
			<tr>
				<th>${nom}</th>
				<th>${descrption}</th>
				<th><img src="${lienImage}"></th>

			</tr>
		</table>
		<table>
			<c:forEach items="${voies}" var="v">
				<c:forEach items="${v.key}" var="list">
					<tr>

						<td>${list.key.nom}</td>
						<td>${list.key.annotation}</td>
						<td>${list.value}</td>
					</tr>

					<tr>
						<td>longueurs de la voie</td>
					</tr>
					<tr>
						<th>hauteur</th>
						<th>cotation</th>

					</tr>
				</c:forEach>
				
				<c:forEach items="${v.value}" var="l">

					<tr>
						<td>${l.hauteur}m de hauteur</td>
						<td>${l.cotation}</td>

					</tr>

				</c:forEach>
				
			</c:forEach>

		</table>
	</div>

</body>
</html>