package com.yidu.service.zsh;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.zsh.address_lql_zsh;
import com.yidu.dao.zsh.addressBackground_zsh;

/**
 * 
 * �������û���ַ���ռ���ҵ���
 * 
 * @author zhoushihao
 * @date2019��1��4������4:07:39
 */
@Service
public class AddressBackgroundSirvice_zsh {

	@Autowired
	private addressBackground_zsh addressBackground_zsh;

	/**
	 * 
	 * ���ܣ���ѯ���У���ҳ��
	 * 
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectorderInforMation_gsp_zshAllpage(String page, String row, String id,
			String select) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ת��json��ʽ
		map.put("code", 0);
		map.put("msg", "");
		// ǿת��int����
		int pages = Integer.parseInt(page);
		int rows = Integer.parseInt(row);

		map.put("count", addressBackground_zsh.selectorderInforMation_gsp_zshAll().size());
		// ����dao���ҳ�ķ���
		map.put("data", addressBackground_zsh.selectorderInforMation_gsp_zshAllpage((pages - 1) * rows, rows));

		return map;
	}

	/**
	 * 
	 * ���ܣ�����
	 * 
	 * @param addressBackground_zsh
	 */
	public void insertorderInforMation_gsp_zsh(address_lql_zsh address_lql_zsh) {
		addressBackground_zsh.insertorderInforMation_gsp_zsh(address_lql_zsh);
	}

	/**
	 * 
	 * ���ܣ�ɾ��
	 * 
	 * @param addressBackground_zsh
	 */
	public void deleteorderInforMation_gsp_zsh(String recipientId) {
		addressBackground_zsh.deleteorderInforMation_gsp_zsh(recipientId);
	}

	/**
	 * 
	 * ���ܣ��޸�
	 * 
	 * @param addressBackground_zsh
	 */
	public void updateorderInforMation_gsp_zsh(address_lql_zsh address_lql_zsh) {
		addressBackground_zsh.updateorderInforMation_gsp_zsh(address_lql_zsh);
	}
}
