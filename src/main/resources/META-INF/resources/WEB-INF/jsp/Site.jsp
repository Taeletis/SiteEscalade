<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Menu.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link 
  href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
  rel="stylesheet"  type='text/css'>
</head>

<body>

	<div class="container">
		<div class="row">

			<a href="/recherche" class="text-info"><i class="fa fa-arrow-left"></i>revenir a la liste des sites</a>
		</div>


	</div>
	<div class="container">
		<div class="row">
			<div class="media">

				<img class="img-fluid" src="${site.lienImage}">
				<div class="media-body">
					<h5 class="mt-0">${site.nom}</h5><h3> ${site.mention ? '<i class="fa fa-trophy" style="color:gold"></i>' :'' }</h3>
					<c:if test="${grimpeur.membre}">
					<button type="button" class="btn btn-light" data-toggle="modal" data-target="#changermention"><i class="fa fa-gavel"></i></button>

					<!-- Modal -->
					<div class="modal fade" id="changermention" tabindex="-1" role="dialog"
						aria-labelledby="changermentionCenterTitle" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="changermentionLongTitle">donner/retirer la mention</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form method="post" action="" >
									<div class="modal-body">
							          <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="choix" id="accepter" value="true">
  <label class="form-check-label" for="accepter">Avec mention</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio"  name="choix" id="refuser" value="false">
  <label class="form-check-label" for="refuser">Sans mention</label>
  
  <input type="hidden" name="idSite" id="site" value="${site.idSite}"/>
<input type="hidden" name="type" id="type" value="changerMention" />
</div>
										
									</div>
									<div class="modal-footer">
									
										<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
										<button type="submit" class="btn btn-primary">Save changes</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					</c:if>
					<p>${site.lieu}</p>

					<p>cotation : ${cotation}</p>
					<p>
						Crée par <a href="/grimpeur?id=${site.createur.idGrimpeur}">${site.createur.nom}</a>
					</p>
					<a href="/topo?id=${site.idSite}" class="btn btn-success" role="button">reserver un topo</a>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="col ">
				<ul class="nav nav-tabs" id="tabSecteur" role="tablist">
					<c:forEach items="${secteurs}" var="nav">

						<li class="nav-item"><a class="nav-link " id="Secteur${nav.key.idSecteur}-tab"
							data-toggle="tab" href="#Secteur${nav.key.idSecteur}" role="tab"
							aria-controls="Secteur${nav.key.idSecteur}" aria-selected="true">${nav.key.nom}</a></li>

					</c:forEach>
				</ul>
				<div class="tab-content" id="tabSecteurContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab"><div class="jumbotron"><h4>Informations des Secteurs</h4></div></div>
					<c:forEach items="${secteurs}" var="s">
						<div class="tab-pane fade" id="Secteur${s.key.idSecteur}" role="tabpanel"
							aria-labelledby="Secteur${s.key.idSecteur}-tab">
							<div class="card" style="width:18rem">

								<div class="card-boby">
									<a href="/secteur?id=${s.key.idSecteur}"><img class="img-fluid"
										src="${s.key.lienCarte}"></a>

									<p>
										<a href="/secteur?id=${s.key.idSecteur}">${s.key.nom}</a>
									</p>
									<p>Cotation : ${s.value}</p>

									<p>Description: ${s.key.description}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<div class="row">

				<div class="col">
					<h5>Commentaires<button type="button" class="btn btn-info ml-2" data-toggle="modal"
						data-target="#ajouterCommentaire"><i class="fa fa-plus-circle"></i></button></h5>

					<!-- Modal -->
					<div class="modal fade" id="ajouterCommentaire" tabindex="-1" role="dialog"
						aria-labelledby="ajouterCommentaireCenterTitle" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ajouterSiteLongTitle">ajouter un Commentaire</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form method="post" action="">
									<div class="modal-body">


										<label for="FormControlTextarea">Commentaire<span class="requis">*</span></label>
										<textarea class="form-control" id="exampleFormControlTextarea1"name="commentaire" rows="5"></textarea>
										<br /> <input type="hidden" name="idSite" id="site" value="${site.idSite}" /><br /> <br />
												<input type="hidden" name="type" id="type" value="ajouterCommentaire" />

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
			

			<c:forEach items="${commentaires}" var="c">
			
				<div class="row">
					<div class="card">

						<div class="card-body">
							<p class="card-text">${c.description}</p>
							<p class="card-text">
								<small class="text-muted">Créer le ${c.dateParution} modifié le
									${c.dateModification} par ${c.auteur.nom}</small>
							<c:if test="${c.auteur.idGrimpeur == grimpeur.idGrimpeur || grimpeur.membre}"><button type="button" class="btn" data-toggle="modal"
											data-target="#modifierCommentaire${c.idCommentaire}"><i class="fa fa-edit" style="color:orange"></i></button>
										<div class="modal fade" id="modifierCommentaire${c.idCommentaire}" tabindex="-1" role="dialog"
											aria-labelledby="modifierCommentaire${c.idCommentaire}CenterTitle" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="#modifierCommentaire${c.idCommentaire}LongTitle">modifier</h5>
														<button type="button" class="close" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<form method="post" action="">

														<div class="modal-body">
  
  <textarea class="form-control" id="exampleFormControlTextarea1"name="commentaire" rows="5" >${c.description}</textarea>


<input name="idCommentaire" type="hidden" id="modifierCommentaire${c.idCommentaire}" value="${c.idCommentaire}">
<input type="hidden" name="type" id="type" value="modifierCommentaire" />
<input type="hidden" name="idSite" id="site" value="${site.idSite}" />



														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
															<button type="submit" class="btn btn-primary">valider</button>
														</div>
													</form>
												</div>
											</div>
										</div><button type="button" class="btn" data-toggle="modal"
											data-target="#supprimerCommentaire${c.idCommentaire}"><i class="fa fa-times-circle" style="color:red"></i></button>
										<div class="modal fade" id="supprimerCommentaire${c.idCommentaire}" tabindex="-1" role="dialog"
											aria-labelledby="supprimerCommentaire${c.idCommentaire}CenterTitle" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="#supprimerCommentaire${c.idCommentaire}LongTitle">supprimer</h5>
														<button type="button" class="close" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<form method="post" action="">

														<div class="modal-body">
  <div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name="supprimer" id="supprimer" value="supprimer">
  <label class="form-check-label" for="supprimer">Cochez la case pour valider la supression</label>
</div>

<input name="idCommentaire" type="hidden" id="supprimerCommentaire${c.idCommentaire}" value="${c.idCommentaire}">
<input type="hidden" name="type" id="type" value="supprimerCommentaire" />
<input type="hidden" name="idSite" id="site" value="${site.idSite}" />



														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
															<button type="submit" class="btn btn-primary">valider</button>
														</div>
													</form>
												</div>
											</div>
										</div></c:if></p>
						</div>
					</div>
				</div>
			</c:forEach>

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