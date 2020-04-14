<!DOCTYPE html>
<html>
<head>
<title>Cadastro PJ</title>
<link href="../resources/estilo.css" rel="stylesheet" type="text/css" >
</head>
<body>

	<h1>CADASTRO PESSOA JURÍDICA</h1>

	<form action="salvar-pessoa-juridica">
	
		<label for="nf">NOME FANTASIA: </label>
		<input type="text" id="nf" name="nome_fantasia" />
		<label for="rs">RAZÃO SOCIAL: </label>
		<input type="text" id="rs" name="razao_social" />
		<label for="acrn">ACRÔNIMO: </label>
		<input type="text" id="acrn" name="acronimo" />
		<label for="cnpj">CNPJ: </label>
		<input type="text" id="cnpj" name="cnpj" maxlength="18" pattern="[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}" onkeyup="formatarCnpj(event)" />
		<label for="esf">ESFERA GOVERNAMENTAL: </label>
		<select id="esf" name="esfera">
			<option value="FEDERAL">FEDERAL</option>
			<option value="ESTADUAL">ESTADUAL</option>
			<option value="DISTRITAL">DISTRITAL</option>
			<option value="MUNICIPAL">MUNICIPAL</option>
		</select>
		<label for="pdr">PODER: </label>
		<select id="pdr" name="poder">
			<option value="EXECUTIVO">EXECUTIVO</option>
			<option value="LEGISLATIVO">LEGISLATIVO</option>
			<option value="JUDICIARIO">JUDICIARIO</option>
			<option value="ORGAO_AUTONOMO">ÓRGÃO AUTÔNOMO</option>
		</select>
		
		<input type="submit" value="SALVAR" />
	
	</form>

</body>
</html>