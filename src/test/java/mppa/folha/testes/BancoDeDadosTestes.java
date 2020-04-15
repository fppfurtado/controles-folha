package mppa.folha.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import mppa.folha.dao.DAO;
import mppa.folha.dao.PessoaFisicaDao;
import mppa.folha.modelo.Cargo;
import mppa.folha.modelo.PessoaFisica;
import mppa.folha.modelo.enumeracoes.FORMAS_NOMEACAO;

class BancoDeDadosTestes {

	@Test
	void test() {
		
		DAO<PessoaFisica> dao = PessoaFisicaDao.getInstancia();
		
		assertEquals(dao.getLista().getClass(), ArrayList.class);
		
	}

}
