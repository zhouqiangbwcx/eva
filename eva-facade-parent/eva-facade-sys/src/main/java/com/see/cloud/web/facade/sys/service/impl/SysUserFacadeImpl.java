package com.see.cloud.web.facade.sys.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.see.cloud.core.common.constant.ItemConstant;
import com.see.cloud.core.common.entitys.ResultBody;
import com.see.cloud.core.common.utils.ResultUtils;
import com.see.cloud.web.facade.sys.service.SysUserFacade;
import com.see.cloud.web.facade.sys.vo.SysUserVO;

@Component
public class SysUserFacadeImpl implements SysUserFacade {
	private Logger logger = Logger.getLogger(SysUserFacadeImpl.class);
	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "getUserByidFallback")
	public SysUserVO getUserByid(int id) {
		ResultBody resultBody = this.restTemplate.getForObject(
				"http://" + ItemConstant.EVA_PROVIDER_SYS + "/sysUse/getUserByid/" + id, ResultBody.class);
		logger.info(resultBody.getData());
		String data = ResultUtils.noSuccessThrow(resultBody);
		SysUserVO vo = JSONObject.parseObject(data, SysUserVO.class);
		return vo;
	}

	public SysUserVO getUserByidFallback(int id) {
		logger.error("搞毛线啊啊  ");
		return null;
	}

}
