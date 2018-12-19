<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css'><link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'><link rel='stylesheet prefetch' href='Form.css'><link rel="stylesheet" href="css/Form.css"><link rel="stylesheet" href="css/style1.css">
</head>

<body>
<form id="contact" action="ServletController" method="post"> 
 <h4><b>Ajouter un produit à la base de données</b></h4>
 <fieldset><input placeholder="Id du produit" name="id_produit" type="text" tabindex="1" required="" autofocus="">
 </fieldset><fieldset> <input placeholder="Nom du produit" name="nom_produit" type="text" tabindex="2" required="">
  </fieldset><fieldset> <input placeholder="Prix" name="prix_produit" type="text" tabindex="3" required="">
  </fieldset><fieldset> <input placeholder="Fournisseur" name="id_fournisseur" type="text" tabindex="4" required=""> 
  </fieldset><fieldset> <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button></fieldset></form>

</body>
</html>