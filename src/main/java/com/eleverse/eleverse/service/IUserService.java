package com.eleverse.eleverse.service;


import com.eleverse.eleverse.pojo.User;
import com.eleverse.eleverse.vo.ResponseVo;

public interface IUserService {

	/**
	 * 注册
	 */
	ResponseVo<User> register(User user);

	/**
	 * 登录
	 */
	ResponseVo<User> login(String username, String password);

}
