package com.yidu.controller.xwc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.xwc.UserAddress_xwc;
import com.yidu.service.xwc.UserAddressService_xwc;


/**
 * 
 *�������û���ַ���Ŀ��Ʋ�
 * @author ������
 *@date2018��12��24������9:14:39
 */
@Controller
public class UserAddressAction_xwc {

	@Autowired
	private UserAddressService_xwc userAddressService_xwc;
	
	/**
	 * 
	 *���ܣ���ѯ����
	 * @return
	 */
	@RequestMapping("selectUserAddressAll.action")
	public @ResponseBody Map<String, Object> selectUserAddressAll(String page,String limit){
		return userAddressService_xwc.selectUserAddressAll(page,limit);
		
	}
	/**
	 * 
	 *���ܣ�����
	 * @param userAddress_xwc
	 * @return
	 */
	@RequestMapping("insertUserAddress.action")
	public @ResponseBody String insertUserAddress(@ModelAttribute UserAddress_xwc userAddress_xwc ) {
		userAddressService_xwc.insertUserAddress(userAddress_xwc);
		return "ok";
	}
	
	/**
	 * 
	 *���ܣ�ɾ��
	 * @param userAddress_xwc
	 * @return
	 */
	@RequestMapping("deleteUserAddress.action")
	public @ResponseBody String deleteUserAddress(@ModelAttribute UserAddress_xwc userAddress_xwc ) {
		userAddressService_xwc.deleteUserAddress(userAddress_xwc);
		return "ok";
	}
	/**
	 * 
	 *���ܣ��޸�
	 * @param userAddress_xwc
	 * @return
	 */
	@RequestMapping("updateUserAddress.action")
	public @ResponseBody String updateUserAddress(@ModelAttribute UserAddress_xwc userAddress_xwc ) {
		userAddressService_xwc.updateUserAddress(userAddress_xwc);
		return "ok";
	}
}
