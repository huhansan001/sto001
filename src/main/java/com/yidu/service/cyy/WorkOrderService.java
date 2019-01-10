package com.yidu.service.cyy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.cyy.WorkOrder;
import com.yidu.dao.cyy.WorkOrderMapper;


/**
 * 描述： 工单表的业务层
 * 功能： 实现方法
 * @Description：
 * @author ：陈莹莹
 * @date ：2018年12月11日 下午1:46:55 
 *
 */
@Service
public class WorkOrderService {
	@Autowired
	private WorkOrderMapper workOrderMapper;//调用dao层
	
	/*
	 * 查询所有
	 * public Map<String, Object> selectWorkOrderAll(){
		Map<String, Object> map=new HashMap<String, Object>();//将所有数据装进去
		map.put("code",0);//分页
		map.put("msg","");
		map.put("count",workOrderMapper.selectWorkOrderAll().size());//长度 共多少页
		map.put("data",workOrderMapper.selectWorkOrderAll());//所有数据
		              //（注：workOrderMapper.selectWorkOrderAll() 可获取数据库的数据）
		return map;//把map放进去
	}*/
	
	/**
	 * 分页查询 加查询所有
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectWorkOrderAll(int page,int row){
		Map<String, Object> map=new HashMap<String, Object>();//将所有数据装进去
		map.put("code",0);//分页
		map.put("msg","");
		map.put("count",workOrderMapper.selectWorkOrderAll().size());//长度 共多少页
		map.put("data",workOrderMapper.selectWorkOrderAllPaging((page-1)*row,row));//所有数据
						//（注：workOrderMapper.selectWorkOrderAll() 可获取数据库的数据）
		return map;//把map放进去
	}
	/**
	 * 
	 *功能：删除
	 * @param receiptOrders
	 */
	public void deleteWork(WorkOrder workOrder) {
		workOrderMapper.deleteWork(workOrder);
	}
	
	/**
	 * 
	 *功能：修改
	 * @param receiptOrders
	 */
	public void updateWork(WorkOrder workOrder){
		workOrderMapper.updateWork(workOrder);
	}
	public void insertData(String  empNo,String packageId,String sendTime,String worksheet ){
		workOrderMapper.insertData(empNo, packageId, sendTime,worksheet);
	}
	public void updateworksheet(String packageId){
		workOrderMapper.updateworksheet(packageId);
	}
}



