<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EnyBay</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<h1>EniBay</h1>
	<h2>Nouvelle Vente</h2>

	<form action="vente" method="post">
		<label for="name">Article :</label> 
		<input id="name" type="text" name="name" /> <span class="error">${SellsErrors.name}</span>
		<label for="description">Description :</label>
		<textarea id="description" name="description" rows="20"></textarea> <span class="error">${SellsErrors.description}</span> <span class="error">${SellsErrors.description2}</span>
		<label for="categoryLabel">Catégorie :</label> 
		<select name="categoryLabel" id="categoryLabel">
			<option value="informatique">Informatique</option>
			<option value="Ameublement">Ameublement</option>
			<option value="Vetement">Vêtement</option>
			<option value="Sport&loisirs">Sports et loisirs</option>
		</select> 

		<label for="initialPrice">Mise à prix</label> 
		<input type="number" id="initialPrice" name="initialPrice" min="1"> 
		<label for="auctionStartDate">Début de l'enchère </label> 
		<input type="date" id="auctionStartDate" name="auctionStartDate" value="" min="2022-05-01"><span class="error">${SellsErrors.date}</span>
		<label for="auctionEndDate">Fin de l'enchère </label> 
		<input type="date" id="auctionEndDate" name="auctionEndDate" value="" min="2022-05-01"> <span class="error">${SellsErrors.date2}</span>
		
		 <fieldset>
			  <legend>Retrait</legend>
			  <label for="street">Rue</label>
			  <input type="text" id="street" name="street" value= "${userConnected.street}" />
			  <label for="postalCode">Code postal</label>
			  <input type="text" id="postalCode" name="postalCode" value = "${userConnected.postalCode}" />
			  <label for="city">Ville</label>
			  <input type="text" id="city" name="city" value = "${userConnected.city}" />
		</fieldset>
		<input type="submit" value="Enregistrer">
	</form>
	<div class="error">${SellsErrors.emptyField}</div>
	<a href="index" >Annuler</a>
</body>
</html>