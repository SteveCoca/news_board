package com.hx.pro.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hx.pro.dao.IBaseDao;
import com.hx.pro.util.FieldUtil;

@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDao implements IBaseDao {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public Object get(Class entityClass, Serializable id) {
		return getSession().get(entityClass, id);
	}
	@Override
	public void delete(Object entity) {
		getSession().delete(entity);
	}
	@Override
	public void saveOrUpdate(Object destination, Serializable id, Class entityClass) {
		if (id == null)
			getSession().save(destination);
		else {
			Object origin = this.get(entityClass, id);
			FieldUtil.mergeObject(origin, destination);
			getSession().update(origin);
		}
	}
	@Override
	public void executeHql(String hql, Object... values) {
		createHqlQuery(hql, values).executeUpdate();
	}
	@Override
	public void executeSql(String sql, Object... values) {
		createSqlQuery(sql, values).executeUpdate();
	}
	@Override
	public List getListByHql(String hql, Object... values) {
		return createHqlQuery(hql, values).list();
	}
	@Override
	public List getListBySql(String sql, Object... values) {
		return createSqlQuery(sql, values).list();
	}
	@Override
	public List getPageListByHql(String hql, int pageIndex, int pageSize, Object... values) {
		return createHqlQuery(hql, values).setFirstResult(pageSize * (pageIndex - 1)).setMaxResults(pageSize).list();
	}
	@Override
	public List getPageListBySql(String sql, int pageIndex, int pageSize, Object... values) {
		return createSqlQuery(sql, values).setFirstResult(pageSize * (pageIndex - 1)).setMaxResults(pageSize).list();
	}
	
	
	private Query createHqlQuery(String hql, Object... values) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	private Query createSqlQuery(String sql, Object... values) {
		Query query = getSession().createSQLQuery(sql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
