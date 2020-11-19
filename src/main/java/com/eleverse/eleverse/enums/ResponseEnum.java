package com.eleverse.eleverse.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {

	ERROR(-1, "服务端错误"),

	SUCCESS(0, "成功"),

	PASSWORD_ERROR(1,"密码错误"),

	USERNAME_EXIST(2, "用户名已存在"),

	PARAM_ERROR(3, "参数错误"),

	NEED_LOGIN(4, "用户未登录, 请先登录"),

	USERNAME_OR_PASSWORD_ERROR(5, "用户名或密码错误"),

	NONE_DATA(6,"未查询到数据"),

	UID_ERROR(7,"UID重复"),

	UID_NOEXIST(8,"数据不存在"),

	CAPACITY_ERROR(9,"容量不够用，无法添加"),

	USERNAME_NOTEXIST(10, "用户不存在"),

	NONDEVICEUID(11, "设备UID不存在"),

	NONBOXUID(11, "盒UID不存在"),

	ID_ERROR(12,"ID重复"),


	;

	Integer code;

	String desc;

	ResponseEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
