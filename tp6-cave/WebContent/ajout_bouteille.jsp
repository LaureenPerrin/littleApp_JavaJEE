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
<title>Liste des bouteilles</title>
</head>
<body>
<c:import url="header.jspf"></c:import>

<h1>Ajout d'un vin</h1>

<form action = "ListerServlet" method="post">
		Nom : <input id="nom" type = "text" name ="nom"> <br>
		Millésime : <input id="millesime" type = "text" name ="millesime"> <br>
		Pétillant : <select name="petillant" id="petillant">
                     <option value="pettilant_oui">Oui</option>
                     <option value="pettilant_non">Non</option>
				   </select><br>
		Quantité : <input id="quantite" type = "text" name ="quantite"> <br>
		Couleur :  <select name="couleur" id="couleur">
		<c:forEach var="couleur" items="${listeCouleurs}">
                     <option value="${couleur.nom}">${couleur.nom}</option>
        </c:forEach>
				   </select><br>
		Région : <select name="region" id="region">
		<c:forEach var="region" items="${listeRegions}">
                     <option value="${region.nom}">${region.nom}</option>
        </c:forEach>
				   </select><br>
		<input type = "submit" value="Envoyer"> 
</form>



	

<c:import url="footer.jspf"></c:import>
</body>
</html>