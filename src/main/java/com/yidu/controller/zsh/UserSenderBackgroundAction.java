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
 * 描述：用户地址表（寄件）Action层
 * 
 * @author zhoushihao
 * @date2019年1月4日下午4:17:35
 */
@Controller
public class UserSenderBackgroundAction {

	@Autowired
	// 业务层
	private UserSenderBackgroundService_zsh UserSenderBackgroundService_zsh;

	/**
	 * 
	 * 功能：查询所有
	 * 
	 * @return
	 */
	@RequestMapping("selectUserSenderAllpage.action")
	public @ResponseBody Map<String, Object> selectUserSenderAllpage(String page, String limit, String id,
			String select) {
		// 调用业务层的方法
		return UserSenderBackgroundService_zsh.selectUserSenderAllpage(page, limit, id, select);
	}

	/**
	 * 
	 * 功能：新增
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("insertUserSender.action")
	public @ResponseBody String insertUserSender(@ModelAttribute userSender_zsh userSender_zsh) {
		// 调用业务层的方法
		UserSenderBackgroundService_zsh.insertUserSender(userSender_zsh);
		return "ok";
	}

	/**
	 * 
	 * 功能：删除
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("deleteUserSender.action")
	public @ResponseBody String deleteUserSender(@ModelAttribute userSender_zsh userSender_zsh) {
		// 调用业务层的方法
		UserSenderBackgroundService_zsh.deleteUserSender(userSender_zsh);
		return "ok";
	}

	/**
	 * 
	 * 功能：修改
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("updateUserSender.action")
	public @ResponseBody String updateUserSender(@ModelAttribute userSender_zsh userSender_zsh) {
		// 调用业务层的方法
		UserSenderBackgroundService_zsh.updateUserSender(userSender_zsh);
		return "ok";
	}
}
