package mppa.folha.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mppa.folha.modelo.UnidadeAdministrativa;

class UnidadeAdministrativaTestes {

	@Test
	void test() {
		
		UnidadeAdministrativa ua = new UnidadeAdministrativa();
		ua.setDenominacao("Folha");
		
		assertEquals("Folha", ua.getDenominacao());
		
		System.out.println(ua);
		
	}

}
