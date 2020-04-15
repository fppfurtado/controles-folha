package mppa.folha.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

}