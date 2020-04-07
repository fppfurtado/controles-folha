package mppa.folha.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mppa.folha.modelo.Cargo;

class CargoTestes {

	@Test
	void test() {
		
		Cargo cargo = new Cargo();
		cargo.setDenominacao("Auxiliar de Administracao");
		
		assertEquals("Auxiliar de Administracao", cargo.getDenominacao());
		
		System.out.println(cargo);
		
	}

}
