package mppa.folha.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mppa.folha.modelo.UnidadeAdministrativa;
import mppa.folha.modelo.PessoaJuridica;
import mppa.folha.modelo.UnidadeAdministrativa;

public class UnidadeAdmDao extends DAO<UnidadeAdministrativa> {
	
	private static DAO<UnidadeAdministrativa> instancia;
	
	public static DAO<UnidadeAdministrativa> getInstancia() {
		
		if(instancia == null)
			instancia = new UnidadeAdmDao();
		
		return instancia;
		
	}
	
	private UnidadeAdmDao() {
		entityManager = getEntityManager();
	}
	
	@Override
	public UnidadeAdministrativa buscar(Long id) {
		return entityManager.find(UnidadeAdministrativa.class, id);
	}

	public List<UnidadeAdministrativa> getLista() {

		Class<UnidadeAdministrativa> classe = UnidadeAdministrativa.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UnidadeAdministrativa> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<UnidadeAdministrativa> rootQuery = criteriaQuery.from(classe);
		criteriaQuery.select(rootQuery);

		return entityManager.createQuery(criteriaQuery).getResultList();

	}

	@Override
	public List<UnidadeAdministrativa> getRegistrosPaginacao(int pagina, int registrosPorPagina) {
		
		Class<UnidadeAdministrativa> classe = UnidadeAdministrativa.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UnidadeAdministrativa> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<UnidadeAdministrativa> rootQuery = criteriaQuery.from(classe);
		criteriaQuery.select(rootQuery);
		
		return entityManager.createQuery(criteriaQuery)
				.setFirstResult((pagina-1)*registrosPorPagina)
				.setMaxResults(registrosPorPagina)
				.getResultList();
	}
	
	@Override
	public Long contarRegistros() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<UnidadeAdministrativa> root = cq.from(UnidadeAdministrativa.class);
		cq.select(cb.count(root));
		
		return entityManager.createQuery(cq).getSingleResult();
	}

}