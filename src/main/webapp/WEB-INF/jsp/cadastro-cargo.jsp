<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Cadastro Cargo</title>
<link href="../resources/estilo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../resources/validacaoFrontEnd.js"></script>
</head>
<body>

	<h1>CADASTRO CARGO</h1>

	<form action="salvar-cargo">
		<label for="den">DENOMINA��O: </label> 
		<input id="den"	name="denominacao" type="text" required="required"	pattern="[a-zA-Z������������\s]*" /> 
		<label for="fn">FORMA NOMEA��O: </label> 
		<select id="fn" name="forma_nomeacao">
			<option value="EFETIVO">EFETIVO</option>
			<option value="EM_COMISSAO">EM COMISS�O</option>
		</select> 
		<label for="org">ORGANIZA��O: </label> 
		<select id="org" name="organizacao">

			<jsp:useBean id="dao" class="mppa.folha.dao.CargoDao" />
			
			<c:forEach var="organizacao" items="${dao.lista}">
				<option value="${organizacao.id}" >${organizacao.nome_Fantasia}</option>
			</c:forEach>
			
		</select>

		<input type="submit" value="SALVAR">

	</form>

</body>
</html>