package mppa.folha.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class DAO {

	private static DAO instancia;
	protected EntityManager entityManager;

	public static DAO getInstancia() {
		if (instancia == null) {
			instancia = new DAO();
		}
		return instancia;
	}

	private DAO() {
		entityManager = getEntityManager();
	}

	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory("folha").createEntityManager();
		}

		return entityManager;
	}

	public <T> T criar(T entidade) throws PersistenceException {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entidade);
			entityManager.getTransaction().commit();
			return entidade;
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw new PersistenceException("Erro de gravação no Banco de Dados: valor duplicado ou inválido.");			
		}
		
	}

	public <T> void atualizar(T entidade) {

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	public <T> T buscar(Class<T> classe, Long id) {

		return entityManager.find(classe, id);

	}

	public <T> void excluir(T entidade) {

		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

}