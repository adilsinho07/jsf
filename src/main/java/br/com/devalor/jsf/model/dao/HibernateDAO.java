package br.com.devalor.jsf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable {

	private static final long serialVersionUID = 1L;
	private Class<T> classe;
	private Session session;

	public HibernateDAO(Class<T> classe, Session session) {
		super();
		this.classe = classe;
		this.session = session;
	}

	@Override
	public void save(T entitie) {
		session.save(entitie);
	}

	@Override
	public void update(T entitie) {
		session.update(entitie);
	}

	@Override
	public void remove(T entitie) {
		session.delete(entitie);
	}

	@Override
	public void merge(T entitie) {
		session.merge(entitie);
	}

	@Override
	public T getEntitie(Serializable id) {
		T entity = (T) session.get(classe, id);
		return entity;
	}

	@Override
	public T getEntitieByDetachedCriteria(DetachedCriteria criteria) {
		T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
		return entity;
	}

	@Override
	public List<T> getEntities() {
		List<T> entities = (List<T>) session.createCriteria(classe).list();
		return entities;
	}

	@Override
	public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(session).list();
	}

}
