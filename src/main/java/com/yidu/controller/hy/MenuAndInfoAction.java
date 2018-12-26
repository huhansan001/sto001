package com.yidu.controller.hy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hy.Menu;
import com.yidu.bean.hy.Menus;
import com.yidu.service.hy.MenuAndInfoService;
/**
 * ������Ա������Ȩ�޿��Ʋ� 
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��14�� ����6:59:47 
 *
 */
@Controller
public class MenuAndInfoAction {

	@Autowired
	private MenuAndInfoService menuAndInfoService;
	
	/**
	   * ���ܣ���ѯ���в˵�����(������ҳ��ѯ)
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("selectMenuAll.action")
	public @ResponseBody Map<String, Object> selectMenuAll(int page,int row){
		return menuAndInfoService.selectMenuAll(page, row);
	}
	/**
	 * ���ܣ�����ְλid��ѯ����(��ȫ��Ȩ��)
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("selectMenuIdByPosiId.action")
	public @ResponseBody List<Map<String, Object>> selectMenuIdByPosiId(int posiId){
		return menuAndInfoService.selectMenuIdByPosiId(posiId);
	}
	/**
	 * ���ܣ�����ְλid��ѯ����(��ȫ��Ȩ��)
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("selectMenuIdAll.action")
	public @ResponseBody List<Map<String, Object>> selectMenuIdAll(int posiId){
		return menuAndInfoService.selectMenuIdAll(posiId);
	}
	/**
	 * ���ܣ�����ְλid�Ͳ˵�idɾ���˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("deleteMenuinfoByPidAndMid.action")
	public @ResponseBody String deleteMenuinfoByPidAndMid(@RequestParam(value="array[]")String [] array,int posiId) {
		List<String> list= Arrays.asList(array);
		for (String i : list) {
			menuAndInfoService.deleteMenuinfoByPidAndMid(posiId,i);
		}
		return "ok";
	}
	/**
	   * ���ܣ�����ְλid����Ȩ��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("insertMenuinfoByPidAndMid.action")
	public @ResponseBody String insertMenuinfoByPidAndMid(int posiId,@RequestParam(value="addArray[]")String [] addArray) {
		List<String> list= Arrays.asList(addArray);
		for (String i : list) {
			menuAndInfoService.insertMenuinfoByPidAndMid(posiId,i);
		}
		return "ok";
	}
	/**
	   * ���ܣ�����id�޸Ĳ˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("updateMenuById.action")
	public void updateMenuById(Menus menus) {
		menuAndInfoService.updateMenuById(menus);
	}
	/**
	   * ���ܣ�����idɾ���˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("deleteMenuById.action")
	public void deleteMenuById(String menuId) {
		menuAndInfoService.deleteMenuById(menuId);
	}
	/**
	   * ���ܣ�����id����ɾ���˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("deleteMenuByIdBatch.action")
	public void deleteMenuByIdBatch(@RequestParam(value="menuId[]") String [] menuId) {
		List<String> list= Arrays.asList(menuId);
		for (String str : list) {
			menuAndInfoService.deleteMenuById(str);
		}
	}
	/**
	   * ���ܣ����ܲ˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("insertMneu.action")
	public @ResponseBody String insertMneu(Menu menu) {
		menuAndInfoService.insertMneu(menu);
		return "ok";
	}
}
