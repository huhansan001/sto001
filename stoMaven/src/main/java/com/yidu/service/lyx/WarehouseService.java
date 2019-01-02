package com.yidu.service.lyx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.lyx.Warehouse;

import com.yidu.dao.lyx.WarehouseMapper;

@Service
/**
 * 
 * 功能：业务层
 * @author 李泳希
 * @date 2018年12月22日
 * @version V1.0
 */
public class WarehouseService {
	@Autowired
    private WarehouseMapper waehouse;
	/**
	 * 功能：实现查询所有和分页
	 * @param page
	 * @param rows
	 * @return map
	 */
	public Map<String,Object> selectdistributeAll(String page,String rows){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",waehouse.warehouses().size());
		map.put("data",waehouse.selectwarehousesAllpage((Integer.parseInt(page)-1)*Integer.parseInt(rows),Integer.parseInt(rows)));
		return map;
	}
	/**
	 * 功能：实现新增
	 * @return
	 */
	public void insertdistribute(Warehouse WarehouseMapper) {
		 waehouse.insertdistribute(WarehouseMapper);
	}
	 /**
	  * 功能：实现修改
	  * @return
	  */
	public void updateSenders(Warehouse WarehouseMapper) {
		waehouse.updateSenders(WarehouseMapper);	
	}
	/**
	 * 功能：实现删除
	 * @return
	 */
	public void deletedistribute(Warehouse Warehouse) {
		waehouse.deletedistribute(Warehouse);
		
	}
}

