package com.see.cloud.provider.sys.service;

import com.see.cloud.provider.sys.model.SysUser;

public interface ISysUser {
	public SysUser getByPrimaryKey(Integer id);
}
