package com.mss.model;

import java.io.Serializable;

public class SysMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String parentId;

	private String state;

	private String menuName;

	private String menuURL;

	private String menuLevel;

	private String iconCls;

	private Long sortOrder;
	
	public String getId() {
		return id;
	}

	public String getIconCls() {
		return iconCls;
	}

	public String getMenuLevel() {
		return menuLevel;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public Long getSortOrder() {
		return sortOrder;
	}

	public String getParentId() {
		return parentId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}