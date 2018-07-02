package com.ley.springboot.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ley.springboot.mybatis.dao.UserMapper;
import com.ley.springboot.mybatis.entity.User;
import com.ley.springboot.mybatis.service.UserService;

@Service(value="userService")
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.SUPPORTS,readOnly=true)
	@Override
	public User selectByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.SUPPORTS,readOnly=true)
	@Override
	public List<User> listUsersByPage(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return userMapper.listUsersByPage(pageNum, pageSize);
	}
}
