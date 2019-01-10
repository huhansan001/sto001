package com.yidu.controller.zsh;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yidu.bean.zsh.userSender_zsh;
import com.yidu.service.zsh.UserSenderBackgroundService_zsh;

/**
 * 
 * �������û���ַ���ļ���Action��
 * 
 * @author zhoushihao
 * @date2019��1��4������4:17:35
 */
@Controller
public class UserSenderBackgroundAction {

	@Autowired
	// ҵ���
	private UserSenderBackgroundService_zsh UserSenderBackgroundService_zsh;

	/**
	 * 
	 * ���ܣ���ѯ����
	 * 
	 * @return
	 */
	@RequestMapping("selectUserSenderAllpage.action")
	public @ResponseBody Map<String, Object> selectUserSenderAllpage(String page, String limit, String id,
			String select) {
		// ����ҵ���ķ���
		return UserSenderBackgroundService_zsh.selectUserSenderAllpage(page, limit, id, select);
	}

	/**
	 * 
	 * ���ܣ�����
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("insertUserSender.action")
	public @ResponseBody String insertUserSender(@ModelAttribute userSender_zsh userSender_zsh) {
		// ����ҵ���ķ���
		UserSenderBackgroundService_zsh.insertUserSender(userSender_zsh);
		return "ok";
	}

	/**
	 * 
	 * ���ܣ�ɾ��
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("deleteUserSender.action")
	public @ResponseBody String deleteUserSender(@ModelAttribute userSender_zsh userSender_zsh) {
		// ����ҵ���ķ���
		UserSenderBackgroundService_zsh.deleteUserSender(userSender_zsh);
		return "ok";
	}

	/**
	 * 
	 * ���ܣ��޸�
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("updateUserSender.action")
	public @ResponseBody String updateUserSender(@ModelAttribute userSender_zsh userSender_zsh) {
		// ����ҵ���ķ���
		UserSenderBackgroundService_zsh.updateUserSender(userSender_zsh);
		return "ok";
	}
}
