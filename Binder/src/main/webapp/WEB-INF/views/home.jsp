<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Esto se puede pensar como un import -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- el prefix es lo que se usa para utilizar una instrucción de lo que se importó -->

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<!-- El chiste del commandName es que poble un objeto de jsp a uno de java con sus atributos correspondientes -->
	
	<!-- User.java
		private String username
		private String password
		
		getters()/setters()
		 -->
	<form:form commandName="user" method="POST"> <!-- Esto es lo que spring usa para comunicarse con el controller, es un "sprin form", no una forma de HTML -->
	<!-- commandName es lo que vincula con el modelo del MVC -->

		username: <input type="text" id="username">
		password: <input type="password" id="password">
		<input type="submit" id="submitBtn" value="submit">
	</form:form>

</body>
</html>
