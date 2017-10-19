package com.see.cloud.provider.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.see.cloud.provider.sys.mapper.SysUserMapper;
import com.see.cloud.provider.sys.model.SysUser;
import com.see.cloud.provider.sys.service.ISysUser;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysUserImpl implements ISysUser {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getByPrimaryKey(Integer id) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
		return sysUser;
	}

	// 注意：方法的@Transactional会覆盖类上面声明的事务
	// Propagation.REQUIRED ：有事务就处于当前事务中，没事务就创建一个事务
	// isolation=Isolation.DEFAULT：事务数据库的默认隔离级别
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public int savn(SysUser sysUser) {
		return sysUserMapper.insert(sysUser);
	}

}
