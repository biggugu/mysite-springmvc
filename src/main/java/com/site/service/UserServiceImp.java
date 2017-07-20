package com.site.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.site.dao.UserDao;
import com.site.model.User;
@Service
public class UserServiceImp implements UserService{
	
	@Resource
	private UserDao userDao;

	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		
		return this.userDao.selectByName(username);
	}
	
}
