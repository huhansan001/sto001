package com.yidu.service.xwc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.xwc.ServiceTable_xwc;
import com.yidu.dao.xwc.ServiceTableMapper_xwc;
/**
 * 
 *描述：业务表的业务层
 * @author 夏望城
 *@date2018年12月22日下午4:04:55
 */
@Service
public class ServiceTableService_xwc {
	@Autowired
	private ServiceTableMapper_xwc serviceTableMapper_xwc;
	/**
	 * 
	 *功能：查询所有（分页）
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectServiceTableAll(String page,String row,String id,String select){
		Map<String, Object> map=new HashMap<String, Object>();
		//转成json格式
		map.put("code",0);
		map.put("msg","");
		//强转成int类型
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(row);
		if(id!=null) {
			map.put("count", 1);
			//调用dao层方法
			map.put("data", serviceTableMapper_xwc.selectServiceTableSole(id));
		}else if(select!=null){
			map.put("count", 1);
			map.put("data", serviceTableMapper_xwc.selectServiceTableStatus(select));
		}else {
			map.put("count", serviceTableMapper_xwc.selectServiceTableAll().size());
			//调用dao层分页的方法
			map.put("data", serviceTableMapper_xwc.selectServiceTableAllpage((pages-1)*rows,rows));
		}
		return map;
	}
	/**
	 * 
	 *功能：新增
	 * @param serviceTable_xwc
	 */
	public void insertServiceTable(ServiceTable_xwc serviceTable_xwc) {
		//
		serviceTableMapper_xwc.insertServiceTable(serviceTable_xwc);
	}
	/**
	 * 
	 *功能：删除
	 * @param serviceTable_xwc
	 */
	public void deleteServiceTable(ServiceTable_xwc serviceTable_xwc) {
		serviceTableMapper_xwc.deleteServiceTable(serviceTable_xwc);
	}
	
	/**
	 * 
	 *功能：修改
	 * @param serviceTable_xwc
	 */
	public void updateServiceTable(ServiceTable_xwc serviceTable_xwc) {
		serviceTableMapper_xwc.updateServiceTable(serviceTable_xwc);
	}
}
