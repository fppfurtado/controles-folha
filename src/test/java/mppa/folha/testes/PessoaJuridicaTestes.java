package mppa.folha.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mppa.folha.modelo.PessoaJuridica;

class PessoaJuridicaTestes {

	@Test
	void test() {
		
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNome_fantasia("MPPA");
		
		assertEquals("MPPA", pj.getNome_fantasia());
		
		System.out.println(pj);
		
		
	}

}
