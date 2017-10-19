package com.see.cloud.consumer.mis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.see.cloud.facade.sys.vo.SysUserVO;

@Controller
public class TemplateController {
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 
	 * 返回html模板.
	 * 
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {

		map.put("hello", "from TemplateController.helloHtml");
		return "/helloHtml";
	}

	@RequestMapping("/helloHtmlus")
	public String helloHtmlus(Map<String, Object> map) {
		SysUserVO u = this.restTemplate.getForObject("http://PROVIDER-SYS/sysUse/getUserByid/1", SysUserVO.class);
		map.put("hello", u);
		return "/helloHtml";
	}

}
