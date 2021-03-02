<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<jsp:include page="Menu.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<div class="container">
<div class="row ">
<div class="card">
		
		
				<h3>${site.nom}</h3>
		
			
				<p>Lieu : ${site.lieu}</p>
		
			
				<p>
					<img src="${site.lienImage}">
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

							<a class="nav-item nav-link mb-2" id="Secteur${navS.key.idSecteur}-tab" data-toggle="tab"
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




								<p>${s1.key.nom}</p>
								<p>${s1.key.description}</p>
								<p>
									<img src="${s1.key.lienCarte}">
								</p>
								<p>${s1.value}</p>
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-warning" data-toggle="modal"
									data-target="#mofifierSecteur${s1.key.idSecteur}">modifier secteur</button>

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
											<form method="post" action="">
												<div class="modal-body">





													<label for="nom">nom du Secteur<span class="requis">*</span></label> <input type="text"
														id="nom" name="nom" value="${s1.key.nom}" size="20" maxlength="60" /> <br /> <label
														for="description">description<span class="requis">*</span></label> <input type="text"
														id="description" name="description" value="${s1.key.description}" size="20"
														maxlength="60" /> <br /> <label for="carte">carte</label> <input type="checkbox"
														id="modfierImage" name="modfierImage"> <label for="modfierImage">modifierImage</label>
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
											


												<p>${v.key.nom}</p>
												<p>${v.key.annotation}</p>
												<p>
													Cotation: ${v.value}


													<!-- Button trigger modal -->
													<button type="button" class="btn btn-primary" data-toggle="modal"
														data-target="#modifierVoie${v.key.idVoie}">modifier</button>
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
																<td>${l.hauteur}</td>
																<td>${l.cotation}</td>
																<td>
																	<!-- Button trigger modal -->



																	<button type="button" class="btn btn-primary" data-toggle="modal"
																		data-target="#mofifier${l.idLongueur}">modifier longueur</button> <!-- Modal -->
																	<div class="modal fade" id="mofifier${l.idLongueur}" tabindex="-1" role="dialog"
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
																						<input type="text" id="hauteur" name="hauteur" value="${l.hauteur}" size="20"
																							maxlength="60" /> <br /> <label for="cotation">cotation<span
																							class="requis">*</span></label> <input type="text" id="cotation" name="cotation"
																							value="${l.cotation}" size="20" maxlength="60" /> <input type="hidden"
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
																					<input type="text" id="hauteur" name="hauteur" value="" size="20"
																						maxlength="60" /> <br /> <label for="cotation">cotation<span
																						class="requis">*</span></label> <input type="text" id="cotation" name="cotation"
																						value="" size="20" maxlength="60" /> <br /> <input type="hidden"
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