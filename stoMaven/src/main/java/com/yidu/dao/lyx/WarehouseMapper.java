package com.yidu.dao.lyx;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.lyx.Warehouse;

@Repository
/**
 * 
 * ���ܣ��ӿڲ�
 * @author ��Ӿϣ
 * @date 2018��12��22��
 * @version V1.0
 */
public interface WarehouseMapper  {
	/**
	 * ���ܣ���ѯ���еķ���
	 * @return
	 */
	@Select("select * from warehouse_lyx")
	public List<Warehouse> warehouses();
	/**
	 * ���ܣ������ķ���
	 * @return
	 */
	@Select("select * from warehouse_lyx limit #{page},#{rows}")
	public List<Warehouse> selectwarehousesAllpage(@Param("page") int page,@Param("rows") int rows);
	/**
	 * ���ܣ���ҳ�ķ���
	 * @return
	 */
	@Insert("INSERT INTO warehouse_lyx(packageId,courier,whether,unloading) VALUES(#{packageId},#{courier},#{whether},#{unloading})")
	public int insertdistribute(Warehouse warehouseMapper);
	/**
	 * ���ܣ�����ID�޸ĵķ���
	 * @return
	 */
	@Update("UPDATE warehouse_lyx SET courier=#{courier},whether=#{whether},unloading=#{unloading} where packageId=#{packageId}")
	public void updateSenders(Warehouse warehouseMapper);	
	/**
	 * ���ܣ�����IDɾ���ķ���
	 * @return
	 */	
	@Delete("delete from warehouse_lyx where packageId=#{packageId} ")
	public void deletedistribute(Warehouse warehouseMapper);
}




