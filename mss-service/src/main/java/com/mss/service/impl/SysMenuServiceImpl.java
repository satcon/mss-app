package com.mss.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mss.dao.SysMenuDao;
import com.mss.model.SysMenu;
import com.mss.service.SysMenuService;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	
	@Autowired
	private SysMenuDao sysMenuDao;
	
	public Integer selectMenuCount() {
		return sysMenuDao.findMenuCount();
	}
	
	public List<SysMenu> findAllMenus() throws Exception {
		return sysMenuDao.findAllMenus();
	}
}
