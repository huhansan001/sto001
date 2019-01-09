package com.yidu.dao.wsq;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.wsq.StoWorkOrder_wsq;

@Repository
public interface OrderMapper {
	
	/**
	 *��ѯ�����û�
	 */
	@Select ("select * from workorder_wsq")
	public List<StoWorkOrder_wsq> selectWorkOrder_wsqAll();
	/**
	 * ����ID�Ų�ѯ�û���Ϣ
	 */
	@Select ("select * from workorder_wsq where workerNumber=#{workerNumber}")
	public List<StoWorkOrder_wsq> selectid(StoWorkOrder_wsq workerNumber);
	/**
	 * ����һ����Ϣ
	 */

	@Insert("INSERT INTO workorder_wsq (workerNumber,employeeNumber,orderNumber,serviceHours) VALUES (#{workerNumber},#{employeeNumber},#{orderNumber},#{serviceHours})")
	public int insertplace(StoWorkOrder_wsq user);
	
	/**
	 * ɾ��һ������
	 */
	@Delete("delete from workorder_wsq where workerNumber=#{workerNumber}")
	public void delectOrderid (StoWorkOrder_wsq user);
	
	/**
	 * ��ҳ��ѯ
	 */
	@Select("SELECT * FROM workorder_wsq LIMIT #{page},#{rows}")
	public List<StoWorkOrder_wsq> selectWorkOrder_wsqlimit (@Param("page")int page,@Param("rows")int row);
	
	/**
	 * �޸�һ������
	 */
	@Update("update workorder_wsq SET employeeNumber=#{employeeNumber},orderNumber=#{orderNumber},serviceHours=#{serviceHours} WHERE workerNumber=#{workerNumber}")
	public void uodates(StoWorkOrder_wsq workorder);
	
}
	