package br.com.devalor.jsf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface InterfaceDAO<T> {

	void save(T entitie);

	void update(T entitie);

	void remove(T entitie);

	void merge(T entitie);

	T getEntitie(Serializable id);

	T getEntitieByDetachedCriteria(DetachedCriteria criteria);

	List<T> getEntities();

	List<T> getListByDetachedCriteria(DetachedCriteria criteria);

}
