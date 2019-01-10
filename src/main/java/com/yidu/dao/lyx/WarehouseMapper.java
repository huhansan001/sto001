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
 * 功能：接口层
 * @author 李泳希
 * @date 2018年12月22日
 * @version V1.0
 */
public interface WarehouseMapper  {
	/**
	 * 功能：查询所有的方法
	 * @return
	 */
	@Select("select * from warehouse_lyx")
	public List<Warehouse> warehouses();
	/**
	 * 功能：新增的方法
	 * @return
	 */
	@Select("select * from warehouse_lyx limit #{page},#{rows}")
	public List<Warehouse> selectwarehousesAllpage(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 功能：分页的方法
	 * @return
	 */
	@Insert("INSERT INTO warehouse_lyx(packageId,courier,whether,unloading) VALUES(#{packageId},#{courier},#{whether},#{unloading})")
	public int insertdistribute(Warehouse warehouseMapper);	
	
@Insert("INSERT INTO warehouse_lyx(packageId,courier,whether,unloading) VALUES(#{packageId},'无','未合包','无')")
//	@Insert("INSERT INTO warehouse_lyx(packageId) VALUES(#{packageId})")
	public int IDUPDATE(Warehouse packageId);
	/**
	 * 功能：根据ID修改的方法
	 * @return
	 */
	@Update("UPDATE warehouse_lyx SET courier=#{courier},whether=#{whether},unloading=#{unloading} where packageId=#{packageId}")
	public void updateSenders(Warehouse warehouseMapper);	
	/**
	 * 功能：根据ID删除的方法
	 * @return
	 */	
	@Delete("delete from warehouse_lyx where packageId=#{packageId}")
	public void deletedistribute(Warehouse warehouseMapper);
	/**
	 *修改合包状态
	 */
	@Update("UPDATE warehouse_lyx SET courier=#{courier},whether=#{whether} WHERE packageId=#{packageId}")
	public void updatewhether(@Param("packageId")String packageId, @Param("courier")String  courier, @Param("whether")String whether);	
}




