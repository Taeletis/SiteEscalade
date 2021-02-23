<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<jsp:include page="Menu.jsp"></jsp:include>
</head>

<body>
	Bienvenu ${grimpeur.nom}
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	<div class="container">
	<div class="row">
	
<div class="col align-self-center">
	<c:forEach items="${sites}" var="s">

		<button class="btn btn-primary" type="button" data-toggle="collapse"
			data-target="#${s.key.nom}" aria-expanded="false"
			aria-controls="${s.key.nom}">${s.key.nom}</button>

		<div class="collapse " id="${s.key.nom}">
			<div class="card card-body">


				<a href="/monSite?id=${s.key.idSite}">${s.key.nom}</a> ${s.key.lieu}
				<img src="${s.key.lienImage}" width="400" height="300">
					<button class="btn btn-dark" type="button" data-toggle="collapse"
			data-target="#modifier" aria-expanded="false"
			aria-controls="modifier">modifier</button>

		<div class="collapse " id="modifier">
			<div class="card card-body">
				<form method="post" action="">

					 <label for="nom">nom du site<span class="requis">*</span></label>
					<input type="text" id="nom" name="nom" value="${s.key.nom}"
						size="20" maxlength="60" /> <br /> <label for="lieu">lieu<span
						class="requis">*</span></label> <input type="text" id="lieu" name="lieu"
						value="${s.key.lieu}" size="20" maxlength="60" /> <br /> <label
						for="image">image</label> <input type="checkbox" id="modfierImage"
						name="modfierImage"> <label for="modfierImage">modifier
						l'Image</label> <input type="file" name="image" id="image" /><br /> <input
						type="hidden" name="idSite" id="idSite" value="${s.key.idSite}" /><br />
					<input type="hidden" name="type" id="type" value="site" /><br />
					<br /> < <input type="submit"
						value="modifier le site" class="sansLabel" /> <br />

				</form>
				</div>
		</div>
				
				<c:forEach items="${s.value}" var="t">
				<button class="btn btn-dark" type="button" data-toggle="collapse"
			data-target="#${t.nom}" aria-expanded="false"
			aria-controls="${t.nom}">Topo ${t.nom}</button>

		<div class="collapse " id="${t.nom}">
			<div class="card card-body">

					<p>Nom : ${t.nom} //</p>
					<p>Lieu : ${t.lieu} //</p>
					<p>Créer le : ${t.dateParution} //</p>
					<p>${ t.disponible ? 'disponible' : 'indisponible' }//</p>
					<form method="post" action="">

						modifier <label for="disponible">Disponible</label> <label
							for="nom">nom du topo<span class="requis">*</span></label> <input
							type="text" id="nom" name="nom" value="${t.nom}" size="20"
							maxlength="60" /> <br /> <label for="lieu">lieu<span
							class="requis">*</span></label> <input type="text" id="lieu" name="lieu"
							value="${t.lieu}" size="20" maxlength="60" /> <br /> <input
							type="checkbox" id="disponible" name="disponible"> <label
							for="disponible">Disponible</label> <input type="hidden"
							name="idTopo" id="idTopo" value="${t.idTopo}" /><br /> <input
							type="hidden" name="type" id="type" value="modifierTopo" /><br />
						<br /> <br /> <input type="submit" value="modifier le topo"
							class="sansLabel" /> <br />

					</form>
			</div>
		</div>
				</c:forEach>
				=============Ajouter un topo========================
				<form method="post" action="">

					Ajouter un topo <label for="nom">nom du topo<span
						class="requis">*</span></label> <input type="text" id="nom" name="nom"
						value="" size="20" maxlength="60" /> <br /> <label for="lieu">lieu<span
						class="requis">*</span></label> <input type="text" id="lieu" name="lieu"
						value="" size="20" maxlength="60" /> <br /> <input
						type="checkbox" id="disponible" name="disponible"> <label
						for="disponible">Disponible</label> <input type="hidden"
						name="idSite" id="idSite" value="${s.key.idSite}" /><br /> <input
						type="hidden" name="type" id="type" value="topo" /><br /> <br />
					<input type="submit" value="ajoute le topo" class="sansLabel" /> <br />


				</form>
			</div>
		</div>

	</c:forEach>
	</div>
	</div>
	</br>
	</br>
	
		<div class="row">
<div class="col align-self-center">
		<button class="btn btn-dark" type="button" data-toggle="collapse"
			data-target="#collapse" aria-expanded="false"
			aria-controls="collapse">Ajouter un site</button>


		<div class="collapse" id="collapse">
			<div class="card card-body">

	=============Ajouter un site========================
	<form method="post" action="">
	



			<label for="nom">nom du site<span class="requis">*</span></label> <input
				type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
			<br /> <label for="lieu">lieu<span class="requis">*</span></label> <input
				type="text" id="lieu" name="lieu" value="" size="20" maxlength="60" />
			<br /> <label for="image">image</label> <input type="file"
				name="image" id="image" /><br /> <input type="hidden" name="type"
				id="type" value="site" /><br /> <br /> <input type="submit"
				value="ajoute le site" class="sansLabel" /> <br />

	</form>
	</div>
		</div>
	</div>
	</div>
</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>