<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>recherche avancé</title>
</head>

<body>
page de recherche
<button onclick="window.location.href = '/recherche';">Afficher les sites</button>
	<div>
		<table>
		<tr>
		<form method="post" action="recherche">
	
            
				<th><label for="nom">nom </label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
               	</th>
				<th>
                <label for="lieu">lieu </label>
                <input type="text" id="lieu" name="lieu" value="" size="20" maxlength="20" />
 				</th>
         		<th>
       			 <input type="submit" value="Rechercher" class="sansLabel" />
       			
                </th>
                
                      
        </form>
			</tr>
		
		
		
			<tr>
				<th>Nom</th>
				<th>lieu</th>
				<th>lienImage</th>
			</tr>
			<c:forEach items="${sites}" var="s">
				<tr>
				
					<td>${s.nom}</td>
					<td>${s.lieu}</td>
					<td><img src="${s.lienImage}"></td>
				</tr>
			</c:forEach>
		</table>



	</div>

</body>
</html>