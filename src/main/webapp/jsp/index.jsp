<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="css/main.css"/>
<title>EniBay</title>
</head>
<body>
 <div class="container">
 <%@include file="header.jsp"%>
	<h1>EniBay</h1>
	<h2>Liste des ench�res</h2>
	
	<form action="index" method="POST">
		<input type="text" placeholder="Search.." name="search">
		<label for="categoryLabel">Cat�gorie :</label> 
			<select name="categoryLabel" id="categoryLabel">
				<option value="toutes">TOUTES</option>
				<c:forEach items="${ categories }" var="category" varStatus="status">
					<option value="${ category.label }"> ${category.label}</option>
				</c:forEach>
			</select>
		<button type="submit">Rechercher</button>
				
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
	
	<ol>
		<c:forEach items="${ articles }" var="article" varStatus="status">
			<li>
				<input type="hidden" name="id" value="${article.id}" />
				<a href="enchere" > ${article.name} </a>
				<p> ${article.initialPrice} pts</p>
				<p> ${article.auctionEndDate} </p>
				<p> ${article.user.name} </p>
			</li>
		</c:forEach>
	
	<!--en fonction du r�sultat afficher les encheres -->
		
	</ol>
	<!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
  </div>
</body>
</html>