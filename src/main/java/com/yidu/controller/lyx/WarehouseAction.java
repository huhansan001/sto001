package com.yidu.controller.lyx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yidu.bean.lyx.Warehouse;
import com.yidu.service.cyy.WorkOrderService;
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
	@RequestMapping("update.action")
	public @ResponseBody String UPDATE(@ModelAttribute Warehouse packageId){

		System.out.println(packageId+"laile ");

		warehouseService.IDUPDATE(packageId);
		System.out.println(packageId);
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
	/**
	 * 功能：修改合包状态
	 * @param packages
	 * @return
	 */
	@Autowired
	private WorkOrderService work;
	@RequestMapping("updatewhether1.action")
	public @ResponseBody String  updatewhether(String packageId,String courier,String whether,String  empNo,String sendTime,String worksheet){
		whether="已合包";
		//System.out.println( whether+"courier"+courier+packageId);//打印
		warehouseService.updatewhether( packageId,  courier,whether);//调用修改方法
		  Date d = new Date();//设置当前时间写入数据库
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分s秒");
	        String str = sdf.format(d);
	        sendTime=str;
	        empNo=courier;
	        worksheet="派件中";
		work.insertData(empNo, packageId, sendTime, worksheet);
		   System.out.println("新增派件信息成功！");
		return "yes";

	}
}
