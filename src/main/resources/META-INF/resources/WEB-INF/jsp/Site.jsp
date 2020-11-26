<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
		
		<tr>
				<th>${nom}</th>
				<th>${lieu}</th>
				<th>${lienImage}</th>
				
			</tr>
		
		
		
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