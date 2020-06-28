<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Accueil</title>
</head>
<body>
<c:import url="header.jspf"></c:import>

<div id="content_accueil">
	<div id="presentation_accueil">
		<div id="titre_accueil">
			<p><span id="titre_p_accueil">Bienvenue</span> dans notre application de cave à vin</p>
		</div>
		<div id="texte_accueil">
			<p>Vous allez pouvoir visualiser vos plus merveilleuses bouteilles,
				mais aussi ajouter, modifier ou supprimer ces excellents breuvages.</p>
			<p>Expérience enrichissante garantie.</p>
		</div>
		<button id="button_accueil" type="button"><a>En savoir plus...</a></button>
	</div>
</div>


<c:import url="footer.jspf"></c:import>
</body>
</html>