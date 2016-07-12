package com.hx.pro.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hx.pro.dao.IUserDao;
import com.hx.pro.entity.User;

@Repository("userDao")
public class UserDao implements IUserDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void save() {
		System.out.println("------------from UserDao.save()");
	}
	
	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
}
