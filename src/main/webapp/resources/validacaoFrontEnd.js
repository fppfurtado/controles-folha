/**
 * 
 */

function formatarCpf(event) {

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