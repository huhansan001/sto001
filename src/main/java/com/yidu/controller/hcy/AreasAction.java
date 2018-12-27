package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.Areas;
import com.yidu.service.hcy.AreasService;
/**
 * 
 * @Description: ʡ�����Ʋ�
 * @author: ������
 * @date 2018��12��19�� ����10:37:31
 * @version 1.0
 */
@Controller
public class AreasAction {
	@Autowired AreasService areasService;
	/**
	 * 
	 * @Explain:��ҳʡ
	 * @date 2018��12��17������11:04:54
	 * @return ʡ��ҳ����
	 */
	@RequestMapping("pageAreas.action")
	public @ResponseBody Map<String, Object> pageAreas(String page,String limit){
		return areasService.pageAreas(page,limit);
	}
	
	/**
	 * 
	 * @Explain:����ʡ
	 * @date 2018��12��17������11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insAreas.action")
	public @ResponseBody int insAreas(@ModelAttribute Areas areas){
		return areasService.insAreas(areas);
	}
	/**
	 * 
	 * @Explain:ɾ��ʡ
	 * @date 2018��12��17������11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delAreas.action")
	public @ResponseBody int delAreas(String areasId){
		return areasService.delAreas(areasId);
	}
	/**
	 * 
	 * @Explain:�޸�ʡ
	 * @date 2018��12��17������11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upAreas.action")
	public @ResponseBody int upAreas(@ModelAttribute Areas areas){
		return areasService.upAreas(areas);
	}
}
