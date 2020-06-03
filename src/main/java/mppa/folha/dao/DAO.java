package mppa.folha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public abstract class DAO<T> {

	protected static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory("folha").createEntityManager();
		}

		return entityManager;
	}

	public T criar(T entidade) {

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

	public void atualizar(T entidade) {

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	public abstract T buscar(Long id);

	public void excluir(T entidade) {

		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}
	
	public abstract List<T> getRegistrosPaginacao(String pagina);
	
	public abstract Long contarRegistros();

}