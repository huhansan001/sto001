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
 * ���ܣ����Ʋ�
 * @author ��Ӿϣ
 * @date 2018��12��22��
 * @version V1.0
 */
@Controller
public class WarehouseAction {
 @Autowired
  private WarehouseService warehouseService;
 /**
  * ���ܣ���ѯ���мӷ�ҳ
  * @param page
  * @param limit
  * @return
  */
 @RequestMapping("warehouses.action")
 public @ResponseBody Map<String, Object> selectSenderAll(String page,String limit){
		return warehouseService.selectdistributeAll(page,limit);
		/**
		 * ���ܣ�����һ������
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
	 * ���ܣ��޸�
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
	 * ���ܣ�ɾ��
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
