package com.see.cloud.web.facade.sys.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.see.cloud.web.facade.sys.vo.SysUserVO;

@FeignClient(value = "EVA-PROVIDER-SYS")
public interface SysUserFacade {
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	SysUserVO getUserByid(@RequestParam("id") final int id);
}
