<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Menu.jsp"></jsp:include>
</head>

<body>

	<div class="container">
		<div class="row">

			<a href="/recherche" class="text-info"><=revenir a la liste des sites</a>
		</div>


	</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="media">

				<img class="img-fluid" src="${site.lienImage}">
				<div class="media-body">
					<h5 class="mt-0">${site.nom}</h5>
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
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#ajouterCommentaire">ajouter un Commentaire</button>

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
										<textarea class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>
										<br /> <input type="hidden" name="site" id="site" value="${site.idSite}" /><br /> <br />


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
			<div class="row">
				<div class="col">
					<h5>Commentaires</h5>
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
							</p>

						</div>
					</div>
				</div>
			</c:forEach>

		</div>

	</div>

</body>
</html>