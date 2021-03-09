<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Connexion</title>
</head>
<body style="background-color: #eeeeee">
<div class="container">
		<div class="jumbotron">
			<h1>Bienvenue chez Les Amis de l'escalade</h1>
		</div>
	</div>
 <div class="container">
  <div class="row">
    <div class="card bg-light"> 

      </div>
      </div>
      </div>
       <div class="container">
      <div class="jumbotron">
      <form method="post" action="">
          
                <p>Connectez-vous ici</p>
               


                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
             

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
 
               
				 <input name="action" type="hidden" value="connexion">
       			 
       			<button type="submit" class="btn btn-dark">Connexion</button>
             
           
        </form>
			<hr/>
			<form method="post" action="">
        
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                  <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
            
                
                <label for="nom">Prenom<span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
  

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/>
         

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
 
            
                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
             

              	<input name="action" type="hidden" value="inscription">

                
       			<button type="submit" class="btn btn-dark">Inscription</button>
             
                
           
        </form>
		</div>
		</div>
       <div class="container">
      <div class="row"> 
      <div class="card bg-light"> 

       </div>
      </div>
     
        </div>
</body>
</html>