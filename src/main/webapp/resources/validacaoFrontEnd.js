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

function formatarCnpj(event) {
	
	var campo = event.target;
	var cnpj = campo.value;

	cnpj = cnpj.split("");

	if (cnpj.length > 2 && cnpj[2] != ".") {
		cnpj.splice(2, 0, ".");
	}

	if (cnpj.length > 6 && cnpj[6] != ".") {
		cnpj.splice(6, 0, ".");
	}

	if (cnpj.length > 10 && cnpj[10] != "/") {
		cnpj.splice(10, 0, "/");
	}
	
	if (cnpj.length > 15 && cnpj[15] != "-") {
		cnpj.splice(15, 0, "-");
	}

	campo.value = cnpj.join("");
	
}