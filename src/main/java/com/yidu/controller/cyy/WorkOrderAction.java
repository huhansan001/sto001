package com.yidu.controller.cyy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.cyy.WorkOrder;
import com.yidu.service.cyy.WorkOrderService;

@Controller
public class WorkOrderAction {

	@Autowired
	private WorkOrderService workOrderService;
	/*
	 * 查询所有 （填充数据）
	 * @RequestMapping("selectWorkOrderAll.action")
		public @ResponseBody Map<String, Object> selectWorkOrderAll(){
		return workOrderService.selectWorkOrderAll();//返回map
	}*/
	
	//分页     此方法给表格填充数据 
	@RequestMapping("selectWorkOrderAll.action")
	public @ResponseBody Map<String, Object> selectWorkOrderAll(int page,int row){
		return workOrderService.selectWorkOrderAll(page,row);//返回map
	}
	/**
	 * 
	 *功能：删除
	 * @param receiptOrders
	 * @return
	 */
	@RequestMapping("deleteWork.action")
	public @ResponseBody String deleteWork(@ModelAttribute WorkOrder workOrder) {
		workOrderService.deleteWork(workOrder);
		return "ok";
	}
	/**
	 * 
	 *功能：修改
	 * @param receiptOrders
	 * @return
	 */
	@RequestMapping("updateWork.action")
	public @ResponseBody String updateWork(@ModelAttribute WorkOrder workOrder) {
		workOrderService.updateWork(workOrder);
		return "ok";
	}
}
