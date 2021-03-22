<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Menu.jsp"></jsp:include>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link 
  href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
  rel="stylesheet"  type='text/css'>
<meta charset="UTF-8">
<title>recherche avancé</title>
</head>

<body style="background-color: #eeeeee">
	


	<div class="container">
	<div class="row">
	<div class="col mb-3">
						<a href="/recherche" class="btn btn-success" role="button">rafraichir les filtres</a>
					</div>
					</div>
				<form method="post" action="">
					 <div class="form-row mb-3">
    <div class="col">

							<label for="nom">nom </label>
						
							<input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
						</div>
						<div class="col">
							<label for="lieu">lieu </label>
						
							<input type="text" id="lieu" name="lieu" value="" size="20" maxlength="20" />
						</div>
						<div class="col">

							<label for="lieu">propriétaire</label>
						
							<input type="text" id="grimpeur" name="grimpeur" value="" size="20" maxlength="20" />
						</div>
						<div class="col">
						<button type="submit" class="btn btn-primary">Recherche</button>
					
					</div>
					

</div>



				</form>
				
					
				
	
			
		<div class="row">
		<div class="table-responsive">
			<table class="table">

				<thead class="thead-dark">
					<tr>
						<th scope="col">Nom</th>
						
						<th scope="col">Cotation</th>
						<th scope="col">Lieu</th>
						<th scope="col">Créateur</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${sites}" var="s">
						<c:forEach items="${s.value}" var="v">

							<tr>
								<th scope="row"><a class="btn btn-light" href="/site?id=${s.key.idSite}" role="button">${s.key.nom}
								</a><a  href="/site?id=${s.key.idSite}" role="button"><img class="img-fluid" src="${s.key.lienImage}"></a>
								<h3> ${s.key.mention ? '<i class="fa fa-trophy" style="color:gold"></i>' :'' }</h3></th>
								

								<td>${v.value}</td>
								<td>${s.key.lieu}</td>
								<td><a class="btn btn-light" href="/grimpeur?id=${v.key.idGrimpeur}" role="button">${v.key.nom}</a>
								</td>


							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
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
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"></script>

</body>
</html>