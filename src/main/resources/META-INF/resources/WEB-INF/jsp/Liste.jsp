<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>liste des sites</title>
</head>
<body>
	<div>
		<table>
		<tr>
		<form method="post" action="recherche">
	
            
				<th><label for="nom">nom <span class="requis"></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
               	</th>
				<th>
                <label for="lieu">lieu <span class="requis"></label>
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