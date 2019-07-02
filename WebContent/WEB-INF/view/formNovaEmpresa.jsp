<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<html>
<body>
	<c:import url="logout-parcial.jsp" />

	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" />
		Data Abertura: <input type="text" name="data" /> <input type="submit">
		<input type="hidden" name="acao" value="NovaEmpresa">
	</form>
</body>
</html>