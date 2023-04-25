<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier une ville</title>
</head>
<body>
	<h1>Modifier une ville</h1>
	<form method="post">
	  <label for="codeCommune">Code commune :</label>
	  <input type="text" id="codeCommune" name="codeCommune" value="${ville.codeCommune}"><br>
	
	  <label for="nomCommune">Nom commune :</label>
	  <input type="text" id="nomCommune" name="nomCommune" value="${ville.nomCommune}" /><br>
	
	  <label for="codePostal">Code postal :</label>
	  <input type="text" id="codePostal" name="codePostal" value="${ville.codePostal}" /><br>
	
	  <label for="libelleAcheminement">Libellé acheminement :</label>
	  <input type="text" id="libelleAcheminement" name="libelleAcheminement" value="${ville.libelleAcheminement}" /><br>
	
	  <label for="ligne">Ligne :</label>
	  <input type="text" id="ligne" name="ligne" value="${ville.ligne}" /><br>
	
	  <!-- Coordonnées -->
	  <label for="latitude">Latitude :</label>
	  <input type="text" id="latitude" name="latitude" value="${ville.coordonnee.latitude}" /><br>
	
	  <label for="longitude">Longitude :</label>
	  <input type="text" id="longitude" name="longitude" value="${ville.coordonnee.longitude}" /><br>
	
	  <input type="submit" value="Modifier" />
	</form>

</body>
</html>