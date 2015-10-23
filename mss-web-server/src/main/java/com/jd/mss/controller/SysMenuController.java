package com.jd.mss.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mss.common.BaseController;
import com.mss.model.SysMenu;
import com.mss.service.SysMenuService;

@Controller
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	@Autowired
	private SysMenuService sysMenuService;
	
	
	@RequestMapping("findTreeMenus")
	public void findTreeMenus(HttpServletResponse response) throws Exception {
		List<SysMenu> list = sysMenuService.findAllMenus();
		writeJson(response, list);
	}
	
	@RequestMapping("viewMenus")
	public String viewMenus() throws Exception {
		logger.info("---【系统菜单】");
		return "sysmenu/index";
	}
}
