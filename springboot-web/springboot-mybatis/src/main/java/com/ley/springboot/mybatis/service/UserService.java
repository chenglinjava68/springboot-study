package com.ley.springboot.mybatis.service;

import java.util.List;


import com.ley.springboot.mybatis.entity.User;

public interface UserService {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> listUsersByPage(Integer pageNum,Integer pageSize);
}
