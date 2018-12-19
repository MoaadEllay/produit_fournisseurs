<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de stock</title>

      <link rel="stylesheet" href="css/style.css">

</head>
<body>

  <div class="page">
  <div class="container">
    <div class="left">
      <div class="login">Login</div>
      <div class="eula">Pour accéder à votre espace personnel, merci de saisir votre login/email et password</div>
    </div>
    <div class="right">
      
      <div class="form">
      <form action="./Login" method="post">
        <label for="email">Email</label>
        <input type="email" id="email" name="email">
        <label for="password">Password</label>
        <input type="password" id="password" name="password">
        <input type="submit"  value="Envoyer">
        </form>
      </div>
    </div>
  </div>
</div>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js'></script>

  

    <script  src="js/index.js"></script>




</body>

</html>