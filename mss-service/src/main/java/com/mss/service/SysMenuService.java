package com.mss.service;

import java.util.List;

import com.mss.model.SysMenu;

public interface SysMenuService {
	/**
	 * 查询系统菜单数
	 * 
	 * @return
	 */
	public Integer selectMenuCount();
	
	/**
	 * 查询所有系统菜单
	 * 
	 * @throws Exception
	 */
	public List<SysMenu> findAllMenus() throws Exception;

}
