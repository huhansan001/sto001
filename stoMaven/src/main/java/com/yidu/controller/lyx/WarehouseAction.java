package com.yidu.controller.lyx;

import java.util.Map;

import org.apache.catalina.ha.backend.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.lyx.Warehouse;
import com.yidu.service.lyx.WarehouseService;
/**
 * 功能：控制层
 * @author 李泳希
 * @date 2018年12月22日
 * @version V1.0
 */
@Controller
public class WarehouseAction {
 @Autowired
  private WarehouseService warehouseService;
 /**
  * 功能：查询所有加分页
  * @param page
  * @param limit
  * @return
  */
 @RequestMapping("warehouses.action")
 public @ResponseBody Map<String, Object> selectSenderAll(String page,String limit){
		return warehouseService.selectdistributeAll(page,limit);
		/**
		 * 功能：新增一条数据
		 * @param packages
		 * @return
		 */	
	}
	@RequestMapping("insertSenders.action")
	public @ResponseBody String insertSender(@ModelAttribute Warehouse warehouse){
		warehouseService.insertdistribute(warehouse);
		System.out.println(warehouse.toString());
		return "ok";	
	}
	/**
	 * 功能：修改
	 * @param packages
	 * @return
	 */
	@RequestMapping("updateSenders.action")
	public @ResponseBody String updateSenders(@ModelAttribute Warehouse warehouse){
		warehouseService.updateSenders(warehouse);
		System.out.println(warehouse.toString());
		return "ok";
	}
	/**
	 * 功能：删除
	 * @param packages
	 * @return
	 */
	@RequestMapping("deletedistribute.action")
		public @ResponseBody String deletedistribute(@ModelAttribute Warehouse Warehouse) {
			System.out.println(Warehouse);
			warehouseService.deletedistribute(Warehouse);
			return "ok";
		}

}
