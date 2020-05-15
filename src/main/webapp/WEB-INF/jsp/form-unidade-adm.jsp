<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="mppa.folha.dao.PessoaJuridicaDao" %> --%>

<!DOCTYPE html>
<html>
<head>
<title>Cadastro Unidade Administrativa</title>
<link href="../resources/estilo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../resources/validacaoFrontEnd.js"></script>
</head>
<body>

	<h1>CADASTRO UNIDADE ADMINISTRATIVA</h1>

	<form action="${unidadeAdm.id == null ? 'criar' : 'atualizar'}">
	
		<input type="hidden" name="id" value="${unidadeAdm.id}" />
		
		<label for="den">DENOMINAÇÃO: </label> 
		<input id="den"	name="denominacao" type="text" required="required" pattern="[a-zA-Zãâáêéíõôóûúç\s]*" value="${unidadeAdm.denominacao}" /> 
		
		<input type="submit" value="SALVAR">

	</form>

</body>
</html>