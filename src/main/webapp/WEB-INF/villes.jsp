<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
</head>
<body>
    <h1>Liste des villes</h1>
    
    <c:if test="${state == true}">
       	<p>La ville numéro ${supprimer} a bien été effacé.</p>
    </c:if>
    
    <table>
        <thead>
            <tr>
                <th>Code postal</th>
                <th>Nom de la commune</th>
                <th>Code INSEE</th>
                <th>Latitude</th>
                <th>Longitude</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ville" items="${villes[currentPage-1]}">
                <tr>
                    <td>${ville.codePostal}</td>
                    <td>${ville.nomCommune}</td>
                    <td>${ville.codeCommune}</td>
                    <td>${ville.coordonnee.latitude}</td>
                    <td>${ville.coordonnee.longitude}</td>
                    <th><a href="./ModifierVille?code=${ville.codeCommune}">Modifier</a></th>
                	<th><a href="?supprimer=${ville.codeCommune}&page=${currentPage}">Supprimer</a></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
   	<div class="pagination">
	        <a href="?page=1">&laquo;&laquo;</a>
	        <a href="?page=${currentPage-1}">&laquo;</a>
	        <c:if test="${currentPage > 1}">
	        	<c:forEach var="i" begin="${currentPage-2}" end="${currentPage+2}">
		            <c:if test="${i ge 1 && i le lastPage}">
		                <a href="?page=${i}" <c:if test="${i eq currentPage}"></c:if>>${i}</a>
		            </c:if>
		        </c:forEach>
	        </c:if>
	        <c:if test="${currentPage == 1}">
	        	<c:forEach var="i" begin="${currentPage}" end="${currentPage+2}">
		            <c:if test="${i ge 1 && i le lastPage}">
		                <a href="?page=${i}" <c:if test="${i eq currentPage}"></c:if>>${i}</a>
		            </c:if>
		        </c:forEach>
	        </c:if>
	        
	        <a href="?page=${currentPage+1}">&raquo;</a>
	        <a href="?page=${lastPage}">&raquo;&raquo;</a>
	</div>
    
</body>
</html>
