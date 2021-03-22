<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link 
  href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
  rel="stylesheet"  type='text/css'>
<jsp:include page="Menu.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<div class="container">
<div class="row ">
<a href="/mesSites" class="text-info"><i class="fa fa-arrow-left"></i>revenir a la liste de mes sites</a>
</div>
<div class="row ">
<div class="card">
		
		
				<h3>${site.nom}</h3>
		
			
				<p>Lieu : ${site.lieu}</p>
		
			
				<p>
					<img src="${site.lienImage}" class="img-fluid">
				</p>
		
		</div>
	</div>
	</div>
	
				
			
	<div class="container">
		<div class="row ">


			<div class="col-auto alert alert-primary">
			
				<div class="nav flex-column nav-pills " id="v-pills-tab" role="tablist"
					aria-orientation="vertical">
					<c:forEach items="${secteurs}" var="nav">
						<c:forEach items="${nav.key}" var="navS">

							<a class=" nav-link  mb-2" id="Secteur${navS.key.idSecteur}-tab" data-toggle="tab"
								href="#Secteur${navS.key.idSecteur}" role="tab" aria-controls="Secteur${navS.key.idSecteur}"
								aria-selected="false">${navS.key.nom}</a>

						</c:forEach>
					</c:forEach>
<!-- Button trigger modal -->
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#exampleModalCenter">Ajouter un secteur</button>

	<!-- Modal -->
				<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLongTitle">Ajouter un secteur</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form method="post" action="" enctype="multipart/form-data">
								<div class="modal-body">

									<label for="nom">nom du Secteur<span class="requis">*</span></label> <input type="text"
										id="nom" name="nom" value="" size="20" maxlength="60" /> <br /> <label for="description">description<span
										class="requis">*</span></label> <input type="text" id="description" name="description" value=""
										size="20" maxlength="60" /> <br /> <label for="carte">carte</label> <input type="file"
										name="carte" id="carte" accept="image/*" /><br /> <input type="hidden" name="type"
										id="type" value="secteur" /><br /> <input type="hidden" name="idSite" id="idSite"
										value="${site.idSite}" /><br /> <br />

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
			<div class="col">
				<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab"><div class="jumbotron"><h4>Informations des Secteurs</h4></div></div>
					<c:forEach items="${secteurs}" var="s">



						<c:forEach items="${s.key}" var="s1">


							<div class="tab-pane fade" id="Secteur${s1.key.idSecteur}" role="tabpanel"
								aria-labelledby="Secteur${s1.key.idSecteur}-tab">




								<p>${s1.key.nom}<button type="button" class="btn" data-toggle="modal"
											data-target="#supprimerSecteur${s1.key.idSecteur}"><i class="fa fa-times-circle" style="color:red"></i></button></p>
										<div class="modal fade" id="supprimerSecteur${s1.key.idSecteur}" tabindex="-1" role="dialog"
											aria-labelledby="supprimerSecteur${s1.key.idSecteur}CenterTitle" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="supprimerSecteur${s1.key.idSecteur}LongTitle">supprimer</h5>
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

<input name="idSecteur" type="hidden" id="supprimerSecteur${s1.key.idSecteur}" value="${s1.key.idSecteur}">
<input type="hidden" name="type" id="type" value="supprimerSecteur" />



														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
															<button type="submit" class="btn btn-primary">valider</button>
														</div>
													</form>
												</div>
											</div>
										</div>
								<p>${s1.key.description}</p>
								<p>
									<img src="${pageContext.request.contextPath}${s1.key.lienCarte}" class="img-fluid"/>
								</p>
								<p>${s1.value} <button type="button" class="btn btn-warning" data-toggle="modal"
									data-target="#mofifierSecteur${s1.key.idSecteur}" ><i class="fa fa-edit"></i></button></p>
								<!-- Button trigger modal -->
								

								<!-- Modal -->
								<div class="modal fade" id="mofifierSecteur${s1.key.idSecteur}" tabindex="-1" role="dialog"
									aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Modifier</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<form method="post" action="" enctype="multipart/form-data">
												<div class="modal-body">





													<label for="nom">nom du Secteur<span class="requis">*</span></label> <input type="text"
														id="nom" name="nom" value="${s1.key.nom}" size="20" maxlength="60" /> <br /> <label
														for="description">description<span class="requis">*</span></label> <input type="text"
														id="description" name="description" value="${s1.key.description}" size="20"
														maxlength="60" /> <br /> <label for="carte">carte</label> <input type="checkbox"
														id="modifierImage" name="modifierImage"> <label for="modfierImage">modifierImage</label>
													<input type="file" name="carte" id="carte" value="" /> <input type="hidden"
														name="type" id="type" value="modifierSecteur" /> <input type="hidden"
														name="idSecteur" id="idSecteur" value="${s1.key.idSecteur}" />


												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Save changes</button>
												</div>

											</form>
										</div>
									</div>
								</div>



								<p>Les Voies</p>
<ul class="nav nav-tabs" id="myTab" role="tablist">
<c:forEach items="${s.value}" var="nav2">
									<c:forEach items="${nav2.key}" var="navV">
  <li class="nav-item">
    <a class="nav-link " id="Voie${navV.key.idVoie}-tab" data-toggle="tab" href="#Voie${navV.key.idVoie}" role="tab" aria-controls="Voie${navV.key.idVoie}" aria-selected="true">${navV.key.nom}</a>
  </li>
 
  </c:forEach>



					</c:forEach>
					<li>
					<!-- Button trigger modal -->
					 
								<button type="button" class="btn btn-success" data-toggle="modal"
									data-target="#ajouterVoie${s1.key.idSecteur}">Ajouter une voie</button>
									 </li>
</ul>
<div class="tab-content" id="myTabContent">

<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab"><div class="jumbotron"><h4>Informations des Voies</h4></div></div>
								<c:forEach items="${s.value}" var="s2">
									<c:forEach items="${s2.key}" var="v">
										
							
										<div class="tab-pane fade " id="Voie${v.key.idVoie}" role="tabpanel" aria-labelledby="Voie${v.key.idVoie}-tab">
											


												<p>${v.key.nom}<button type="button" class="btn" data-toggle="modal"
											data-target="#supprimerVoie${v.key.idVoie}"><i class="fa fa-times-circle" style="color:red"></i></button></p>
										<div class="modal fade" id="supprimerVoie${v.key.idVoie}" tabindex="-1" role="dialog"
											aria-labelledby="supprimerVoie${v.key.idVoie}CenterTitle" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="supprimerVoie${v.key.idVoie}LongTitle">supprimer</h5>
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

<input name="idVoie" type="hidden" id="supprimerVoie${v.key.idVoie}" value="${v.key.idVoie}">
<input type="hidden" name="type" id="type" value="supprimerVoie" />



														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
															<button type="submit" class="btn btn-primary">valider</button>
														</div>
													</form>
												</div>
											</div>
										</div>
												<p>${v.key.annotation}</p>
												<p>
													Cotation: ${v.value}


													<!-- Button trigger modal -->
													<button type="button" class="btn btn-primary" data-toggle="modal"
														data-target="#modifierVoie${v.key.idVoie}"><i class="fa fa-edit"></i></button>
												</p>
												<!-- Modal -->
												<div class="modal fade" id="modifierVoie${v.key.idVoie}" tabindex="-1" role="dialog"
													aria-labelledby="mofifierVoie${v.key.idVoie}" aria-hidden="true">
													<div class="modal-dialog modal-dialog-centered" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLongTitle">modifier</h5>
																<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																	<span aria-hidden="true">&times;</span>
																</button>
															</div>
															<form method="post" action="">
																<div class="modal-body">



																	<label for="nom">nom de la Voie<span class="requis">*</span></label> <input
																		type="text" id="nom" name="nom" value="${v.key.nom}" size="20" maxlength="60" />
																	<br /> <label for="annotation">annotation<span class="requis">*</span></label> <input
																		type="text" id="annotation" name="annotation" value="${v.key.annotation}"
																		size="20" maxlength="60" /> <input type="hidden" name="idVoie" id="idVoie"
																		value="${v.key.idVoie}" /> <input type="hidden" name="type" id="type"
																		value="modifierVoie" />
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
																	<button type="submit" class="btn btn-primary">Save changes</button>
																</div>

															</form>
														</div>
													</div>
												</div>


												
													<p>les Longueurs<p>
											
												<table class="table">
													<thead class="thead-dark">
														<tr>
															<th scope="col">#</th>
															<th scope="col">hauteur</th>
															<th scope="col">cotation</th>
															<th scope="col"></th>
														</tr>
													</thead>
													<tbody>

														<c:set var="count" value="0" scope="page" />
														<c:forEach items="${s2.value}" var="l">

															<c:set var="count" value="${count + 1}" scope="page" />
															<tr>
																<th scope="row">${count}</th>
																<td>${l.hauteur} m</td>
																<td>${l.cotation}</td>
																<td>
																	<!-- Button trigger modal -->



																	<button type="button" class="btn btn-primary" data-toggle="modal"
																		data-target="#modifier${l.idLongueur}"><i class="fa fa-edit"></i></button> <!-- Modal -->
																	<div class="modal fade" id="modifier${l.idLongueur}" tabindex="-1" role="dialog"
																		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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


																						<label for="hauteur">hauteur de la Longueur<span class="requis">*</span></label>
																						<input type="text" id="hauteur" name="hauteur" value="${l.hauteur}" required pattern="[0-9,.]{1,4}"/> <br />
																						<label for="cotation">cotation<span
																							class="requis">*</span></label> <input type="text" id="cotation" name="cotation"
																							value="${l.cotation}" required pattern="[3-9][A-C]" /> <input type="hidden"
																							name="idLongueur" id="idLongueur" value="${l.idLongueur}" /> <input
																							type="hidden" name="type" id="type" value="modifierLongueur" />


																					</div>
																					<div class="modal-footer">
																						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
																						<button type="submit" class="btn btn-primary">Save changes</button>
																					</div>
																				</form>

																			</div>
																		</div>
																	</div>
																	<button type="button" class="btn" data-toggle="modal"
											data-target="#supprimerLongueur${l.idLongueur}"><i class="fa fa-times-circle" style="color:red"></i></button>
										<div class="modal fade" id="supprimerLongueur${l.idLongueur}" tabindex="-1" role="dialog"
											aria-labelledby="supprimerLongueur${l.idLongueur}CenterTitle" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="supprimerLongueur${l.idLongueur}LongTitle">supprimer</h5>
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

<input name="idLongueur" type="hidden" id="supprimerLongueur${l.idLongueur}" value="${l.idLongueur}">
<input type="hidden" name="type" id="type" value="supprimerLongueur" />



														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
															<button type="submit" class="btn btn-primary">valider</button>
														</div>
													</form>
												</div>
											</div>
										</div>
																</td>

															</tr>
														</c:forEach>
														<tr>
															<th scope="row">${count+1}</th>
															<td>
																<!-- Button trigger modal -->
																<button type="button" class="btn btn-success" data-toggle="modal"
																	data-target="#ajouterLongueur${v.key.idVoie}">Ajouter une longueur</button> <!-- Modal -->
																<div class="modal fade" id="ajouterLongueur${v.key.idVoie}" tabindex="-1"
																	role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
																	<div class="modal-dialog modal-dialog-centered" role="document">
																		<div class="modal-content">
																			<div class="modal-header">
																				<h5 class="modal-title" id="exampleModalLongTitle">Ajouter une longueur</h5>
																				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																					<span aria-hidden="true">&times;</span>
																				</button>
																			</div>
																			<form method="post" action="">
																				<div class="modal-body">


																					<label for="hauteur">hauteur de la Longueur<span class="requis">*</span></label>
																					<input type="text" id="hauteur" name="hauteur" value="" required pattern="[0-9]{1,3}"/><br />
																					<label for="cotation">cotation<span
																						class="requis">*</span></label> <input type="text" id="cotation" name="cotation"
																						value="" required pattern="[3-9][A-C]"/> <br /> <input type="hidden"
																						name="idVoie" id="idVoie" value="${v.key.idVoie}" /><br /> <input
																						type="hidden" name="type" id="type" value="longueur" /><br /> <br />


																				</div>
																				<div class="modal-footer">
																					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
																					<button type="submit" class="btn btn-primary">Save changes</button>
																				</div>
																			</form>
																		</div>
																	</div>
																</div>
															</td>
															<td></td>
															<td></td>
														</tr>

													</tbody>
												</table>




										</div>
									</c:forEach>
								</c:forEach>
								</div>

								

								<!-- Modal -->
								<div class="modal fade" id="ajouterVoie${s1.key.idSecteur}" tabindex="-1" role="dialog"
									aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Ajouter une voie</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<form method="post" action="">
												<div class="modal-body">


													<label for="nom">nom de la Voie<span class="requis">*</span>
													</label> <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" /> <br /> <label
														for="annotation">annotation<span class="requis">*</span></label> <input type="text"
														id="annotation" name="annotation" value="" size="20" maxlength="60" /> <br /> <input
														type="hidden" name="idSecteur" id="idSecteur" value="${s1.key.idSecteur}" /><br /> <input
														type="hidden" name="type" id="type" value="voie" /><br /> <br />

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



					</c:forEach>
				</div>
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