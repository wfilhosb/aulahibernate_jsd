package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aulahibernate.aulahibernate.HibernateUtil;

public class DaoGeral<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}

	public E atualizar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		return entidadeSalva;
	}

	public E pesquisar(Long id, Class<E> entidade) {
		entityManager.clear();
		E e = (E) entityManager.find(entidade, id);
		return e;
	}

	//adicionamos o throws exception para subir a excessão
	public void delatarID (E entidade) throws Exception{
		Object id = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager
				.createNativeQuery(
						"delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where cod = " + id)
				.executeUpdate();
		transaction.commit();
	}

	public List<E> listar(Class<E> entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();
		return lista;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
