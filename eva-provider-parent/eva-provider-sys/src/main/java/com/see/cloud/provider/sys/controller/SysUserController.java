package com.see.cloud.provider.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.see.cloud.provider.sys.model.SysUser;
import com.see.cloud.provider.sys.service.ISysUser;

@RestController
@RequestMapping("/sysUse")
public class SysUserController {
	@Autowired
	private ISysUser sysUserImpl;

	@GetMapping("/getUserByid/{id}")
	public SysUser getUserByid(@PathVariable Integer id) {
		return sysUserImpl.getByPrimaryKey(id);
	}
}
