package com.gekkobt.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 * JPA implementation of the GenericRepository. Note that this implementation
 * also expects Hibernate as JPA implementation. That's because we like the
 * Criteria API.
 * 
 * @param <T>
 *            The persistent type
 * @param <ID>
 *            The primary key type
 */
public class GenericDAO<T, ID extends Serializable> implements
		GenericDAOInterface<T, ID> {

	// ~ Instance fields
	// --------------------------------------------------------
	private final Class<T> persistentClass;

	@PersistenceContext
	protected EntityManager em;

	// ~ Constructors
	// -----------------------------------------------------------

	@SuppressWarnings("unchecked")
	public GenericDAO() {

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GenericDAO(final Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	// ~ Methods
	// ----------------------------------------------------------------

	@Override
	public Class<T> getEntityClass() {
		return persistentClass;
	}

	@Override
	public int countAll() {
		return countByCriteria();

	}

	@Override
	public int countByExample(final T exampleInstance) {
		Criteria crit = null;
		try {
			Session session = (Session) em.getDelegate();
			crit = session.createCriteria(getEntityClass());
			crit.setProjection(Projections.rowCount());
			crit.add(Example.create(exampleInstance));
		} catch (Exception e) {

		}
		return (Integer) crit.list().get(0);
	}

	@Override
	public List<T> findAll() {
		List<T> ret = null;
		try {
			ret = findByCriteria();
		} catch (Exception e) {

		}

		return ret;
	}

	@Override
	public List<T> findAll(String propertyOrder, Boolean isDesc) {
		List<T> ret = null;
		try {
			ret = findByCriteria(propertyOrder, isDesc);
		} catch (Exception e) {

		}

		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(final T exampleInstance) {
		List<T> result = null;
		try {
			Session session = (Session) em.getDelegate();
			Criteria crit = session.createCriteria(getEntityClass());
			result = crit.list();
		} catch (Exception e) {

		}
		return result;
	}

	@Override
	public T findById(final ID id) {
		T result = null;
		try {
			result = em.find(persistentClass, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(final String name, Object... params) {
		List<T> result = null;

		try {
			javax.persistence.Query query = em.createNamedQuery(name);

			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			result = (List<T>) query.getResultList();
		} catch (Exception e) {

		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		List<T> result = null;
		try {
			javax.persistence.Query query = em.createNamedQuery(name);

			for (final Map.Entry<String, ? extends Object> param : params
					.entrySet()) {
				query.setParameter(param.getKey(), param.getValue());
			}
			result = (List<T>) query.getResultList();
		} catch (Exception e) {

		}
		return result;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected List<T> findByCriteria(final Criterion... criterion) {
		List<T> ret = null;
		try {
			ret = findByCriteria(null, null, -1, -1, criterion);
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected List<T> findByCriteria(String propertyOrder, Boolean isDesc,
			final Criterion... criterion) {
		List<T> ret = null;
		try {
			ret = findByCriteria(propertyOrder, isDesc, -1, -1, criterion);
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(String propertyOrder, Boolean isDesc,
			final int firstResult, final int maxResults,
			final Criterion... criterion) {
		List<T> result = null;

		try {
			Session session = (Session) em.getDelegate();
			Criteria crit = session.createCriteria(getEntityClass());

			for (final Criterion c : criterion) {
				crit.add(c);
			}

			if (firstResult > 0) {
				crit.setFirstResult(firstResult);
			}

			if (maxResults > 0) {
				crit.setMaxResults(maxResults);
			}

			if (propertyOrder != null && !propertyOrder.isEmpty()) {
				if (isDesc) {
					crit.addOrder(Order.desc(propertyOrder));
				} else {
					crit.addOrder(Order.asc(propertyOrder));
				}
			}

			result = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	protected int countByCriteria(Criterion... criterion) {

		Integer ret = null;

		Session session = (Session) em.getDelegate();
		Criteria crit = session.createCriteria(getEntityClass());
		crit.setProjection(Projections.rowCount());

		for (final Criterion c : criterion) {
			crit.add(c);
		}
		ret = (Integer) crit.list().get(0);

		return ret;
	}

	@Override
	public void delete(T entity) {
		try {
			em.remove(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T save(T entity) {
		try {
			em.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public T update(T entity) {
		try {
			em.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return entity;
	}

}