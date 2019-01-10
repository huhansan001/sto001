package com.yidu.controller.zsh;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yidu.bean.zsh.address_lql_zsh;
import com.yidu.service.zsh.AddressBackgroundSirvice_zsh;

/**
 * 
 * �������û���ַ���ռ���Action��
 * 
 * @author zhoushihao
 * @date2019��1��4������4:17:31
 */
@Controller
public class AddressBackgroundAcion {

	@Autowired
	// ҵ���
	private AddressBackgroundSirvice_zsh AddressBackgroundSirvice_zsh;

	/**
	 * 
	 * ���ܣ���ѯ����
	 * 
	 * @return
	 */
	@RequestMapping("selectorderInforMation_gsp_zshAllpage.action")
	public @ResponseBody Map<String, Object> selectorderInforMation_gsp_zshAllpage(String page, String limit, String id,
			String select) {
		// ����ҵ���ķ���
		return AddressBackgroundSirvice_zsh.selectorderInforMation_gsp_zshAllpage(page, limit, id, select);
	}

	/**
	 * 
	 * ���ܣ�����
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("insertorderInforMation_gsp_zsh.action")
	public @ResponseBody String insertorderInforMation_gsp_zsh(@ModelAttribute address_lql_zsh address_lql_zsh) {
		// ����ҵ���ķ���
		AddressBackgroundSirvice_zsh.insertorderInforMation_gsp_zsh(address_lql_zsh);
		return "ok";
	}

	/**
	 * 
	 * ���ܣ�ɾ��
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("deleteorderInforMation_gsp_zsh.action")
	public @ResponseBody String deleteorderInforMation_gsp_zsh(String recipientId) {
		// ����ҵ���ķ���
		AddressBackgroundSirvice_zsh.deleteorderInforMation_gsp_zsh(recipientId);
		return "ok";
	}

	/**
	 * 
	 * ���ܣ��޸�
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("updateorderInforMation_gsp_zsh.action")
	public @ResponseBody String updateorderInforMation_gsp_zsh(@ModelAttribute address_lql_zsh address_lql_zsh) {
		// ����ҵ���ķ���
		AddressBackgroundSirvice_zsh.updateorderInforMation_gsp_zsh(address_lql_zsh);
		return "ok";
	}
}
