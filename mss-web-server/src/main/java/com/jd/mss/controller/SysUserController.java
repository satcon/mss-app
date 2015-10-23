package com.jd.mss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mss.common.BaseController;

@Controller
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {
	
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
	
	@RequestMapping("viewMenus")
	public String viewUsers() throws Exception {
		logger.info("---【用户首页】");
		return "sysuser/index";
	}
	
}
