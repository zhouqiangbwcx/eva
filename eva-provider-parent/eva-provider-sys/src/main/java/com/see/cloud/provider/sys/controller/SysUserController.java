package com.see.cloud.provider.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.see.cloud.core.common.entitys.ResultBody;
import com.see.cloud.core.common.utils.ResultUtils;
import com.see.cloud.provider.sys.model.SysUser;
import com.see.cloud.provider.sys.service.ISysUser;
import com.see.cloud.web.facade.sys.vo.SysUserVO;

@RestController
@RequestMapping("/sysUse")
public class SysUserController {
	@Autowired
	private ISysUser sysUserImpl;

	@GetMapping("/getUserByid/{id}")
	public ResultBody getUserByid(@PathVariable Integer id) {
		SysUser sysUser = sysUserImpl.getByPrimaryKey(id);
		SysUserVO record = JSON.parseObject(JSON.toJSONString(sysUser), SysUserVO.class);

		return ResultUtils.success(record);
	}
}
