package com.mss.common;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	public void writeJson(HttpServletResponse response,Object object) throws IOException {
		//String json = gson.toJson(object);
		// 使用SerializerFeature.WriteDateUseDateFormat特性来序列化日期格式的类型为yyyy-MM-dd hh24:mi:ss
		// 使用SerializerFeature.DisableCircularReferenceDetect特性关闭引用检测和生成
		String json = JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
		logger.info("转换后的JSON字符串：" + json);
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
}
