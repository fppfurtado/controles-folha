package mppa.folha.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mppa.folha.modelo.PessoaFisica;

public class PessoaFisicaDao extends DAO<PessoaFisica> {
	
	private static DAO<PessoaFisica> instancia;
	
	public static DAO<PessoaFisica> getInstancia() {
		
		if(instancia == null)
			instancia = new PessoaFisicaDao();
		
		return instancia;
		
	}
	
	private PessoaFisicaDao() {
		entityManager = getEntityManager();
	}
	
	@Override
	public PessoaFisica buscar(Long id) {
		return entityManager.find(PessoaFisica.class, id);
	}

	public List<PessoaFisica> getLista() {

		Class<PessoaFisica> classe = PessoaFisica.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PessoaFisica> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<PessoaFisica> rootQuery = criteriaQuery.from(classe);
		criteriaQuery.select(rootQuery);

		return entityManager.createQuery(criteriaQuery).getResultList();

	}

}