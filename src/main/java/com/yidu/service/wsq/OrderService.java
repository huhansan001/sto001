package com.yidu.service.wsq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.wsq.StoWorkOrder_wsq;
import com.yidu.dao.wsq.OrderMapper;

/**
 * 描述：业务表的业务层
 * @author 文思晴
 * @date2018年12月22日下午3:30:56
 */
@Service
public class OrderService {

	
	@Autowired
	private OrderMapper ordermap;
	
	public Map<String,Object> selectWorkOrder_wsqAll(String page,String limit){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",ordermap.selectWorkOrder_wsqAll().size());
		map.put("data",ordermap.selectWorkOrder_wsqlimit((Integer.parseInt(page)-1)*Integer.parseInt(limit),Integer.parseInt(limit)));
		System.out.println(ordermap.selectWorkOrder_wsqlimit((Integer.parseInt(page)-1)*Integer.parseInt(limit),Integer.parseInt(limit)));
		return map;
	}
	public int insert(StoWorkOrder_wsq order){
		return ordermap.insertplace(order);
	}
	public void delectOrderid (StoWorkOrder_wsq orderid) {
		ordermap.delectOrderid(orderid);
	}
	/**
	 *  修改
	 */
	public void uodates(StoWorkOrder_wsq workorder) {
		ordermap.uodates(workorder);
	}
	/**
	 * 根据工单号修改状态
	 */
	public void uodate(String serviceHours,String workerNumber) {
		ordermap.uodate(serviceHours, workerNumber);
	}
	public Map<String,Object> selectid(StoWorkOrder_wsq workerNumber){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",ordermap.selectid(workerNumber).size());
		map.put("data",ordermap.selectid(workerNumber));
		return map;
	}
}
