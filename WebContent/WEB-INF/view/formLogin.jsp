<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<html>
<body>
	<form action="${linkEntradaServlet}" method="post">
	
		Login: <input type="text" name="login" />
		Senha: <input type="password" name="senha" /> <input type="submit">
		<input type="hidden" name="acao" value="Login">
		
	</form>
</body>
</html>