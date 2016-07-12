package com.hx.pro.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.pro.dao.IBaseDao;
import com.hx.pro.service.IBaseService;

@Service("baseService")
public class BaseService implements IBaseService {
	@Autowired
	private IBaseDao baseDao;

	@Override
	public Object get(Class entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public void delete(Object entity) {
		baseDao.delete(entity);
	}

	@Override
	public void saveOrUpdate(Object entity, Serializable id, Class entityClass) {
		baseDao.saveOrUpdate(entity, id, entityClass);
	}

	@Override
	public void executeHql(String hql, Object... values) {
		baseDao.executeHql(hql, values);
	}

	@Override
	public void executeSql(String sql, Object... values) {
		baseDao.executeSql(sql, values);
	}

	@Override
	public List getListByHql(String hql, Object... values) {
		return baseDao.getListByHql(hql, values);
	}

	@Override
	public List getListBySql(String sql, Object... values) {
		return baseDao.getListBySql(sql, values);
	}

	@Override
	public List getPageListByHql(String hql, int pageIndex, int pageSize, Object... values) {
		return baseDao.getPageListByHql(hql, pageIndex, pageSize, values);
	}

	@Override
	public List getPageListBySql(String sql, int pageIndex, int pageSize, Object... values) {
		return baseDao.getPageListBySql(sql, pageIndex, pageSize, values);
	}

	
}
