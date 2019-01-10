package com.yidu.dao.zsh;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.yidu.bean.zsh.address_lql_zsh;

/**
 * 
 * 描述：用户下单信息（收件人）后台
 * 
 * @author zhoushihao
 * @date2019年1月4日上午10:29:51
 */
@Repository
public interface addressBackground_zsh {
	/**
	 * 
	 * 功能：分页
	 * 
	 * @param page
	 * @param row
	 * @return
	 */
	@Select("select * from address_lql limit #{page},#{row}")
	public List<address_lql_zsh> selectorderInforMation_gsp_zshAllpage(@Param("page") int page, @Param("row") int row);


	/**
	 * 
	 * function:查询所有收件人表信息 name :Quiet
	 * 
	 * @return
	 * @date 2018年12月24日下午6:46:04
	 */
	@Select("SELECT * FROM address_lql ")
	public List<address_lql_zsh> selectorderInforMation_gsp_zshAll();

	/**
	 * 
	 * function:新增收件人表信息 name :Quiet
	 * 
	 * @param userInfoPhone
	 * @return
	 * @date 2018年12月24日下午7:52:34
	 */
	@Insert("INSERT INTO address_lql(recipName,recipMobile,recipPhone,recipAddress,recipDetailed,recipType,senderName,userInfoPhone) VALUES(#{recipName},#{recipMobile},#{recipPhone},#{recipAddress},#{recipDetailed},#{recipType},#{senderName},#{userInfoPhone})")
	public void insertorderInforMation_gsp_zsh(address_lql_zsh address_lql_zsh);

	/**
	 * 
	 * function:删除收件人表信息 name :Quiet
	 * 
	 * @param recipientId
	 * @return
	 * @date 2018年12月25日上午9:26:03
	 */
	@Delete("DELETE FROM address_lql WHERE recipientId=#{recipientId}")
	public void deleteorderInforMation_gsp_zsh(String recipientId);

	/**
	 * 
	 * function:修改收件人表信息 name :Quiet
	 * 
	 * @param address_lql_zsh
	 * @return
	 * @date 2018年12月25日上午10:22:29
	 */
	@Update("UPDATE address_lql SET recipName=#{recipName},recipMobile=#{recipMobile},recipPhone=#{recipPhone},recipAddress=#{recipAddress},recipDetailed=#{recipDetailed},recipType=#{recipType},senderName=#{senderName},userInfoPhone=#{userInfoPhone} WHERE recipientId=#{recipientId}")
	public void updateorderInforMation_gsp_zsh(address_lql_zsh address_lql_zsh);
}
