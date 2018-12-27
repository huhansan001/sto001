package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.City;
import com.yidu.service.hcy.CityService;
/**
 * 
 * @Description: �м����Ʋ�
 * @author: ������
 * @date 2018��12��19�� ����10:37:53
 * @version 1.0
 */
@Controller
public class CityAction {
	@Autowired CityService cityService;
	/**
	 * 
	 * @Explain:��ҳ��
	 * @date 2018��12��17������11:04:54
	 * @return �з�ҳ����
	 */
	@RequestMapping("pageCity.action")
	public @ResponseBody Map<String, Object> pageProvince(String page,String limit){
		return cityService.pageCity(page,limit);
	}
	
	/**
	 * 
	 * @Explain:������
	 * @date 2018��12��17������11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insCity.action")
	public @ResponseBody int insCity(@ModelAttribute City city){
		return cityService.insCity(city);
	}
	/**
	 * 
	 * @Explain:ɾ����
	 * @date 2018��12��17������11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delCity.action")
	public @ResponseBody int delProvince(String cityId){
		return cityService.delCity(cityId);
	}
	/**
	 * 
	 * @Explain:�޸���
	 * @date 2018��12��17������11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upCity.action")
	public @ResponseBody int upProvince(@ModelAttribute City city){
		return cityService.upCity(city);
	}
}
