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
 * 描述：用户地址表（收件）Action层
 * 
 * @author zhoushihao
 * @date2019年1月4日下午4:17:31
 */
@Controller
public class AddressBackgroundAcion {

	@Autowired
	// 业务层
	private AddressBackgroundSirvice_zsh AddressBackgroundSirvice_zsh;

	/**
	 * 
	 * 功能：查询所有
	 * 
	 * @return
	 */
	@RequestMapping("selectorderInforMation_gsp_zshAllpage.action")
	public @ResponseBody Map<String, Object> selectorderInforMation_gsp_zshAllpage(String page, String limit, String id,
			String select) {
		// 调用业务层的方法
		return AddressBackgroundSirvice_zsh.selectorderInforMation_gsp_zshAllpage(page, limit, id, select);
	}

	/**
	 * 
	 * 功能：新增
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("insertorderInforMation_gsp_zsh.action")
	public @ResponseBody String insertorderInforMation_gsp_zsh(@ModelAttribute address_lql_zsh address_lql_zsh) {
		// 调用业务层的方法
		AddressBackgroundSirvice_zsh.insertorderInforMation_gsp_zsh(address_lql_zsh);
		return "ok";
	}

	/**
	 * 
	 * 功能：删除
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("deleteorderInforMation_gsp_zsh.action")
	public @ResponseBody String deleteorderInforMation_gsp_zsh(String recipientId) {
		// 调用业务层的方法
		AddressBackgroundSirvice_zsh.deleteorderInforMation_gsp_zsh(recipientId);
		return "ok";
	}

	/**
	 * 
	 * 功能：修改
	 * 
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("updateorderInforMation_gsp_zsh.action")
	public @ResponseBody String updateorderInforMation_gsp_zsh(@ModelAttribute address_lql_zsh address_lql_zsh) {
		// 调用业务层的方法
		AddressBackgroundSirvice_zsh.updateorderInforMation_gsp_zsh(address_lql_zsh);
		return "ok";
	}
}
