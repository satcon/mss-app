package com.jd.mss.controller;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSON;
import com.mss.model.SysMenu;
import com.mss.service.SysMenuService;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private SysMenuService sysMenuService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		logger.info("index首页");
		try {
			Integer count = sysMenuService.selectMenuCount();
			List<SysMenu> list = sysMenuService.findAllMenus();
			
			logger.info("【菜单】：{}", JSON.toJSONString(list));
			logger.info("【菜单数量】：{}", count);
			
		} catch (Exception e) {
			logger.error("【异常】：" ,e);
		}
		
		
		return "layout/layout";
	}

	public SysMenuService getSysMenuService() {
		return sysMenuService;
	}

	@Resource
	public void setSysMenuService(SysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}
}
