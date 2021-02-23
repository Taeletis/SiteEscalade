<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Menu.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>recherche avancé</title>
</head>

<body style="background-color: #eeeeee">
<div class="container">

	<div class="row">
	<div class="card">
							<div class="col">
							Bienvenu ${grimpeur.nom}</div>
							</div>
							</div>
							</div>
	</br>
	</br>


	<div class="card bg-light">
		<div class="card-body ">
			<div class="container">
			<div class="row">
				<form method="post" action="">
					<div class="form-row">


							  <div class="form-group">
								<label for="nom">nom </label>
							</div>
							  <div class="form-group">
								<input type="text" id="nom" name="nom" value="" size="20"
									maxlength="60" />
							</div>
							  <div class="form-group">
								<label for="lieu">lieu </label>
							</div>
							 <div class="form-group">
								<input type="text" id="lieu" name="lieu" value="" size="20"
									maxlength="20" />
							</div>
							<div class="form-group">

								<label for="lieu">propriétaire</label>
							</div>
							  <div class="form-group">
								<input type="text" id="grimpeur" name="grimpeur" value=""
									size="20" maxlength="20" />
								</div>
							
								<button type="submit" class="btn btn-primary">Recherche</button>
</div>
							
					


				</form>

					</div>

				<div class="row">
					<div class="col-md">Nom</div>


					<div class="col-md">Cotation</div>

					<div class="col-md">lieu</div>

					<div class="col-md">Créateur</div>

					<div class="col-md">lienImage</div>


				</div>
			
							<c:forEach items="${sites}" var="s">
								<c:forEach items="${s.value}" var="v">
									<div class="card">


										<div class="row">

											<div class="col">
												<a class="btn btn-light" href="/site?id=${s.key.idSite}" role="button">${s.key.nom} </a>
											</div>


											<div class="col">${v.value}</div>
											<div class="col">${s.key.lieu}</div>
											<div class="col">
												<a class="btn btn-light" href="/grimpeur?id=${v.key.idGrimpeur}" role="button">${v.key.nom}</a>
											</div>
											<div class="col">
												<img class=”card-img-top” src="${s.key.lienImage}">
											</div>


										</div>
									</div>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
			

	</div>
	<div class="alert alert-success alert-dismissible fade show" role="alert">
   <h5 class="alert-heading">Prérequis</h5>
   <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">×</span>
   </button>
</div>

    
  <div class="bg-light">
    <div class="container">
      <div class="row">
        <div class="col">
          <ul class="list-inline text-center">
            <li class="list-inline-item"><a href="#">About Us</a></li>
            <li class="list-inline-item">&middot;</li>
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item">&middot;</li>
            <li class="list-inline-item"><a href="#">Terms of Use</a></li>
          </ul>
        </div>
      </div>
    </div>  
  </div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>