package com.mss.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mss.dao.SysMenuDao;
import com.mss.model.SysMenu;
import com.mss.service.SysMenuService;
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	
	private SysMenuDao sysMenuDao;
	
	public Integer selectMenuCount() {
		return sysMenuDao.findMenuCount();
	}
	
	public List<SysMenu> findAllMenus() throws Exception {
		return sysMenuDao.findAllMenus();
	}

	public SysMenuDao getSysMenuDao() {
		return sysMenuDao;
	}

	@Resource
	public void setSysMenuDao(SysMenuDao sysMenuDao) {
		this.sysMenuDao = sysMenuDao;
	}
	
	

}
