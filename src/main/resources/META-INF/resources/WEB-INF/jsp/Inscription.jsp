<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
<ul>
<li><form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                  <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />
                
                <label for="nom">Prenom<span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                <br />

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
 
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

              	<input name="action1" type="hidden" value="inscription">

                <input type="submit" value="Inscription" class="sansLabel" />
                
                <br />
                
            </fieldset>
        </form>
        </li>
      
        </ul>
        
</body>
</html>