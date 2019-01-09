package com.yidu.dao.zj;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.zj.UserReg;
/**
 * 类说明：Dao�?
 * @author 周江
 */
@Repository
public interface UserRela {
	/*
	 * function:查询�?有的用户信息
	 * name :Quiet
	 * @param SelectuserRelaAll
	 * @date 2018�?1�?5日上�?11:40:50
	 */
	@Select("SELECT * FROM userRealname ")
	public List<UserReg> SelectuserRelaAll();
	/*
	 * function:分页
	 * name :Quiet
	 * @param SelectuserRelaAll	 * @date 2018�?1�?5日上�?11:40:50
	 */
	@Select("SELECT * FROM userRealname limit #{page},#{rows}")
	public List<UserReg> SelectuserRelaAllpage(@Param("page")int page,@Param("rows")int rows);
	
	/*
	 * function:新增用户信息
	 * name :Quiet
	 * @param insertuserRela
	 * @return
	 * @date 2018�?1�?5日上�?11:40:50
	 */
	@Insert("INSERT INTO userRealname(userName,userSex,userNation,userBirthday,userIDnumber,homeAddress,detailedAddress,phoneNumber,userPass) "
			+ "VALUE(#{userName},#{userSex},#{userNation},#{userBirthday},#{userIDnumber},#{homeAddress},#{detailedAddress},#{phoneNumber},#{userPass})")
	public int insertuserRela(UserReg user);

	/*
	 * function:修改用户信息
	 * name :Quiet
	 * @param deleteuserRela
	 * @return
	 * @date 2018�?12�?14日上�?8:40:51
	 */
	@Update("UPDATE userRealname SET urealNameId=#{urealNameId},userName=#{userName},userSex=#{userSex},userNation=#{userNation},"
			+ "userBirthday=#{userBirthday},userIDnumber=#{userIDnumber},homeAddress=#{homeAddress},"
			+ "detailedAddress=#{detailedAddress},phoneNumber=#{phoneNumber},userPass=#{userPass}"
			+ "WHERE urealNameId=#{urealNameId}")
	public int updateuserRela(UserReg user);

	/*
	 * function:删除用户信息
	 * @param deleteuserRela
	 * @return
	 * @date 2018�?1�?5日上�?11:40:50
	 */
	@Delete("DELETE FROM userRealname WHERE urealNameId=#{urealNameId}")
	public int deleteuserRela(UserReg user);
} 
