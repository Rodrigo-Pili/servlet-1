<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" var="data" />

<html>
<body>
	<c:import url="logout-parcial.jsp" />
	
	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome}" />
		Data Abertura: <input type="text" name="data" value="${data}" /> 
		<input type="hidden" name="id" value="${empresa.id}">
		<input type="hidden" name="acao" value="AlteraEmpresa">
		<input type="submit">
	</form>
</body>
</html>