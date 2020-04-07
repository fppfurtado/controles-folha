package mppa.folha.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mppa.folha.dao.DAO;
import mppa.folha.modelo.Cargo;
import mppa.folha.modelo.enumeracoes.FORMAS_NOMEACAO;

class BancoDeDadosTestes {

	@Test
	void test() {
		
		DAO dao = DAO.getInstancia();
		
		Cargo cargo = dao.criar(new Cargo("Assessor", FORMAS_NOMEACAO.EM_COMISSAO, null));
		
		assertEquals(1, cargo.getId());
		
	}

}
