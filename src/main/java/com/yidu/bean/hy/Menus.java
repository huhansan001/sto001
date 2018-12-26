package com.yidu.bean.hy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Menus implements Serializable{
	@Override
	public String toString() {
		return "Menus [menuId=" + menuId + ", title=" + title + ", pid=" + pid + ", url=" + url + "]";
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	private static final long serialVersionUID = 1L;
	private String menuId;//菜单id
	private String title;//标题
	private String pid;//一级菜单id
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private String url;//地址
}
