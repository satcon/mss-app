package com.jd.mss.controller;

import java.io.IOException;
import java.lang.management.MemoryUsage;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.mss.common.BaseController;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

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
	
	
	@RequestMapping("/checkJvmMemory")
	public void checkJVMMemory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Runtime runtime = Runtime.getRuntime();
			BigDecimal divisor = new BigDecimal(1024*1024);
			
			BigDecimal max = new BigDecimal(runtime.maxMemory());
			BigDecimal total = new BigDecimal(runtime.totalMemory());
			BigDecimal free = new BigDecimal(runtime.freeMemory());
			
			Map<String, Object> dto = new HashMap<String, Object>();
			dto.put("maxMemory", max.divide(divisor, 2, BigDecimal.ROUND_HALF_UP).toString());
			dto.put("totalMemory", total.divide(divisor, 2, BigDecimal.ROUND_HALF_UP).toString());
			dto.put("freeMemory", free.divide(divisor, 2, BigDecimal.ROUND_HALF_UP).toString());
			
			logger.info("Max Memory : {}", runtime.maxMemory());
			logger.info("Total Memory : {}", runtime.totalMemory());
			logger.info("Used  Memory : {}", runtime.totalMemory() - runtime.freeMemory());
			
			logger.debug(JSON.toJSONString(dto));
			writeJson(response, dto);
			
		} catch (Exception e) {
			logger.error("->异常： {}", e);
			throw e;
		}
		
	}
	
	@RequestMapping("/error/notFound")
	public String notFound(HttpServletRequest request) {
		logger.info("【404页面】:" + request.getRequestURI());
		
		return "error/404";
	}
}
