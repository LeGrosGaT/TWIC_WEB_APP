<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calcul de distance</title>
</head>
<body>
	<h1>Calcul de distance</h1>
	<form action="" method="post">
		<label for="villeDepart">Ville de départ:</label>
		<select name="villeDepart" id="villeDepart">
			<c:forEach items="${villes}" var="ville">
				<option value="${ville.codeCommune}">${ville.nomCommune} (${ville.codePostal})</option>
			</c:forEach>
		</select>
		
		<label for="villeArrivee">Ville d'arrivée:</label>
		<select name="villeArrivee" id="villeArrivee">
			<c:forEach items="${villes}" var="ville">
				<option value="${ville.codeCommune}">${ville.nomCommune} (${ville.codePostal})</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Calculer la distance">
	</form>
	
	<c:if test="${not empty distance}">
		<p>Distance entre ${ville1.nomCommune} et ${ville2.nomCommune} : ${distance} km</p>
	</c:if>
</body>
</html>