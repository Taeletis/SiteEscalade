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

	</br>
	</br>
	===================================================================================================================
	</br>
	</br>

		<div>
			<table>
				<tr>
					<td>${g.nom}</td>
					<td>${g.prenom}</td>
					<td> ${ g.Membre ? 'admin' : 'membre' }</td>
					<td>${g.email}</td>
					<th> <a href="/Recherche?id=${g.idGrimpeur}">liste des sites </a></th>
					
				</tr>

			</table>
		</div>
	


</body>
</html>