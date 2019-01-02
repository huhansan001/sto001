package com.yidu.dao.xwc;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.xwc.UserAddress_xwc;


/**
 * 
 *�������û���ַ���ĵ���ɾ�Ĳ�
 * @author ������
 *@date2018��12��24������9:05:28
 */
@Repository
public interface UserAddressMapper_xwc {
	/**
	 * 
	 *���ܣ���ѯ����
	 * @return
	 */
	@Select("select * from userAddress_xwc")
	public List<UserAddress_xwc> selectUserAddressAll();
	
	/**
	 * 
	 *���ܣ���ҳ
	 * @param page
	 * @param row
	 * @return
	 */
	@Select("select * from userAddress_xwc limit #{page},#{row}")
	public List<UserAddress_xwc> selectUserAddresspage(@Param("page")int page,@Param("row")int row);
	/**
	 * 
	 *���ܣ�����
	 * @param userAddress_xwc
	 */
	@Insert("INSERT INTO userAddress_xwc (userName,userPhone,landlineNumbers,fullAddress,category,sendName)VALUES(#{userName},#{userPhone},#{landlineNumbers},#{fullAddress},#{category},#{sendName})")
	public void insertUserAddress(UserAddress_xwc userAddress_xwc);
	/**
	 * 
	 *���ܣ�ɾ��
	 * @param userAddress_xwc
	 */
	@Delete("delete from userAddress_xwc where userAddressId=#{userAddressId}")
	public void deleteUserAddress(UserAddress_xwc userAddress_xwc);
	
	@Update("update userAddress_xwc set userName=#{userName},userPhone=#{userPhone},landlineNumbers=#{landlineNumbers},fullAddress=#{fullAddress},category=#{category},sendName=#{sendName} where userAddressId=#{userAddressId}")
	public void updateUserAddress(UserAddress_xwc userAddress_xwc);
}
