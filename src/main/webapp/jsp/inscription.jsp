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
		<h2>Mon profil</h2>
	
		<form action="inscription" method="post"> 
			<label for="username">Pseudo</label>
			<input id="username" type="text"  name="username" value="${user.username}" /><span class="error">${errors.username}</span>
			<label for=name>Nom</label>
			<input id="name" type="text"  name="name" value="${user.name}" />
			<label for="firstname">Prénom</label> 
			<input id="firstname" type="text" name="firstname" value="${user.firstname}" />
			<label for="email">Email</label> 
			<input id="email" type="email" name="email" value="${user.email}" />			
			<label for="phone">Téléphone</label>
			<input id="phone" type="text"  name="phone" value="${user.phone}" /><span class="error">${errors.phone}</span>
			<label for="street">Rue</label>
			<input id="street" type="text"  name="street" value="${user.street}" />		
			<label for="postalCode">Code postal</label>
			<input id="postalCode" type="text"  name="postalCode" value="${user.postalCode}" /><span class="error">${errors.postalCode}</span>
			<label for="city">Ville</label>
			<input id="city" type="text"  name="city" value="${user.city}" />		
			<label for="password">Mot de passe</label> 
			<input id="password" type="password" name="password" /> <span class="error">${errors.password}</span>
			<label for="confirmPassword">Confirmation</label> 
			<input id="confirmPassword" type="password" name="confirmPassword" />
			<input type="submit" value="Créer" />
			<div class="error">${errors.emptyField}</div>
			<div class="error">${unicité}</div>
		</form>
			<!-- à "css-er" pour que cela ressemble à un bouton -->
			<a href ="index">Annuler</a>
	<!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
  </div>
</body>
</html>