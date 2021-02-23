<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<jsp:include page="Menu.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<span class="font-italic">Bienvenu ${grimpeur.nom}</span>
	</br>
	</br>
	</br>
	</br>

	</br>
	</br>
	<div class="container">
	<div class="row">
	
<div class="col align-self-center">
	<div class="table">
		
			<div class="tr">
				<span class="th">nom</span>
				<span class="th">descrption</span>
				<span class="th">image</span>
				<span class="th">cotation</span>


			</div>
			<div class="tr">
				<span class="td">${site.nom}</span>
				<span class="td">${site.lieu}</span>
				
				<span class="td"><img src="${site.lienImage}"></span>

</div>
		</div>
		<div class="table">
			<c:forEach items="${secteurs}" var="s">
				<c:forEach items="${s.key}" var="s1">
					<div class="tr">
						<button class="btn btn-primary" type="button" data-toggle="collapse"
			data-target="#${s1.key.nom}" aria-expanded="false"
			aria-controls="${s1.key.nom}">${s1.key.nom}</button>

		<div class="collapse " id="${s1.key.nom}">
			<div class="card card-body">


						<span class="td">${s1.key.nom}</span>
						<span class="td">${s1.key.description}</span>
						<span class="td"><img src="${s1.key.lienCarte}"></span>

						<span class="td">${s1.value}</span>
   					     <button class="btn btn-warning" type="button" data-toggle="collapse"
			data-target="#modifier${s1.key.nom}" aria-expanded="false"
			aria-controls="modifier${s1.key.nom}">modifier</button>
			<div class="collapse " id="modifier${s1.key.nom}">
			<div class="card card-body">
									<form method="post" action="">

                 


                <label for="nom">nom du Secteur<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="${s1.key.nom}" size="20" maxlength="60" />
                <br />
                <label for="description">description<span class="requis">*</span></label>
                <input type="text" id="description" name="description" value="${s1.key.description}" size="20" maxlength="60" />
                <br />
				<label for="carte">carte</label>
				 <input type="checkbox" id="modfierImage" name="modfierImage" >
 					 <label for="modfierImage">modifierImage</label>
				<input type="file" name="carte" id="carte" value=""/>
 				<input type="hidden" name="type" id="type" value="modifierSecteur" />
 				<input type="hidden" name="idSecteur" id="idSecteur" value="${s1.key.idSecteur}" />
       			 <input type="submit" value="modifier" class="sansLabel" />
       			
              
        		</form>
       				</div>
        	</div>
				</div>
				
				<div class="table">
					<div class="tr">
						<span class="th">Les Voies</span>
					</div>
					
					<c:forEach items="${s.value}" var="s2">
						<c:forEach items="${s2.key}" var="v">
							<button class="btn btn-dark" type="button" data-toggle="collapse"
			data-target="#${v.key.nom}" aria-expanded="false"
			aria-controls="${v.key.nom}">${v.key.nom}</button>

		<div class="collapse " id="${v.key.nom}">
			<div class="card card-body">
						
							<div class="tr">
								<span class="td">${v.key.nom}</span>
								<span class="td">${v.key.annotation}</span>
								<span class="td">${v.value}</span>
							</div>
							<div class="tr">
							  					     <button class="btn btn-warning" type="button" data-toggle="collapse"
			data-target="#modifier${v.key.nom}" aria-expanded="false"
			aria-controls="modifier${v.key.nom}">modifier</button>
			<div class="collapse " id="modifier${v.key.nom}">
			<div class="card card-body">
									<form method="post" action="">

                
                <label for="nom">nom de la Voie<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="${v.key.nom}" size="20" maxlength="60" />
                <br />
                <label for="annotation">annotation<span class="requis">*</span></label>
                <input type="text" id="annotation" name="annotation" value="${v.key.annotation}" size="20" maxlength="60" />
               
                <input type="hidden" name="idVoie" id="idVoie"value="${v.key.idVoie}" />
 				<input type="hidden" name="type" id="type" value="modifierVoie" />
       			 <input type="submit" value="modifier la Voie" class="sansLabel" />
       			
                <br />
           
        		</form>
       				 </div>
        	</div>
        	 <br />
            <br />
            <br />
           </div>
								<div class="card ">
								<span class="th">les Longueurs</span>
						</div>
							
							<c:forEach items="${s2.value}" var="l">
								<button class="btn btn-dark" type="button" data-toggle="collapse"
			data-target="#${l.idLongueur}" aria-expanded="false"
			aria-controls="${l.idLongueur}">Longueur n°${l.idLongueur}</button>

		<div class="collapse " id="${l.idLongueur}">
			<div class="card card-body">
								<div class="tr">
									<span class="td">${l.hauteur}</span>
									<span class="td">${l.cotation}</span>
								</div>
								     <button class="btn btn-warning" type="button" data-toggle="collapse"
			data-target="#modifier${l.idLongueur}" aria-expanded="false"
			aria-controls="modifier${l.idLongueur}">modifier</button>
			<div class="collapse " id="modifier${l.idLongueur}">
			<div class="card card-body">
									<form method="post" action="">

                <label for="hauteur">hauteur de la Longueur<span class="requis">*</span></label>
                <input type="text" id="hauteur" name="hauteur" value="${l.hauteur}" size="20" maxlength="60" />
                <br />
                <label for="cotation">cotation<span class="requis">*</span></label>
                <input type="text" id="cotation" name="cotation" value="${l.cotation}" size="20" maxlength="60" />
             
                <input type="hidden" name="idLongueur" id="idLongueur"value="${l.idLongueur}" />
 				<input type="hidden" name="type" id="type" value="modifierLongueur"  />
                
       			 <input type="submit" value="modifier" class="sansLabel" />
       			
           
        		</form>
        		 </div>
        	</div>
        		<br />
        		   </div>
        	</div>
							</c:forEach>
							    <legend>Ajouter une Longeur</legend>
                =============Ajouter une Longueur========================<br />
	<form method="post" action="">

                <label for="hauteur">hauteur de la Longueur<span class="requis">*</span></label>
                <input type="text" id="hauteur" name="hauteur" value="" size="20" maxlength="60" />
                <br />
                <label for="cotation">cotation<span class="requis">*</span></label>
                <input type="text" id="cotation" name="cotation" value="" size="20" maxlength="60" />
                <br />
                <input type="hidden" name="idVoie" id="idVoie"value="${v.key.idVoie}" /><br />
 				<input type="hidden" name="type" id="type" value="longueur"  /><br />
                <br />
       			 <input type="submit" value="ajoute la Longueur" class="sansLabel" />
       			
                <br />
           
        		</form>
        </div>
        	</div>
						</c:forEach>
					</c:forEach>
					<form method="post" action="">
         
                <legend>Ajouter une Voie</legend>
                =============Ajouter une Voie========================<br />


                <label for="nom">nom de la Voie<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
                <br />
                <label for="annotation">annotation<span class="requis">*</span></label>
                <input type="text" id="annotation" name="annotation" value="" size="20" maxlength="60" />
                <br />
                <input type="hidden" name="idSecteur" id="idSecteur"value="${s1.key.idSecteur}" /><br />
 				<input type="hidden" name="type" id="type" value="voie" /><br />
                <br />
       			 <input type="submit" value="ajoute la Voie" class="sansLabel" />
       			
                <br />
           
        		</form>
        </div>
        	</div>
	</div>
				</c:forEach>
			</c:forEach>
			</div>
		<div class="dropdown">
			=============Ajouter un secteur========================
			<div class="dropdown-content">
			<form method="post" action=""enctype="multipart/form-data" >
         
                <legend>Ajouter un Secteur</legend>
                


                <label for="nom">nom du Secteur<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
                <br />
                <label for="description">description<span class="requis">*</span></label>
                <input type="text" id="description" name="description" value="" size="20" maxlength="60" />
                <br />
				<label for="carte">carte</label>
				<input type="file" name="carte" id="carte" accept="image/*"/><br />
 				<input type="hidden" name="type" id="type" value="secteur" /><br />
 				<input type="hidden" name="idSite" id="idSite" value="${site.idSite}" /><br />
                <br />
       			 <input type="submit" value="ajoute le le secteur" class="sansLabel" />
       			
                <br />
           
        		</form>
        =====================================================================
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