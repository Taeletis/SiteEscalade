<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<button onclick="window.location.href = '/recherche';">Afficher les sites</button>
</br>
</br>
<div>
		<table>
		
		<tr>
				<th>${nom}</th>
				<th>${lieu}</th>
				<th><img src="${lienImage}"></th>
				
			</tr>
	</table>
	<table>
			<tr>
				<th>Nom  des secteurs</th>
				<th>carte</th>
				<th>description</th>
			</tr>
			<c:forEach items="${secteurs}" var="s">
				<tr>
					<td><a href="/secteur?id=${s.idSecteur}">${s.nom}</td>
					<td><img src="${s.lienCarte}"></td>
					<td>${s.description}</td>
				
				</tr>
			</c:forEach>
			
		</table>
		</div>
		
</body>
</html>