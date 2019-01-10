package com.yidu.service.zsh;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.zsh.userSender_zsh;
import com.yidu.dao.zsh.userSenderBackground_zsh;

/**
 * 
 * 描述：用户地址表（寄件）业务层
 * 
 * @author zhoushihao
 * @date2019年1月4日下午4:07:29
 */
@Service
public class UserSenderBackgroundService_zsh {

	@Autowired
	private userSenderBackground_zsh userSenderBackground_zsh;

	/**
	 * 
	 * 功能：查询所有（分页）
	 * 
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectUserSenderAllpage(String page, String row, String id, String select) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 转成json格式
		map.put("code", 0);
		map.put("msg", "");
		// 强转成int类型
		int pages = Integer.parseInt(page);
		int rows = Integer.parseInt(row);
		map.put("count", userSenderBackground_zsh.selectUserSenderAll().size());
		// 调用dao层分页的方法
		map.put("data", userSenderBackground_zsh.selectUserSenderAllpage((pages - 1) * rows, rows));
		return map;
	}

	/**
	 * 
	 * 功能：新增
	 * 
	 * @param userSenderBackground_zsh
	 */
	public void insertUserSender(userSender_zsh userSender_zsh) {
		userSenderBackground_zsh.insertUserSender(userSender_zsh);
	}

	/**
	 * 
	 * 功能：删除
	 * 
	 * @param userSenderBackground_zsh
	 */
	public void deleteUserSender(userSender_zsh userSender_zsh) {
		userSenderBackground_zsh.deleteUserSender(userSender_zsh);
	}

	/**
	 * 
	 * 功能：修改
	 * 
	 * @param userSenderBackground_zsh
	 */
	public void updateUserSender(userSender_zsh userSender_zsh) {
		userSenderBackground_zsh.updateUserSender(userSender_zsh);
	}
}
