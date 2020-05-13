<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="mppa.folha.modelo.enumeracoes.Esferas, mppa.folha.modelo.enumeracoes.Poderes" %>

<!DOCTYPE html>
<html>
<head>
<title>Cadastro PJ</title>
<link href="../resources/estilo.css" rel="stylesheet" type="text/css" >
<script type="text/javascript" src="../resources/validacaoFrontEnd.js" ></script>
</head>
<body>

	<h1>CADASTRO PESSOA JURÍDICA</h1>

	<form action="${pessoaJuridica.id == null ? 'criar' : 'atualizar'}">
	
		<input type="hidden" name="id" value="${pessoaJuridica.id}" />
		
		<label for="nf">NOME FANTASIA: </label>
		<input type="text" id="nf" name="nome_fantasia" required="required" value="${pessoaJuridica.nome_fantasia}" />
		<label for="rs">RAZÃO SOCIAL: </label>
		<input type="text" id="rs" name="razao_social" value="${pessoaJuridica.razao_social}" />
		<label for="acrn">ACRÔNIMO: </label>
		<input type="text" id="acrn" name="acronimo" value="${pessoaJuridica.acronimo}" />
		<label for="cnpj">CNPJ: </label>
		<input type="text" id="cnpj" name="cnpj" maxlength="18" pattern="[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}" onkeyup="formatarCnpj(event)" value="${pessoaJuridica.cnpj}" />
		<label for="esf">ESFERA GOVERNAMENTAL: </label>
		<select id="esf" name="esfera">
			
			<c:forEach var="esfera" items="${Esferas.values()}">			
				<option value="${esfera}" ${pj.esfera == esfera ? 'selected' : ''} >${esfera}</option>			
			</c:forEach>
			
		</select>
		<label for="pdr">PODER: </label>
		<select id="pdr" name="poder">
			
			<c:forEach var="poder" items="${Poderes.values()}">
				<option value="${poder}" ${pj.poder == poder ? 'selected' : ''}>${poder}</option>
			</c:forEach>
			
		</select>
		
		<input type="submit" value="SALVAR" />
	
	</form>

</body>
</html>