<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="mppa.folha.modelo.enumeracoes.FormasNomeacao" %>

<!DOCTYPE html>
<html>
<head>
<title>Cadastro Cargo</title>
<link href="../resources/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<h1>CADASTRO CARGO</h1>

	<form action="${cargo.id == null ? 'criar' : 'atualizar'}">
	
		<input type="hidden" name="id" value="${cargo.id}" />
	
		<label for="den">DENOMINAÇÃO: </label> 
		<input id="den"	name="denominacao" type="text" required="required" pattern="[a-zA-Zãâáêéíõôóûúç\s]*" value="${cargo.denominacao}" /> 
		<label for="fn">FORMA NOMEAÇÃO: </label> 
		<select id="fn" name="forma_nomeacao" required="required">
			
			<c:forEach var="fn" items="${FormasNomeacao.values()}">
				<option value="${fn}" ${cargo.forma_nomeacao == fn ? 'selected' : ''} >${fn}</option>
			</c:forEach>
			
		</select> 

		<input type="submit" value="SALVAR">

	</form>

</body>
</html>