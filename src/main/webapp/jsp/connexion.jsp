<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<h1>Connexion</h1>
	
	<form action="connexion" method="post">
	<label for="mail">Email :</label>
	<input type="mail" id="mail" name="mail"/>${erreur}<br />
	<label for="password">Mot de passe :</label>
	<input type="password" id="password" name="password"/>${erreur}<br />
	<input type="submit" value="connexion" />
	<a href ="connexion">Créer un compte</a>
	</form>


</body>
</html>