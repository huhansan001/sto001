package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.Province;
import com.yidu.service.hcy.ProvinceService;
/**
 * 
 * @Description: ���ؿ��Ʋ�
 * @author: ������
 * @date 2018��12��19�� ����10:38:38
 * @version 1.0
 */
@Controller
public class ProvincAction {
	@Autowired ProvinceService provinceService;
	/**
	 * 
	 * @Explain:��ҳ��
	 * @date 2018��12��17������11:04:54
	 * @return ����ҳ����
	 */
	@RequestMapping("pageProvince.action")
	public @ResponseBody Map<String, Object> pageProvince(String page,String limit){
		return provinceService.pageProvince(page,limit);
	}
	
	/**
	 * 
	 * @Explain:������
	 * @date 2018��12��17������11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insProvince.action")
	public @ResponseBody int insProvince(@ModelAttribute Province Province){
		return provinceService.insProvince(Province);
	}
	/**
	 * 
	 * @Explain:ɾ����
	 * @date 2018��12��17������11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delProvince.action")
	public @ResponseBody int delProvince(String proId){
		return provinceService.delProvince(proId);
	}
	/**
	 * 
	 * @Explain:�޸���
	 * @date 2018��12��17������11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upProvince.action")
	public @ResponseBody int upProvince(@ModelAttribute Province Province){
		return provinceService.upProvince(Province);
	}
}
