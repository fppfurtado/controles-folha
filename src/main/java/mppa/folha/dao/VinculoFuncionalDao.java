package mppa.folha.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import mppa.folha.modelo.VinculoFuncional;

public class VinculoFuncionalDao extends DAO<VinculoFuncional> {

	public static DAO<VinculoFuncional> getInstancia() {
		
		if(entityManager == null)
			entityManager = getEntityManager();
		
		return new VinculoFuncionalDao();
		
	}
	
	private VinculoFuncionalDao() {
		entityManager = getEntityManager();
	}
	
	@Override
	public VinculoFuncional buscar(Long id) {
		return entityManager.find(VinculoFuncional.class, id);
	}

	@Override
	public List<VinculoFuncional> getRegistrosPaginacao(String pagina) {
		
		Integer pag = Integer.parseInt(pagina);
		
		Class<VinculoFuncional> classe = VinculoFuncional.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VinculoFuncional> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<VinculoFuncional> rootQuery = criteriaQuery.from(classe);
		criteriaQuery.select(rootQuery);
		
			return entityManager.createQuery(criteriaQuery).setFirstResult((pag - 1) * 10).getResultList();
		
	}

	@Override
	public Long contarRegistros() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<VinculoFuncional> root = cq.from(VinculoFuncional.class);
		cq.select(cb.count(root));
		
		return entityManager.createQuery(cq).getSingleResult();
		
	}
	
	public List<VinculoFuncional> getVinculosPJ(String idPJ) {
		
		Class<VinculoFuncional> classe = VinculoFuncional.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VinculoFuncional> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<VinculoFuncional> rootQuery = criteriaQuery.from(classe);
		//ParameterExpression<Long> idPJ = criteriaBuilder.parameter(Long.class);
		
		criteriaQuery.select(rootQuery);
		criteriaQuery.where(criteriaBuilder.equal(rootQuery.get("pessoa_juridica"), Long.parseLong(idPJ)));		
		
		return entityManager.createQuery(criteriaQuery).getResultList();
		
	}

}