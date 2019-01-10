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
 * 描述：业务表的控制层
 * @author 文思晴
 *@date2018年12月22日下午3:59:56
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
	 * 根据id查询
	 */
	@RequestMapping("selectid.action")
	public @ResponseBody Map<String,Object> selectid(StoWorkOrder_wsq workerNumber){
		System.out.println("-------");
		System.out.println(workerNumber.toString());
//		orderservice.selectid(workerNumber);
		return null;
	}
	/**
	 *增加一个用户
	 */
	@RequestMapping("insert.action")
	public @ResponseBody String insertuser(StoWorkOrder_wsq order) {
		System.out.println(order.toString());
		order.setWorkerNumber(new Random().nextInt(99999999)+10000000);
		order.setServiceHours("未处理");
		int	 temp = orderservice.insert(order);
		System.out.println(temp+"===值"+order);
		return "添加成功";
	}
	/**
	 * 根据id删除用户
	 */
	@RequestMapping("delectOrder.action")
	public @ResponseBody void delectOrderid (@ModelAttribute StoWorkOrder_wsq orderid) {
		orderservice.delectOrderid(orderid);
		//System.out.println(orderid);
	}
	/**
	 * 根据id修改
	 */
	@RequestMapping("upOrder.action")
	public @ResponseBody void upOrderid (@ModelAttribute StoWorkOrder_wsq workorder) {
		orderservice.uodates(workorder);		
		//System.out.println(workorder.toString());
	}
}
