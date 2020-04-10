<!DOCTYPE html>
<html>
<head>
<title>Cadastro Pessoa</title>
<link href="../resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<h1>CADASTRO PESSOA</h1>

	<form action="salvar-pessoa-fisica">
		<label for="nome">NOME: </label> 
		<input id="nome" name="nome" type="text" required="required" /> 
		<label for="data_nascimento">DATA DE NASCIMENTO: </label>
		<input id="data_nascimento" name="data_nascimento" type="date" />
		<label for="sexo">SEXO: </label>
		<select id="sexo" name="sexo">
			<option value="m">masculino</option>
			<option value="f">feminino</option>
		</select>
		<label for="cpf">CPF: </label>
		<input id="cpf" name="cpf" type="text" required="required" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" maxlength="14" onkeyup="funcao(event)" />

		<input type="submit" value="SALVAR">

	</form>

	<script type="text/javascript">
		function funcao(event) {

			var campo = event.target;
			var cpf = campo.value;

			cpf = cpf.split("");

			if (cpf.length > 3 && cpf[3] != ".") {

				cpf.splice(3, 0, ".");

			}

			if (cpf.length > 7 && cpf[7] != ".") {

				cpf.splice(7, 0, ".");

			}

			if (cpf.length > 11 && cpf[11] != "-") {
				cpf.splice(11, 0, "-");
			}

			campo.value = cpf.join("");

		}
	</script>

</body>
</html>