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
<button onclick="window.location.href = '/topo?id=${site.idSite}';">reserver un topo</button>
</br>
</br>
<div>
		<table>
		
		<tr>
				<th>${site.nom}</th>
				<th>${site.lieu}</th>
				<th><img src="${site.lienImage}"></th>
				<th>cotation : ${cotation}</th>
				<th>Crée par <a href="/grimpeur?id=${site.createur.idGrimpeur}">${site.createur.nom}</a></th>
			</tr>
	</table>
	<table>
			<tr>
				<th>Nom  des secteurs</th>
				<th>cotation</th>
				<th>carte</th>
				<th>description</th>
			</tr>
			<c:forEach items="${secteurs}" var="s">
				<tr>
					<td><a href="/secteur?id=${s.key.idSecteur}">${s.key.nom}</a></td>
					<td>${s.value}</td>
					<td><img src="${s.key.lienCarte}"></td>
					<td>${s.key.description}</td>
				
				</tr>
			</c:forEach>

		</table>
		</div>
		
		=============Commentaires========================
		<div>
		<table>
		
		<c:forEach items="${commentaires}" var="c">
		<tr>
		<td>${c.description}</td>
		<td>Créer le ${c.dateParution}</td>
		<td>modifié le ${c.dateModification}</td>
		<td> par ${c.auteur.nom}</td>
				</tr>
				<tr><td>===================================</td>
				</tr>
			</c:forEach>
			
		</table>
		</div>
</body>
</html>