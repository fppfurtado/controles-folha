

<!DOCTYPE html>
<html>
<head>
<title>Cadastro Pessoa</title>
<link href="../resources/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<h1>CADASTRO PESSOA</h1>
	
	<form action="salvar-pessoa-fisica">
		<label for="nome">NOME: </label>
		<input id="nome" name="nome" type="text" />
		<label for="data_nascimento">DATA DE NASCIMENTO: </label>
		<input id="data_nascimento" name="data_nascimento" type="date" />
		<label for="sexo">SEXO: </label>
		<select id="sexo" name="sexo">
			<option value="m">masculino</option>
			<option value="f">feminino</option>		
		</select>
		<label for="cpf">CPF: </label>
		<input id="cpf" name="cpf" type="text" />
		
		<input type="submit" value="SALVAR">
		
	</form>

</body>
</html>