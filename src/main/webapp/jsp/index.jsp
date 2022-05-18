<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EniBay</title>
</head>
<body>
 <%@include file="header.jsp"%>
	<h1>EniBay</h1>
	<h2>Liste des ench�res</h2>
	
	<form action="search" method="POST">
		<input type="text" placeholder="Search.." name="search">
		<button type="submit">Rechercher</button>
		<label for="categoryLabel">Cat�gorie :</label> 
			<select name="categoryLabel" id="categoryLabel">
				<option value="toutes">TOUTES</option>
				<c:forEach items="${ categories }" var="category" varStatus="status">
					<option value="${ category.label }"> ${category.label}</option>
				</c:forEach>
			</select>
			
			<c:if test="${userConnected != null }">
			<label for="achats">Achats</label>
			<input type="radio" id="achats" name="achats" value="achats">
				<div>
					<label for="opened">ench�res ouvertes</label>
				 	<input type="checkbox" id="opened" name="opened" value="opened">
				 	<label for="mine">mes ench�res</label>
				 	<input type="checkbox" id="mine" name="mine" value="mine">
				 	<label for="won">mes ench�res remport�es</label>
				 	<input type="checkbox" id="won" name="won" value="won">
				</div>
				
		  	<label for="ventes">Mes ventes</label>
			<input type="radio" id="ventes" name="ventes" value="ventes">
				<div>
			  		<label for="in_progress">mes ventes en cours</label>
				 	<input type="checkbox" id="in_progress" name="in_progress" value="in_progress">
				 	<label for="not_started">ventes non d�but�es</label>
				 	<input type="checkbox" id="not_started" name="not_started" value="not_started">
				 	<label for="finisched">ventes termin�es</label>
				 	<input type="checkbox" id="finisched" name="finisched" value="finisched">
				 </div>
			</c:if>
	</form>
	<!--en fonction de la recherche afficher le r�sultat -->
	<!--par d�faut toutes celles en "opened" -->

</body>
</html>