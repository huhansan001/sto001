package com.yidu.service.zsh;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.zsh.userSender_zsh;
import com.yidu.dao.zsh.userSenderBackground_zsh;

/**
 * 
 * �������û���ַ���ļ���ҵ���
 * 
 * @author zhoushihao
 * @date2019��1��4������4:07:29
 */
@Service
public class UserSenderBackgroundService_zsh {

	@Autowired
	private userSenderBackground_zsh userSenderBackground_zsh;

	/**
	 * 
	 * ���ܣ���ѯ���У���ҳ��
	 * 
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectUserSenderAllpage(String page, String row, String id, String select) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ת��json��ʽ
		map.put("code", 0);
		map.put("msg", "");
		// ǿת��int����
		int pages = Integer.parseInt(page);
		int rows = Integer.parseInt(row);
		map.put("count", userSenderBackground_zsh.selectUserSenderAll().size());
		// ����dao���ҳ�ķ���
		map.put("data", userSenderBackground_zsh.selectUserSenderAllpage((pages - 1) * rows, rows));
		return map;
	}

	/**
	 * 
	 * ���ܣ�����
	 * 
	 * @param userSenderBackground_zsh
	 */
	public void insertUserSender(userSender_zsh userSender_zsh) {
		userSenderBackground_zsh.insertUserSender(userSender_zsh);
	}

	/**
	 * 
	 * ���ܣ�ɾ��
	 * 
	 * @param userSenderBackground_zsh
	 */
	public void deleteUserSender(userSender_zsh userSender_zsh) {
		userSenderBackground_zsh.deleteUserSender(userSender_zsh);
	}

	/**
	 * 
	 * ���ܣ��޸�
	 * 
	 * @param userSenderBackground_zsh
	 */
	public void updateUserSender(userSender_zsh userSender_zsh) {
		userSenderBackground_zsh.updateUserSender(userSender_zsh);
	}
}
