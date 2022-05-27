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
<title>Connexion</title>
</head>
<body>
  <div class="container">
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

	<!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
  </div>
</body>
</html>