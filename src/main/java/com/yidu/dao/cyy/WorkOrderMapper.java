package com.yidu.dao.cyy;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.cyy.WorkOrder;

@Repository
public interface WorkOrderMapper {
	/*
	  * 查询所有
	 */
@Select("select * from workorder_cyy")
public List<WorkOrder> selectWorkOrderAll();
	/*
	 * 分页查询
	*/
@Select("select * from workorder_cyy limit #{page},#{row}")
public List<WorkOrder> selectWorkOrderAllPaging(@Param("page")int page,@Param("row")int row);
	/* 
	 *功能：根据包裹id删除订单信息
	 */
@Delete("delete from workorder_cyy where packageId=#{packageId}")
public void deleteWork(WorkOrder workOrder);
	/* 
	 *功能：根据包裹id修改订单信息
	 */
@Update("update workorder_cyy set empNo=#{empNo},sendTime=#{sendTime},worksheet=#{worksheet} WHERE packageId=#{packageId}")
public void updateWork(WorkOrder workOrder);

@Insert("INSERT INTO workorder_cyy(packageId,empNo,sendTime,worksheet) VALUES(#{packageId},#{empNo},#{sendTime},#{worksheet})")
public int insertData(@Param("empNo")String  empNo,@Param("packageId")String packageId,@Param("sendTime")String sendTime,@Param("worksheet")String worksheet );

@Update("UPDATE workorder_cyy SET worksheet='已派发' WHERE packageId=#{packageId}")
public void updateworksheet(@Param("packageId") String packageId);
}
