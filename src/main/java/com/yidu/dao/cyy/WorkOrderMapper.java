package com.yidu.dao.cyy;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.cyy.WorkOrder;

@Repository
public interface WorkOrderMapper {
	/*
	  * ��ѯ����
	 */
@Select("select * from workorder_cyy")
public List<WorkOrder> selectWorkOrderAll();
	/*
	 * ��ҳ��ѯ
	*/
@Select("select * from workorder_cyy limit #{page},#{row}")
public List<WorkOrder> selectWorkOrderAllPaging(@Param("page")int page,@Param("row")int row);
	/* 
	 *���ܣ����ݰ���idɾ��������Ϣ
	 */
@Delete("delete from workorder_cyy where packageId=#{packageId}")
public void deleteWork(WorkOrder workOrder);
	/* 
	 *���ܣ����ݰ���id�޸Ķ�����Ϣ
	 */
@Update("update workorder_cyy set empNo=#{empNo},sendTime=#{sendTime},worksheet=#{worksheet} WHERE packageId=#{packageId}")

public void updateWork(WorkOrder workOrder);

}
