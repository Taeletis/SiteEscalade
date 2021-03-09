<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<jsp:include page="Menu.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<body>
	
<div class="container">
		
		<div class="row">

			<div class="col">
				<p>
					Nom : ${grimpeur.nom}
				</p>
		
				<p>Prénom : ${grimpeur.prenom}</p>
			
				<p>Statut : ${ grimpeur.membre ? 'admin' : 'membre' }</p>

				<p>Email :  ${grimpeur.email}</p>
			</div>

			<div class="col">
		
			<button type="button" class="btn btn-warning" data-toggle="modal"
									data-target="#maj">Mettre à jour ses informations</button>

								<!-- Modal -->
								<div class="modal fade" id="maj" tabindex="-1" role="dialog"
									aria-labelledby="majCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="majTitle">Modifier</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<form method="post" action="">
												<div class="modal-body">





													 <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="${grimpeur.nom}" size="20" maxlength="20" />
                <br />
                
                <label for="nom">Prenom<span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" value="${grimpeur.prenom}" size="20" maxlength="20" />
                <br />

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="${grimpeur.email}" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
 
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

              	<input name="action1" type="hidden" value="inscription">


												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Save changes</button>
												</div>

											</form>
										</div>
									</div>
								</div>
	</div>
								</div>
									
		</div>
				<div class="container">
			<div class="row">
			
		<c:forEach items="${Reservations}" var="r">
		<c:choose>
         
         <c:when test = "${r.statut.idStatut==1}">
			<div class="card mb-3 bg-light mr-3 border-success"> 
				<a href="/grimpeur?id=${r.emprunteur.idGrimpeur}">Avec : ${r.topo.site.createur.nom}</a>
				<p>email : ${r.topo.site.createur.email}</p>
				<p>Pour : ${r.topo.nom}</p>
					<p>Statut : ${r.statut.statut}</p>
		</div>
         </c:when>
         </c:choose>
				
			</c:forEach>
			</div>
			<div class="container">		
				<div class="row">
			
		<c:forEach items="${Reservations}" var="r">
		<c:choose>
         
         <c:when test = "${r.statut.idStatut==2}">
			<div class="card mb-3 mr-3 bg-light border-danger"> 
				<a href="/grimpeur?id=${r.emprunteur.idGrimpeur}">Avec : ${r.topo.site.createur.nom}</a>
				<p>email : ${r.topo.site.createur.email}</p>
				<p>Pour : ${r.topo.nom}</p>
					<p>Statut : ${r.statut.statut}</p>
				
         </div>
         </c:when>
          <c:when test = "${r.statut.idStatut==3}">
			<div class="card mb-3 mr-3 bg-light border-info"> 
				<a href="/grimpeur?id=${r.emprunteur.idGrimpeur}">Avec : ${r.topo.site.createur.nom}</a>
				<p>email : ${r.topo.site.createur.email}</p>
				<p>Pour : ${r.topo.nom}</p>
					<p>Statut : ${r.statut.statut}</p>
				
         </div>
         </c:when>
         </c:choose>
					
			
			</c:forEach>
		
		</div>
		
		</div>
		</div>
		
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>



</body>
</html>