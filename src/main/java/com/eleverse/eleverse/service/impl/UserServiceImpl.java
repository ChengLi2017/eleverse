package com.eleverse.eleverse.service.impl;


import com.eleverse.eleverse.dao.UserMapper;
import com.eleverse.eleverse.enums.ResponseEnum;
import com.eleverse.eleverse.pojo.User;
import com.eleverse.eleverse.service.IUserService;
import com.eleverse.eleverse.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;


@Service("userService")
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier(value = "userMapper")
	private UserMapper userMapper;

	/**
	 * 注册
	 *
	 * @param user
	 */
	@Override
	public ResponseVo<User> register(User user) {
//		error();

		//username不能重复
		int countByUsername = userMapper.countByUsername(user.getUsername());
		if (countByUsername > 0) {
			return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
		}

		//MD5摘要算法(Spring自带)
		user.setPassword(DigestUtils.md5DigestAsHex(
				user.getPassword().getBytes(StandardCharsets.UTF_8)
		));

		//写入数据库
		int resultCount = userMapper.insertSelective(user);
		if (resultCount == 0) {
			return ResponseVo.error(ResponseEnum.ERROR);
		}

		return ResponseVo.success();
	}

	@Override
	public ResponseVo<User> login(String username, String password) {
		User user = userMapper.selectByUsername(username);
		if (user == null) {
			//用户不存在（返回：用户名或密码错误 ）
			return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
		}

		if (!user.getPassword().equalsIgnoreCase(
				DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
			//密码错误(返回：用户名或密码错误 )
			return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
		}

		user.setPassword("");
		return ResponseVo.success(user);
	}

	private void error() {
		throw new RuntimeException("意外错误");
	}
}
