<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<button onclick="window.location.href = '/recherche';">Afficher les sites</button>
</br>
</br>
		<table>
		
		<tr>
				<th>${nom}</th>
				<th>${lieu}</th>
				<th><img src="${lienImage}"></th>
				
			</tr>
		</br>
		</br>
		
			<tr>
				<th>Nom</th>
				<th>carte</th>
				<th>description</th>
			</tr>
			<c:forEach items="${secteur}" var="s">
				<tr>
					<td><a href="/site?secteur=${s.idSecteur}">${s.nom}</a></td>
					<td>${s.lienCarte}</td>
					<td><img src="${s.description}"></td>
				
				</tr>
			</c:forEach>
		</table>
		</div>
</body>
</html>