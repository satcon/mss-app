package com.jd.mss.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mss.common.BaseController;
import com.mss.model.SysMenu;
import com.mss.service.SysMenuService;

@Controller
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController{
	
	private SysMenuService sysMenuService;
	
	
	@RequestMapping("findTreeMenus")
	public void findTreeMenus(HttpServletResponse response) throws Exception {
		List<SysMenu> list = sysMenuService.findAllMenus();
		writeJson(response, list);
	}

	public SysMenuService getSysMenuService() {
		return sysMenuService;
	}

	@Resource
	public void setSysMenuService(SysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}
}
