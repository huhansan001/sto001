package com.yidu.service.zsh;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.zsh.address_lql_zsh;
import com.yidu.dao.zsh.addressBackground_zsh;

/**
 * 
 * 描述：用户地址表（收件）业务层
 * 
 * @author zhoushihao
 * @date2019年1月4日下午4:07:39
 */
@Service
public class AddressBackgroundSirvice_zsh {

	@Autowired
	private addressBackground_zsh addressBackground_zsh;

	/**
	 * 
	 * 功能：查询所有（分页）
	 * 
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectorderInforMation_gsp_zshAllpage(String page, String row, String id,
			String select) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 转成json格式
		map.put("code", 0);
		map.put("msg", "");
		// 强转成int类型
		int pages = Integer.parseInt(page);
		int rows = Integer.parseInt(row);

		map.put("count", addressBackground_zsh.selectorderInforMation_gsp_zshAll().size());
		// 调用dao层分页的方法
		map.put("data", addressBackground_zsh.selectorderInforMation_gsp_zshAllpage((pages - 1) * rows, rows));

		return map;
	}

	/**
	 * 
	 * 功能：新增
	 * 
	 * @param addressBackground_zsh
	 */
	public void insertorderInforMation_gsp_zsh(address_lql_zsh address_lql_zsh) {
		addressBackground_zsh.insertorderInforMation_gsp_zsh(address_lql_zsh);
	}

	/**
	 * 
	 * 功能：删除
	 * 
	 * @param addressBackground_zsh
	 */
	public void deleteorderInforMation_gsp_zsh(String recipientId) {
		addressBackground_zsh.deleteorderInforMation_gsp_zsh(recipientId);
	}

	/**
	 * 
	 * 功能：修改
	 * 
	 * @param addressBackground_zsh
	 */
	public void updateorderInforMation_gsp_zsh(address_lql_zsh address_lql_zsh) {
		addressBackground_zsh.updateorderInforMation_gsp_zsh(address_lql_zsh);
	}
}
