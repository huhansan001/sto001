package com.yidu.dao.xwc;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.yidu.bean.xwc.ServiceTable_xwc;


/**
 * 
 *描述：业务表的增删改查
 * @author 夏望城
 *@date2018年12月22日下午4:00:47
 */
@Repository
public interface ServiceTableMapper_xwc {
	/**
	 * 
	 *功能：查询业务表所有数据
	 * @return
	 */
	@Select("select * from serviceTable_xwc")
	public List<ServiceTable_xwc> selectServiceTableAll();
	/**
	 * 
	 *功能：分页
	 * @param page
	 * @param row
	 * @return
	 */
	@Select("select * from serviceTable_xwc limit #{page},#{row}")
	public List<ServiceTable_xwc> selectServiceTableAllpage(@Param("page")int page,@Param("row")int row);
	
	/**
	 * 
	 *功能：新增
	 * @param serviceTable_xwc
	 */
	@Insert("insert into serviceTable_xwc (orderNumber,addresseeId,orderStatus,remarks,customer)VALUES ( ROUND(ROUND(RAND(),5)*100000),#{addresseeId},#{orderStatus},#{remarks},#{customer})")
	public void insertServiceTable(ServiceTable_xwc serviceTable_xwc);
	/**
	 * 
	 *功能：根据订单号删除表数据
	 * @param serviceTable_xwc
	 */
	@Delete("delete from serviceTable_xwc where orderNumber=#{orderNumber}")
	public void deleteServiceTable(ServiceTable_xwc serviceTable_xwc);
	/**
	 * 
	 *功能:修改
	 * @param serviceTable_xwc
	 */
	@Update("update serviceTable_xwc set addresseeId=#{addresseeId},orderStatus=#{orderStatus},remarks=#{remarks},customer=#{customer} where orderNumber=#{orderNumber}")
	public void updateServiceTable(ServiceTable_xwc serviceTable_xwc);
	/**
	 * 
	 *功能：搜索订单号查询数据
	 * @return
	 */
	@Select("SELECT * FROM serviceTable_xwc WHERE orderNumber=#{id}")
	public List<ServiceTable_xwc> selectServiceTableSole(@Param("id") String id);
	/**
	 * 
	 *功能：查询订单状态
	 * @param select
	 * @return
	 */
	@Select("SELECT * FROM serviceTable_xwc WHERE orderStatus=#{select}")
	public List<ServiceTable_xwc> selectServiceTableStatus(@Param("select") String select);
}
