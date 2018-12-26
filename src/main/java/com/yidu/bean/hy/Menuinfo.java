package com.yidu.bean.hy;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 描述： 员工功能菜单分配实体类
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月7日 上午11:24:54 
 *
 */
@Component
public class Menuinfo implements Serializable{
	/** 
	 * @Fields serialVersionUID ：TODO
	 */
	private static final long serialVersionUID = 1L;
	private int menuInfoId;//菜单分配id
	private int positionId;//角色id
	private String menuId;//菜单id
	@Override
	public String toString() {
		return "Menuinfo [menuInfoId=" + menuInfoId + ", positionId=" + positionId + ", menuId=" + menuId + "]";
	}
	public int getMenuInfoId() {
		return menuInfoId;
	}
	public void setMenuInfoId(int menuInfoId) {
		this.menuInfoId = menuInfoId;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
