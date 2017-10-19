package com.see.cloud.provider.sys.mapper;

import com.see.cloud.provider.sys.model.SysUser;

public interface SysUserMapper {

	int insert(SysUser record);

	SysUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysUser record);

}