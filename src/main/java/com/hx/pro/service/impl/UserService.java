package com.hx.pro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.pro.dao.IUserDao;
import com.hx.pro.entity.User;
import com.hx.pro.service.IUserService;

@Service("userService")
public class UserService implements IUserService{
	@Autowired
	private IUserDao uDao;

	@Override
	public void processSave() {
		System.out.println("-------------from UserService.processSave()");
		uDao.save();
	}
	
	@Override
	public void saveUser(User user) {
		uDao.saveUser(user);
	}

}
