package com.yidu.service.hy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hy.Menu;
import com.yidu.bean.hy.Menus;
import com.yidu.dao.hy.MenuAndInfoMapper;
/**
 * 描述： 员工功能权限业务层
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月14日 下午7:00:39 
 *
 */
@Service
public class MenuAndInfoService {

	@Autowired
	private MenuAndInfoMapper menuAndInfoMapper;
	
	/**
	 * 功能：根据职位id查询功能
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public List<Map<String, Object>> selectMenuIdByPosiId(int posiId){
		List<Menu> menuList=menuAndInfoMapper.selectMenuIdByPosiId(posiId);
		List<Map<String, Object>> oneMenu = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> twoMenu = null;
		Map<String, Object> oneMap = null;
		Map<String, Object> twoMap = null;
		for (Menu menu : menuList) {
			if(menu.getPid().equals("root")) {
				oneMap = new HashMap<String, Object>();
				twoMenu = new ArrayList<Map<String, Object>>();
				oneMap.put("title", menu.getTitle());
				oneMap.put("value",menu.getMenuId());
				oneMap.put("data", twoMenu);
				oneMenu.add(oneMap);
			}else {
				twoMap = new HashMap<String, Object>();
				twoMap.put("title", menu.getTitle());
				twoMap.put("value", menu.getMenuId());
				twoMenu.add(twoMap);
			}
		}
		return oneMenu;
	}
	/**
	 * 功能：查询所有菜单
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public List<Map<String, Object>> selectMenuIdAll(int posiId){
		List<Menu> menuList=menuAndInfoMapper.selectMenuIdAll(posiId);
		List<Map<String, Object>> oneMenu = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> twoMenu = null;
		Map<String, Object> oneMap = null;
		Map<String, Object> twoMap = null;
		for (Menu menu : menuList) {
			if(menu.getPid().equals("root")) {
				oneMap = new HashMap<String, Object>();
				twoMenu = new ArrayList<Map<String, Object>>();
				oneMap.put("title", menu.getTitle());
				oneMap.put("value",menu.getMenuId());
				oneMap.put("data", twoMenu);
				oneMenu.add(oneMap);
			}else {
				twoMap = new HashMap<String, Object>();
				twoMap.put("title", menu.getTitle());
				twoMap.put("value", menu.getMenuId());
				twoMenu.add(twoMap);
			}
		}
		return oneMenu;
	}
	/**
	 * 功能：根据职位id和菜单id删除菜单分配
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void deleteMenuinfoByPidAndMid(int posiId,String menuId) {
		menuAndInfoMapper.deleteMenuinfoByPidAndMid(posiId,menuId);
	}
	/**
	   * 功能：根据职位id新增权限
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void insertMenuinfoByPidAndMid(int posiId,String menuId) {
		menuAndInfoMapper.insertMenuinfoByPidAndMid(posiId, menuId);
	}
	/**
	   * 功能：查询所有一级菜单
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public List<String> selectMenuIdByRoot(){
		return menuAndInfoMapper.selectMenuIdByRoot();
	}
	/**
	   * 功能：查询所有菜单功能
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public Map<String, Object> selectMenuAll(int page,int row){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",menuAndInfoMapper.selectMenuAll().size());
		map.put("data",menuAndInfoMapper.selectMenuAllPaging((page-1)*row, row));
		return map;
	}
	/**
	   * 功能：根据id修改菜单
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void updateMenuById(Menus menus) {
		menuAndInfoMapper.updateMenuById(menus);
	}
	/**
	   * 功能：根据id删除菜单
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void deleteMenuById(@Param("menuId") String menuId) {
		menuAndInfoMapper.deleteMenuById(menuId);
	};
	/**
	   * 功能：功能菜单新增
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void insertMneu(Menu menu) {
		menuAndInfoMapper.insertMneu(menu);
	}
}
