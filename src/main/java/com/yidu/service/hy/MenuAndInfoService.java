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
 * ������ Ա������Ȩ��ҵ���
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��14�� ����7:00:39 
 *
 */
@Service
public class MenuAndInfoService {

	@Autowired
	private MenuAndInfoMapper menuAndInfoMapper;
	
	/**
	 * ���ܣ�����ְλid��ѯ����
	 * @param ��
	 * @return ��
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
	 * ���ܣ���ѯ���в˵�
	 * @param ��
	 * @return ��
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
	 * ���ܣ�����ְλid�Ͳ˵�idɾ���˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void deleteMenuinfoByPidAndMid(int posiId,String menuId) {
		menuAndInfoMapper.deleteMenuinfoByPidAndMid(posiId,menuId);
	}
	/**
	   * ���ܣ�����ְλid����Ȩ��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void insertMenuinfoByPidAndMid(int posiId,String menuId) {
		menuAndInfoMapper.insertMenuinfoByPidAndMid(posiId, menuId);
	}
	/**
	   * ���ܣ���ѯ����һ���˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public List<String> selectMenuIdByRoot(){
		return menuAndInfoMapper.selectMenuIdByRoot();
	}
	/**
	   * ���ܣ���ѯ���в˵�����
	 * @param ��
	 * @return ��
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
	   * ���ܣ�����id�޸Ĳ˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void updateMenuById(Menus menus) {
		menuAndInfoMapper.updateMenuById(menus);
	}
	/**
	   * ���ܣ�����idɾ���˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void deleteMenuById(@Param("menuId") String menuId) {
		menuAndInfoMapper.deleteMenuById(menuId);
	};
	/**
	   * ���ܣ����ܲ˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void insertMneu(Menu menu) {
		menuAndInfoMapper.insertMneu(menu);
	}
}
