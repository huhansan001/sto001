package com.yidu.controller.wsq;


import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.wsq.StoWorkOrder_wsq;
import com.yidu.service.wsq.OrderService;

/**
 * ������ҵ���Ŀ��Ʋ�
 * @author ��˼��
 *@date2018��12��22������3:59:56
 */
@Controller
public class OrderController {
	@Autowired
	private OrderService orderservice;
	@RequestMapping("selectOrderAll.action")
	public @ResponseBody Map<String,Object> selectAll(String page,String limit){
		Map<String, Object> map = orderservice.selectWorkOrder_wsqAll( page,limit);
		//System.out.println(map);
		return map;
	}
	/**
	 * ����id��ѯ
	 */
	@RequestMapping("selectid.action")
	public @ResponseBody Map<String,Object> selectid(StoWorkOrder_wsq workerNumber){
		System.out.println("-------");
		System.out.println(workerNumber.toString());
//		orderservice.selectid(workerNumber);
		return null;
	}
	/**
	 *����һ���û�
	 */
	@RequestMapping("insert.action")
	public @ResponseBody String insertuser(StoWorkOrder_wsq order) {
		System.out.println(order.toString());
		order.setWorkerNumber(new Random().nextInt(99999999)+10000000);
		order.setServiceHours("δ����");
		int	 temp = orderservice.insert(order);
		System.out.println(temp+"===ֵ"+order);
		return "��ӳɹ�";
	}
	/**
	 * ����idɾ���û�
	 */
	@RequestMapping("delectOrder.action")
	public @ResponseBody void delectOrderid (@ModelAttribute StoWorkOrder_wsq orderid) {
		orderservice.delectOrderid(orderid);
		//System.out.println(orderid);
	}
	/**
	 * ����id�޸�
	 */
	@RequestMapping("upOrder.action")
	public @ResponseBody void upOrderid (@ModelAttribute StoWorkOrder_wsq workorder) {
		orderservice.uodates(workorder);		
		//System.out.println(workorder.toString());
	}
}
