<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	Bienvenu ${grimpeur.nom}
	</br>
	</br>
	</br>
	</br>

	<div>
			<table>
				<tr>
					<td>${grimpeur.nom}</td>
					<td>${grimpeur.prenom}</td>
					<td> ${ grimpeur.Membre ? 'admin' : 'membre' }</td>
					<td>${grimpeur.email}</td>
				</tr>

			</table>
		</div>
			<div>
			<table>
		<c:forEach items="${Reservations}" var="r">
				<tr>
					<td><a href="/secteur?id=${r.idReservation}">${r.emprunteur.nom}</a></td>
					<td>${r.statut.statut}</td>
				
				</tr>
			</c:forEach>
			</table>
		</div>
		
		
	</br>
	</br>
	===================================================================================================================
	</br>
	</br>
<ul>
<li><form method="post" action="maj">
            <fieldset>
                <legend>Mettre à jour ses informations</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                  <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="${grimpeur.nom}" size="20" maxlength="20" />
                <br />
                
                <label for="nom">Prenom<span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" value="${grimpeur.prenom}" size="20" maxlength="20" />
                <br />

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="${grimpeur.email}" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
 
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

              	<input name="action1" type="hidden" value="inscription">

                <input type="submit" value="maj" class="sansLabel" />
                
                <br />
                
            </fieldset>
        </form>
        </li>
      
        </ul>

</body>
</html>
</body>
</html>