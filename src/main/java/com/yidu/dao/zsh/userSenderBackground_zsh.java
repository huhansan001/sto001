package com.yidu.dao.zsh;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.yidu.bean.zsh.userSender_zsh;

/**
 * 
 * 描述：用户下单信息（寄件人）后台
 * 
 * @author zhoushihao
 * @date2019年1月4日上午10:29:51
 */
@Repository
public interface userSenderBackground_zsh {
	/**
	 * 
	 * 功能：分页
	 * 
	 * @param page
	 * @param row
	 * @return
	 */
	@Select("select * from userSender limit #{page},#{row}")
	public List<userSender_zsh> selectUserSenderAllpage(@Param("page") int page, @Param("row") int row);

	/**
	 * 
	 * 功能：搜索姓名查询数据
	 * 
	 * @return
	 */
	/*
	 * @Select("SELECT * FROM userSender WHERE  senderName=#{id}") public
	 * List<userSender_zsh> selectUserSenderSole(@Param("id") String id);
	 */
	/**
	 * 
	 * function:查询所有寄件人表信息 name :Quiet
	 * 
	 * @return
	 * @date 2018年12月24日下午6:48:53
	 */
	@Select("SELECT * FROM userSender")
	public List<userSender_zsh> selectUserSenderAll();

	/**
	 * 
	 * function:新增寄件人表信息 name :Quiet
	 * 
	 * @param userSender_zsh
	 * @return
	 * @date 2018年12月25日上午8:43:31
	 */
	@Insert("INSERT INTO userSender(senderName,senderMobile,senderPhone,senderAddress,senderDetailed,senderType,userInfoPhone) VALUES(#{senderName},#{senderMobile},#{senderPhone},#{senderAddress},#{senderDetailed},#{senderType},#{userInfoPhone})")
	public void insertUserSender(userSender_zsh userSender_zsh);

	/**
	 * 
	 * function:删除寄件人表信息 name :Quiet
	 * 
	 * @param userSender_zsh
	 * @return
	 * @date 2018年12月25日上午9:27:27
	 */
	@Delete("DELETE FROM userSender WHERE senderId=#{senderId}")
	public void deleteUserSender(userSender_zsh userSender_zsh);

	/**
	 * 
	 * function:修改寄件人表信息 name :Quiet
	 * 
	 * @param userSender_zsh
	 * @return
	 * @date 2018年12月25日上午10:23:48
	 */
	@Update("UPDATE userSender SET senderName=#{senderName},senderMobile=#{senderMobile},senderPhone=#{senderPhone},senderAddress=#{senderAddress},senderAddress=#{senderAddress},senderType=#{senderType},userInfoPhone=#{userInfoPhone} WHERE senderId=#{senderId}")
	public void updateUserSender(userSender_zsh userSender_zsh);
}
