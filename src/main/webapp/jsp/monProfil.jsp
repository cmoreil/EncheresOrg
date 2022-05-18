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
	<h2>Mon Profil</h2>
	
			<form action="monprofil" method="post"> 
			<label for="username">Pseudo</label>
			<input id="username" type="text"  name="username" value="${userConnected.username}" /><span class="error">${errors.username}</span>
			<label for=name>Nom</label>
			<input id="name" type="text"  name="name" value="${userConnected.name}" />
			<label for="firstname">Prénom</label> 
			<input id="firstname" type="text" name="firstname" value="${userConnected.firstname}" />
			<label for="email">Email</label> 
			<input id="email" type="email" name="email" value="${userConnected.email}" />			
			<label for="phone">Téléphone</label>
			<input id="phone" type="text"  name="phone" value="${userConnected.phone}" />
			<label for="street">Rue</label>
			<input id="street" type="text"  name="street" value="${userConnected.street}" />		
			<label for="postalCode">Code postal</label>
			<input id="postalCode" type="text"  name="postalCode" value="${userConnected.postalCode}" />
			<label for="city">Ville</label>
			<input id="city" type="text"  name="city" value="${userConnected.city}" />
			<label for="password">Mot de passe</label> 
			<input id="password" type="password" name="password" /> <span class="error">${errors.password}</span>	
			<label for="confirmPassword">Confirmation</label> 
			<input id="confirmPassword" type="password" name="confirmPassword" /> <span class="error">${errors.password}</span>
			<input type="submit" value="Modifier" />
			<p>${modificationOK}</p>
		</form>
		<form action="" method="post">
			<input type="hidden" name="id" value="${user.id}" /> 
			<input type="submit" value="A supprimer" />
		</form>
</body>
</html>