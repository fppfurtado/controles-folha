package mppa.folha.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mppa.folha.modelo.Cargo;
import mppa.folha.modelo.Cargo;
import mppa.folha.modelo.PessoaJuridica;

public class CargoDao extends DAO<Cargo> {
	
	private static DAO<Cargo> instancia;
	
	public static DAO<Cargo> getInstancia() {
		
		if(instancia == null)
			instancia = new CargoDao();
		
		return instancia;
		
	}
	
	private CargoDao() {
		entityManager = getEntityManager();
	}
	
	@Override
	public Cargo buscar(Long id) {
		return entityManager.find(Cargo.class, id);
	}

	public List<Cargo> getLista() {

		Class<Cargo> classe = Cargo.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cargo> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<Cargo> rootQuery = criteriaQuery.from(classe);
		criteriaQuery.select(rootQuery);

		return entityManager.createQuery(criteriaQuery).getResultList();

	}

	@Override
	public List<Cargo> getRegistrosPaginacao(String pagina) {
		
		Integer pag = Integer.parseInt(pagina);
		
		Class<Cargo> classe = Cargo.class;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cargo> criteriaQuery = criteriaBuilder.createQuery(classe);
		Root<Cargo> rootQuery = criteriaQuery.from(classe);
		criteriaQuery.select(rootQuery);
		
		return entityManager.createQuery(criteriaQuery)
				.setFirstResult((pag-1)*10)
				.setMaxResults(10)
				.getResultList();
	}
	
	@Override
	public Long contarRegistros() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Cargo> root = cq.from(Cargo.class);
		cq.select(cb.count(root));
		
		return entityManager.createQuery(cq).getSingleResult();
	}

}