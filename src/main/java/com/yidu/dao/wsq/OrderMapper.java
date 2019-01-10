package com.yidu.dao.wsq;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.wsq.StoWorkOrder_wsq;

/**
 * 描述：业务表的增删改查
 * @author 文思晴
 *@date2018年12月22日下午4:54:56
 */
@Repository
public interface OrderMapper {
	
	/**
	 *查询所有用户
	 */
	@Select ("select * from workorder_wsq")
	public List<StoWorkOrder_wsq> selectWorkOrder_wsqAll();
	
	/**
	 * 根据ID号查询用户信息7
	 */
	@Select ("select * from workorder_wsq where workerNumber=#{workerNumber}")
	public List<StoWorkOrder_wsq> selectid(StoWorkOrder_wsq workerNumber);
	
	/**
	 * 新增一条信息
	 */
	@Insert("INSERT INTO workorder_wsq (workerNumber,employeeNumber,orderNumber,serviceHours) VALUES (#{workerNumber},#{employeeNumber},#{orderNumber},#{serviceHours})")
	public int insertplace(StoWorkOrder_wsq user);
	
	/**
	 * 删除一条数据
	 */
	@Delete("delete from workorder_wsq where workerNumber=#{workerNumber}")
	public void delectOrderid (StoWorkOrder_wsq user);
	
	/**
	 * 分页查询
	 */
	@Select("SELECT * FROM workorder_wsq LIMIT #{page},#{rows}")
	public List<StoWorkOrder_wsq> selectWorkOrder_wsqlimit (@Param("page")int page,@Param("rows")int row);
	
	/**
	 * 修改一条数据
	 */
	@Update("update workorder_wsq SET employeeNumber=#{employeeNumber},orderNumber=#{orderNumber},serviceHours=#{serviceHours} WHERE workerNumber=#{workerNumber}")
	public void uodates(StoWorkOrder_wsq workorder);
	
}
	