<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<a href="index"><img class="icon" alt="icone d'un marteau de tribunal" src="img/court_gavel.jpg"></a>
	<ul>
		<c:if test="${userConnected == null }">
		<li><a href="${pageContext.request.contextPath}/inscription">Inscription</a></li>
		<li><a href="${pageContext.request.contextPath}/connexion">Connexion</a></li>
		</c:if>
		
		<c:if test="${userConnected != null }">
		<li><a href="${pageContext.request.contextPath}/connect/enchere">Ench�res</a></li>
		<li><a href="${pageContext.request.contextPath}/connect/vente">Vendre un article</a></li>
		<li><a href="${pageContext.request.contextPath}/connect/monprofil">Mon Profil</a></li>
		<li><a href= "${pageContext.request.contextPath}/connect/deconnexion">D�connexion</a></li>
		</c:if>
	</ul>
</header>