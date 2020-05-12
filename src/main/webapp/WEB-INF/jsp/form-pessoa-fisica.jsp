<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="mppa.folha.modelo.enumeracoes.Sexo" %>

<!DOCTYPE html>
<html>
<head>
	<title>Cadastro PF</title>
	<link href="../resources/estilo.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../resources/validacaoFrontEnd.js"></script>
</head>
	<body>
	
		<h1>CADASTRO PESSOA FÍSICA</h1>
	
		<form action="${pessoaFisica.id == null ? 'criar' : 'atualizar'}">
			
			<input type="hidden" name="id" value="${pessoaFisica.id}" />
			
			<label for="nome">NOME: </label> 
			<input id="nome" name="nome" type="text" required="required" pattern="[a-zA-Zãâáêéíõôóûúç\s]*" value="${pessoaFisica.nome}" /> 
			<label for="data_nascimento">DATA DE NASCIMENTO: </label>
			<fmt:formatDate value="${pessoaFisica.data_nascimento}" var="dta_nasc" pattern="yyyy-MM-dd" />
			<input id="data_nascimento" name="data_nascimento" type="date" value="${dta_nasc}" />
			<label for="sexo">SEXO: </label>
			<select id="sexo" name="sexo">
				<c:forEach var="sexo" items="${Sexo.values()}" >
					<option value="${sexo.valor}" ${pessoaFisica.sexo == sexo.valor ? 'selected' : ''} >${sexo}</option>
				</c:forEach>
			</select>
			<label for="cpf">CPF: </label>
			<input id="cpf" name="cpf" type="text" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" maxlength="14" onkeyup="formatarCpf(event)" value="${pessoaFisica.cpf}" />
	
			<input type="submit" value="SALVAR">
	
		</form>
	
	</body>
</html>