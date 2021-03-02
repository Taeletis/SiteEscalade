<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="Menu.jsp"></jsp:include>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Insert title here</title>

</head>

<body>

	<div class="container">
		<div class="row">

			<div class="col-auto alert alert-primary ">

				<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist"
					aria-orientation="vertical">
					<c:forEach items="${sites}" var="nav">


						<a class="nav-item nav-link mb-2" id="Site${nav.key.idSite}-tab" data-toggle="tab"
							href="#Site${nav.key.idSite}" role="tab" aria-controls="Site${nav.key.idSite}"
							aria-selected="false">${nav.key.nom}</a>

					</c:forEach>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-success" data-toggle="modal" data-target="#ajouterSite">ajouter
						un Site</button>

					<!-- Modal -->
					<div class="modal fade" id="ajouterSite" tabindex="-1" role="dialog"
						aria-labelledby="ajouterSiteCenterTitle" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ajouterSiteLongTitle">ajouter un Site</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form method="post" action="">
									<div class="modal-body">


										<label for="nom">nom du site<span class="requis">*</span></label> <input type="text"
											id="nom" name="nom" value="" size="20" maxlength="60" /> <br /> <label for="lieu">lieu<span
											class="requis">*</span></label> <input type="text" id="lieu" name="lieu" value="" size="20"
											maxlength="60" /> <br /> <label for="image">image</label> <input type="file"
											name="image" id="image" /><br /> <input type="hidden" name="type" id="type"
											value="site" /><br /> <br />


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
			<form method="post" action=""></form>
			<div class="col ">
				<div class="tab-content" id="v-pills-tabContent">
					<c:forEach items="${sites}" var="s">



						<div class="tab-pane fade" id="Site${s.key.idSite}" role="tabpanel"
							aria-labelledby="Site${s.key.idSite}-tab">



							<h4>
								<a href="/monSite?id=${s.key.idSite}">${s.key.nom}</a>
							</h4
							>

							<p>
								<a href="/monSite?id=${s.key.idSite}"><img src="${s.key.lienImage}" width="200"
									height="150"></a>
							</p>
							<p>Lieu : ${s.key.lieu}</p>
							<!-- Button trigger modal -->
							<p>
								<button type="button" class="btn btn-warning" data-toggle="modal"
									data-target="#modifierSite">Modifer</button>
							</p>


							<!-- Modal -->
							<div class="modal fade" id="modifierSite" tabindex="-1" role="dialog"
								aria-labelledby="modifierSiteCenterTitle" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLongTitle">Modifier</h5>
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<form method="post" action="">
											<div class="modal-body">

												<label for="nom">nom du site<span class="requis">*</span></label> <input type="text"
													id="nom" name="nom" value="${s.key.nom}" size="20" maxlength="60" /> <br /> <label
													for="lieu">lieu<span class="requis">*</span></label> <input type="text" id="lieu"
													name="lieu" value="${s.key.lieu}" size="20" maxlength="60" /> <br /> <label
													for="image">image</label> <input type="checkbox" id="modfierImage" name="modfierImage">
												<label for="modfierImage">modifier l'Image</label> <input type="file" name="image"
													id="image" /><br /> <input type="hidden" name="idSite" id="idSite"
													value="${s.key.idSite}" /><br /> <input type="hidden" name="type" id="type"
													value="site" /><br /> <br />

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
												<button type="submit" class="btn btn-primary">Save changes</button>
											</div>
										</form>
									</div>
								</div>
							</div>
							<ul class="nav nav-tabs" id="tabTopo" role="tablist">
								<c:forEach items="${s.value}" var="nav2">

									<li class="nav-item"><a class="nav-link " id="Topo${nav2.idTopo}-tab"
										data-toggle="tab" href="#Topo${nav2.idTopo}" role="tab" aria-controls="Topo${nav2.idTopo}"
										aria-selected="true">${nav2.nom}</a></li>

								</c:forEach>




								<li>
									<!-- Button trigger modal -->

									<button type="button" class="btn btn-success" data-toggle="modal"
										data-target="#ajouterTopo${s.key.idSite}">Ajouter un topo</button>
									<div class="modal fade" id="ajouterTopo${s.key.idSite}" tabindex="-1" role="dialog"
										aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
										<div class="modal-dialog modal-dialog-centered" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="#ajouterTopo${s.key.idSite}LongTitle">Ajouter un topo</h5>
													<button type="button" class="close" data-dismiss="modal" aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<form method="post" action="">

													<div class="modal-body">



														<label for="nom">nom du topo<span class="requis">*</span></label> <input type="text"
															id="nom" name="nom" value="" size="20" maxlength="60" /> <br /> <label for="lieu">lieu<span
															class="requis">*</span></label> <input type="text" id="lieu" name="lieu" value="" size="20"
															maxlength="60" /> <br /> <input type="checkbox" id="disponible" name="disponible">
														<label for="disponible">Disponible</label> <input type="hidden" name="idSite"
															id="idSite" value="${s.key.idSite}" /><br /> <input type="hidden" name="type"
															id="type" value="topo" /><br /> <br />


													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
														<button type="submit" class="btn btn-primary">Save changes</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</li>
							</ul>
							<div class="tab-content" id="myTabContent">
								<c:forEach items="${s.value}" var="t">


									<div class="tab-pane fade " id="Topo${t.idTopo}" role="tabpanel"
										aria-labelledby="Topo${t.idTopo}-tab">


										<p>Nom : ${t.nom}</p>
										<p>Lieu : ${t.lieu}</p>
										<p>Créer le : ${t.dateParution}</p>
										<p>${ t.disponible ? 'disponible' : 'indisponible' }</p>
										<button type="button" class="btn btn-success" data-toggle="modal"
											data-target="#modifierTopo${t.idTopo}">modifier</button>
										<div class="modal fade" id="modifierTopo${t.idTopo}" tabindex="-1" role="dialog"
											aria-labelledby="modifierTopo${t.idTopo}lCenterTitle" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="#modifierTopo${t.idTopo}LongTitle">Modifier</h5>
														<button type="button" class="close" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<form method="post" action="">

														<div class="modal-body">

															<label for="nom">nom du topo<span class="requis">*</span></label> <input type="text"
																id="nom" name="nom" value="${t.nom}" size="20" maxlength="60" /> <br /> <label
																for="lieu">lieu<span class="requis">*</span></label> <input type="text" id="lieu"
																name="lieu" value="${t.lieu}" size="20" maxlength="60" /> <br /> <input
																type="checkbox" id="disponible" name="disponible"> <label for="disponible">Disponible</label>
															<input type="hidden" name="idTopo" id="idTopo" value="${t.idTopo}" /><br /> <input
																type="hidden" name="type" id="type" value="modifierTopo" /><br /> <br /> <br />
															<input type="submit" value="modifier le topo" class="sansLabel" /> <br />


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

								</c:forEach>
							</div>


						</div>


					</c:forEach>

				</div>
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