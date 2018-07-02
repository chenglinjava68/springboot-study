package com.ley.springboot.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ley.springboot.mybatis.entity.User;

@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> listUsersByPage(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
}