package com.see.cloud.core.common.entitys;

import com.see.cloud.core.common.enums.ResultCode;

public class ResultBody<T> {

	private String code;
	private String msg;
	private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResultBody(ResultCode errorEnum) {
		this.code = errorEnum.getCode();
		this.msg = errorEnum.getMsg();
	}

	public ResultBody(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResultBody(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultBody(String code) {
		this.code = code;
	}

	public ResultBody() {
	}

	@Override
	public String toString() {
		return "ResultBody{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
	}
}