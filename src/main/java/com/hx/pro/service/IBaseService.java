package com.hx.pro.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseService {
	public Object get(Class entityClass, Serializable id);
	public void delete(Object entity);
	public void saveOrUpdate(Object entity, Serializable id, Class entityClass);
	public void executeHql(String hql, Object... values);
	public void executeSql(String sql, Object... values);
	public List getListByHql(String hql, Object... values);
	public List getListBySql(String sql, Object... values);
	public List getPageListByHql(String hql, int pageIndex, int pageSize, Object... values);
	public List getPageListBySql(String sql, int pageIndex, int pageSize, Object... values);
}
