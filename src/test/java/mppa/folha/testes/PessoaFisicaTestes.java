package mppa.folha.testes;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mppa.folha.modelo.PessoaFisica;

class PessoaFisicaTestes {

	@Test
	void test() {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Fernando Furtado");
		
		assertEquals("Fernando Furtado", pf.getNome());
		
		System.out.println(pf);
		
	}

}
