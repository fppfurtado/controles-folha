package mppa.folha.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mppa.folha.modelo.PessoaJuridica;

public class PessoaJuridicaDao extends DAO<PessoaJuridica> {
	
	private static DAO<PessoaJuridica> instancia;
	
	public static DAO<PessoaJuridica> getInstancia() {
		
		if(instancia == null)
			instancia = new PessoaJuridicaDao();
		
		return instancia;
		
	}
	
	private PessoaJuridicaDao() {
		entityManager = getEntityManager();
	}
	
	@Override
	public PessoaJuridica buscar(Long id) {
		return entityManager.find(PessoaJuridica.class, id);
	}

	public List<PessoaJuridica> getLista() {

		Class<PessoaJuridica> classe = PessoaJuridica.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PessoaJuridica> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<PessoaJuridica> rootQuery = criteriaQuery.from(classe);
		criteriaQuery.select(rootQuery);

		return entityManager.createQuery(criteriaQuery).getResultList();

	}

	@Override
	public List<PessoaJuridica> getRegistrosPaginacao(int pagina, int registrosPorPagina) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Long contarRegistros() {
		// TODO Auto-generated method stub
		return null;
	}

}