package com.jd.mss.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		logger.info("index首页");
		try {
			
		} catch (Exception e) {
			logger.error("【异常】：" ,e);
		}
		
		
		return "layout/layout";
	}
	
	
	@RequestMapping("/error/notFound")
	public String notFound(HttpServletRequest request) {
		logger.info("【404页面】:" + request.getRequestURI());
		
		return "error/404";
	}
}
