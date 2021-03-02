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
 <ul>
 <li><form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Connectez-vous ici</p>
               


                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
 
                <br />
				 <input name="action2" type="hidden" value="connexion">
       			 <input type="submit" value="Connexion" class="sansLabel" />
       			
                <br />
                
            </fieldset>
        </form>
        </li>
        </ul>
        
</body>
</html>