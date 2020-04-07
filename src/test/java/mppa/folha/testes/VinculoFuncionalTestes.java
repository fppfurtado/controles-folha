package mppa.folha.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mppa.folha.modelo.VinculoFuncional;

class VinculoFuncionalTestes {

	@Test
	void test() {

		VinculoFuncional vf = new VinculoFuncional();
		vf.setMatricula("999.2777");
		
		assertEquals("999.2777", vf.getMatricula());
		
		System.out.println(vf);
		
	}

}