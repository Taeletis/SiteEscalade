<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<title>Insert title here</title>
</head>
<body style="background-color: #eeeeee">
	<div class="bg-dark">
		<div class="container">

			<nav class=" navbar navbar-expand-lg navbar-dark">
				<a class="navbar-brand" href="/recherche" >Liste des sites</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarContent" aria-controls="navbarContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarContent">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link"
							href="/connexion">Connexion</a></li>
						<li class="nav-item"><a class="nav-link" href="/compte">Mon
								Profil</a></li>
						<li class="nav-item"><a class="nav-link" href="/mesSites">Mes
								Sites</a></li>
								<li class="nav-item"><a class="nav-link" href="/reservation">Mes
								Notifications <c:if test="${ notif > 0}" var="maVariable" scope="session"><span class="badge badge-light">
    ${notif}</span></c:if></a></li>
					</ul>
				</div>
			
				
				
				
			</nav>
		</div>
	</div>
	<div class="container">
		<div class="jumbotron">
			<h1>Bienvenue chez Les Amis de l'escalade</h1>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>