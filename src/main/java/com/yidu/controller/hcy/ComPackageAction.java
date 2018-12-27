package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.ComPackage;
import com.yidu.service.hcy.ComPackageService;
/**
 * 
 * @Description: �ϰ����Ʋ�
 * @author: ������
 * @date 2018��12��20�� ����1:38:02
 * @version 1.0
 */
@Controller
public class ComPackageAction {
	@Autowired 
	private ComPackageService comPackageService;
	/**
	 * 
	 * @Explain:��ҳ�ϰ�
	 * @date 2018��12��17������11:04:54
	 * @return �ϰ���ҳ����
	 */
	@RequestMapping("pageComPackage.action")
	public @ResponseBody Map<String, Object> pageComPackage(String page,String limit){
		return comPackageService.pageComPackage(page,limit);
	}
	
	/**
	 * 
	 * @Explain:�����ϰ�
	 * @date 2018��12��17������11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insComPackage.action")
	public @ResponseBody int insComPackage(ComPackage comPackage){
		return comPackageService.insComPackage(comPackage);
	}
	/**
	 * 
	 * @Explain:ɾ���ϰ�
	 * @date 2018��12��17������11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delComPackage.action")
	public @ResponseBody int delComPackage(String shuttleId){
		return comPackageService.delComPackage(shuttleId);
	}
	/**
	 * 
	 * @Explain:�޸ĺϰ�
	 * @date 2018��12��17������11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upComPackage.action")
	public @ResponseBody int upComPackage(ComPackage comPackage){
		return comPackageService.upComPackage(comPackage);
	}
}
