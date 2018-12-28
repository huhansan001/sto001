package com.yidu.service.xwc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.xwc.UserAddress_xwc;
import com.yidu.dao.xwc.UserAddressMapper_xwc;

@Service
public class UserAddressService_xwc {

	@Autowired
	private UserAddressMapper_xwc userAddressMapper_xwc;

	/**
	 * 
	 *功能：查询（分页）
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectUserAddressAll(String page,String row){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count", userAddressMapper_xwc.selectUserAddressAll().size());
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(row);
		map.put("data", userAddressMapper_xwc.selectUserAddresspage((pages-1)*rows,rows));
		return map;
	}
	/**
	 * 
	 *功能：新增
	 * @param userAddress_xwc
	 */
	public void insertUserAddress(UserAddress_xwc userAddress_xwc) {
		userAddressMapper_xwc.insertUserAddress(userAddress_xwc);
	}
	/**
	 * 
	 *功能：删除
	 * @param userAddress_xwc
	 */
	public void deleteUserAddress(UserAddress_xwc userAddress_xwc) {
		userAddressMapper_xwc.deleteUserAddress(userAddress_xwc);
	}/**
	 * 
	 *功能：修改
	 * @param userAddress_xwc
	 */
	public void updateUserAddress(UserAddress_xwc userAddress_xwc) {
		userAddressMapper_xwc.updateUserAddress(userAddress_xwc);
	}
	
}
