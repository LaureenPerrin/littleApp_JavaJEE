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

<h1>Liste des bouteilles</h1>

<form action = "ListerServlet" method="post">
		Filtre : <input id="filtre_nom_bouteille" type = "text" name ="filtre_nom_bouteille"> <br>
		<input type = "submit" value="Envoyer"> 
</form>


<table>
		<tr>
			<th><a href="ListerServlet?nomTriAsc=nomTriAsc"><i class="fas fa-sort-down"></i></a>Nom<a href="ListerServlet?nomTriDesc=nomTriDesc"><i class="fas fa-sort-up"></i></a></th>
			<th><a href="ListerServlet?millesimeTriAsc=millesimeTriAsc"><i class="fas fa-sort-down"></i></a>Millesime<a href="ListerServlet?millesimeTriDesc=millesimeTriDesc"><i class="fas fa-sort-up"></i></a></th>
			<th><a href="ListerServlet?petillantTriAsc=petillantTriAsc"><i class="fas fa-sort-down"></i></a>Pétillant<a href="ListerServlet?petillantTriDesc=petillantTriDesc"><i class="fas fa-sort-up"></i></a></th>
			<th><a href="ListerServlet?quantiteTriAsc=quantiteTriAsc"><i class="fas fa-sort-down"></i></a>Quantité<a href="ListerServlet?quantiteTriDesc=quantiteTriDesc"><i class="fas fa-sort-up"></i></a></th>
			<th><a href="ListerServlet?couleurTriAsc=couleurTriAsc"><i class="fas fa-sort-down"></i></a>Couleur<a href="ListerServlet?couleurTriDesc=couleurTriDesc"><i class="fas fa-sort-up"></i></a></th>
			<th><a href="ListerServlet?regionTriAsc=regionTriAsc"><i class="fas fa-sort-down"></i></a>Région<a href="ListerServlet?regionTriDesc=regionTriDesc"><i class="fas fa-sort-up"></i></a></th>
			<th>      </th>
		</tr>
		<c:forEach var="bouteille" items="${listeBouteilles}">
			<tr>
				<td>${bouteille.nom}</td>
				<td>${bouteille.millesime}</td>
				<td>${bouteille.petillant}</td>
				<td>${bouteille.quantite}</td>
				<td>${bouteille.couleur.nom}</td>
				<td>${bouteille.region.nom}</td>
				<td><a><i class="far fa-plus-square"></i></a> <a><i class="fas fa-times"></i></a>   </td>
			</tr>
		</c:forEach>
</table>
	

<c:import url="footer.jspf"></c:import>
</body>
</html>