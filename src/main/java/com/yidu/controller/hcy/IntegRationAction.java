package com.yidu.controller.hcy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @Description: ��̨ҵ����Ʋ�
 * @author: ������
 * @date 2018��12��22�� ����11:23:46
 * @version 1.0
 */
@Controller
public class IntegRationAction {
	
	@RequestMapping("IntegRation.action")
	public @ResponseBody String IntegRation() {
		//Integer.parseInt(s)
		return "����";
	}
}
