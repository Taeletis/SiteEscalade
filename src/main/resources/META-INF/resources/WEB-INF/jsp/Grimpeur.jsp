<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="Menu.jsp"></jsp:include>
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
					<td> ${ g.membre ? 'admin' : 'membre' }</td>
					<td>${g.email}</td>
					<th><form method="post" action="recherche">
					<input type="hidden" name="grimpeur" id="grimpeur" value="${g.nom}" />
					 <input type="submit" value="liste des sites" class="sansLabel" /> </form></th>
					
				</tr>

			</table>
		</div>
	


</body>
</html>