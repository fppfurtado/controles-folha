<!DOCTYPE html>
<html>
<head>
<title>Cadastro PJ</title>
<link href="../resources/estilo.css" rel="stylesheet" type="text/css" >
</head>
<body>

	<h1>CADASTRO PESSOA JURÍDICA</h1>

	<form action="/cadastro/pessoa-juridica">
	
		<label for="nf">NOME FANTASIA: </label>
		<input type="text" id="nf" name="nome_fantasia" />
		<label for="rs">RAZÃO SOCIAL: </label>
		<input type="text" id="rs" name="razao_social" />
		<label for="acrn">ACRÔNIMO: </label>
		<input type="text" id="acrn" name="acronimo" />
		<label for="cnpj">CNPJ: </label>
		<input type="text" id="cnpj" name="cnpj" maxlength="17" pattern="[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}" onkeyup="formatarCnpj(event)" />
		<label for="esf">ESFERA GOVERNAMENTAL: </label>
		<select id="esf" name="esfera">
			<option value="f">FEDERAL</option>
			<option value="e">ESTADUAL</option>
			<option value="d">DISTRITAL</option>
			<option value="m">MUNICIPAL</option>
		</select>
		<label for="pdr">PODER: </label>
		<select id="pdr" name="poder">
			<option value="e">EXECUTIVO</option>
			<option value="l">LEGISLATIVO</option>
			<option value="j">JUDICIARIO</option>
			<option value="oa">ÓRGÃO AUTÔNOMO</option>
		</select>
		
		<input type="submit" value="SALVAR" />
	
	</form>

</body>
</html>