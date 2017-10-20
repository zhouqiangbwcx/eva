package com.see.cloud.web.mis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.see.cloud.web.facade.sys.service.SysUserFacade;
import com.see.cloud.web.facade.sys.vo.SysUserVO;

@Controller
public class TemplateController {
/*	@Autowired
	private RestTemplate restTemplate;*/
	@Autowired
	private SysUserFacade sysUserFacade;

	/**
	 * 
	 * 返回html模板.
	 * 
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {
		SysUserVO vo = sysUserFacade.getUserByid(1);
		map.put("hello", vo.toString());
		map.put("hellob", vo);
		return "/helloHtml";
	}

/*	@RequestMapping("/helloHtmlus")
	public String helloHtmlus(Map<String, Object> map) {
		SysUserVO u = this.restTemplate.getForObject("http://PROVIDER-SYS/sysUse/getUserByid/1", SysUserVO.class);
		map.put("hello", u);
		return "/helloHtml";
	}
*/
}
