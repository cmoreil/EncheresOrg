<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<ul>
		<c:if test="${userConnected == null }">
		<!-- remplacer le lien accueil par un logo clickable et bouton retour à home -->
		<li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
		<li><a href="${pageContext.request.contextPath}/inscription">Inscription</a></li>
		<li><a href="${pageContext.request.contextPath}/connexion">Connexion</a></li>
		</c:if>
		
		<c:if test="${userConnected != null }">
		<li><a href="${pageContext.request.contextPath}/connect/enchere">Enchères</a></li>
		<li><a href="${pageContext.request.contextPath}/connect/vente">Vendre un article</a></li>
		<li><a href="${pageContext.request.contextPath}/connect/monprofil">Mon Profil</a></li>
		<li><a href= "${pageContext.request.contextPath}/connect/deconnexion">Déconnexion</a></li>
		</c:if>
	</ul>
</header>