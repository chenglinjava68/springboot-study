package com.ley.springboot.mybatis.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ley.springboot.mybatis.annotation.NeedValidation;
import com.ley.springboot.mybatis.entity.User;
import com.ley.springboot.mybatis.http.Response;
import com.ley.springboot.mybatis.http.ResponseCodeEnum;
import com.ley.springboot.mybatis.service.UserService;
import com.ley.springboot.mybatis.utils.BeanMapper;
import com.ley.springboot.mybatis.vo.UserSaveVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/user")
@Api("user controller")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	@Qualifier("beanMapper")
	private BeanMapper beanMapper;

	@GetMapping(value = "/{userId}")
	@ApiOperation(value="根据Id获取User")
	public Response getUserById(@PathVariable Integer userId){
		User user = userService.selectByPrimaryKey(userId);
		if (user == null) {
			return new Response(ResponseCodeEnum.NO_DATA.getCode(), "数据没找到", null);
		} else {
			logger.info(user.toString());
			return new Response(ResponseCodeEnum.SUCCESS.getCode(), "数据返回成功", user);
		}
	}

	@ApiOperation(value="根据分页参数进行user分页")
	@GetMapping(value = "listUserByPage")
	public Response listUserByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
		List<User> users = userService.listUsersByPage(pageNum, pageSize);
		if (users == null || users.size() == 0) {
			return new Response(ResponseCodeEnum.NO_DATA.getCode(), "数据没找到", null);
		} else {
			return new Response(ResponseCodeEnum.SUCCESS.getCode(), "数据返回成功", users);
		}
	}
	
	@ApiOperation(value="添加user并进行JSR303校验")
	@NeedValidation
	@PostMapping(value="/addUser",consumes={"application/x-www-form-urlencoded;charset=utf-8"})
	public Response addUser(@Validated UserSaveVo userSaveVo,BindingResult errors){
		User user=beanMapper.map(userSaveVo, User.class);
		user.setGmtCreate(new Date(System.currentTimeMillis()));
		user.setIsDelete(false);
		int result=userService.insertSelective(user);
		if(result==0){
			return new Response(ResponseCodeEnum.UPDATE_UNSUCCESS.getCode(),"插入数据不成功",null);
		}else{
			return new Response(ResponseCodeEnum.SUCCESS.getCode(), "数据插入成功",user);
		}
	}
	
}
