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
	<div class="container">
		
		<div class="row">

			<div class="col">
			
			<h5>
					Profil du Grimpeur
				</h5>
				<p>
					Nom : ${g.nom}
				</p>
		
				<p>Prénom : ${g.prenom}</p>
			
				<p>Statut : ${ g.membre ? 'admin' : 'membre' }</p>

				<p>Email : ${g.email}</p>
			</div>
	</div>
		
	
</div>
		

</body>
</html>