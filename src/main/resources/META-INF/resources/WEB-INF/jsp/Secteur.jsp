<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Menu.jsp"></jsp:include>
<link 
  href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
  rel="stylesheet"  type='text/css'>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col mb-3">
				<a href="/recherche" class="text-info"><i class="fa fa-arrow-up"></i>revenir a la liste des sites</a>
			</div>
			</div>
			<div class="row">
			<div class="col">
				<a  href="/site?id=${idSite}" class="text-info"><i class="fa fa-arrow-left"></i>revenir au site </a>
			</div>
			
		</div>
		<div class="row">

			<div class="col">
				<p>
					<img src="${lienImage}" class="img-fluid">
				</p>
			</div>


			<div class="col">
				<p>${nom}</p>
				<p>${descrption}</p>
			</div>
			<div class="col">
				
			</div>

		</div>
		<div class="row">
			<div class="col">
				<ul class="nav nav-tabs" id="tabSecteur" role="tablist">
					<c:forEach items="${voies}" var="navV">
						<c:forEach items="${navV.key}" var="nav">

							<li class="nav-item"><a class="nav-link " id="voie${nav.key.idVoie}-tab"
								data-toggle="tab" href="#voie${nav.key.idVoie}" role="tab"
								aria-controls="voie${nav.key.idVoie}" aria-selected="true">${nav.key.nom}</a></li>
						</c:forEach>
					</c:forEach>
				</ul>
				<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab"><div class="jumbotron"><h4>Informations des Voies</h4></div></div>
					<c:forEach items="${voies}" var="v">

						<c:forEach items="${v.key}" var="list">

							<div class="tab-pane fade" id="voie${list.key.idVoie}" role="tabpanel"
								aria-labelledby="voie${list.key.idVoie}-tab">


								<p>${list.key.nom}</p>
								<p>Note : ${list.key.annotation}</p>
								<p>Cotation : ${list.value}</p>


								<h6>longueurs de la voie</h6>
								<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">hauteur</th>
											<th scope="col">cotation</th>
											
										</tr>
									</thead>
									<tbody>

										<c:set var="count" value="0" scope="page" />
										<c:forEach items="${v.value}" var="l">

											<c:set var="count" value="${count + 1}" scope="page" />
											<tr>
												<th scope="row">${count}</th>
												<td>${l.hauteur}m</td>
												<td>${l.cotation}</td>


											</tr>
										</c:forEach>


									</tbody>
								</table>



							</div>


							</div>
						</c:forEach>



					</c:forEach>
				</div>
			</div>

		</div>
	</div>

</body>
</html>