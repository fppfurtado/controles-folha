<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Pessoa</title>
	<link href="../resources/estilo.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../resources/validacaoFrontEnd.js"></script>
</head>
	<body>
	
		<h1>CADASTRO PESSOA FÍSICA</h1>
	
		<form action="salvar-pessoa-fisica">
			<label for="nome">NOME: </label> 
			<input id="nome" name="nome" type="text" required="required" pattern="[a-zA-Zãâáêéíõôóûúç\s]*" /> 
			<label for="data_nascimento">DATA DE NASCIMENTO: </label>
			<input id="data_nascimento" name="data_nascimento" type="date" />
			<label for="sexo">SEXO: </label>
			<select id="sexo" name="sexo">
				<option value="m">masculino</option>
				<option value="f">feminino</option>
			</select>
			<label for="cpf">CPF: </label>
			<input id="cpf" name="cpf" type="text" required="required" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" maxlength="14" onkeyup="formatarCpf(event)" />
	
			<input type="submit" value="SALVAR">
	
		</form>
	
	</body>
</html>