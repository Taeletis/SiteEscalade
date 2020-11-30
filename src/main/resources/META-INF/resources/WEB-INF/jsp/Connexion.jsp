<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
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