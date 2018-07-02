package com.ley.springboot.mybatis.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User save vo
 * **/
public class UserSaveVo {

    @NotBlank(message="密码不能为空字符串或者为空")
    @Length(min=6,max=50,message="登录密码长度最小6位,最大50位")
    private String userName;

    @NotBlank(message="用户名不能为空字符串或者为空")
    @Length(min=6,max=50,message="用户名长度最小6位,最大50位")
    private String userPwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "UserSaveVo [userName=" + userName + ", userPwd=" + userPwd + "]";
	}
    
    
}
