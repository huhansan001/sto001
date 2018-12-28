package com.yidu.service.xwc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.xwc.ServiceTable_xwc;
import com.yidu.dao.xwc.ServiceTableMapper_xwc;
/**
 * 
 *������ҵ����ҵ���
 * @author ������
 *@date2018��12��22������4:04:55
 */
@Service
public class ServiceTableService_xwc {
	@Autowired
	private ServiceTableMapper_xwc serviceTableMapper_xwc;
	/**
	 * 
	 *���ܣ���ѯ���У���ҳ��
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectServiceTableAll(String page,String row,String id,String select){
		Map<String, Object> map=new HashMap<String, Object>();
		//ת��json��ʽ
		map.put("code",0);
		map.put("msg","");
		//ǿת��int����
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(row);
		if(id!=null) {
			map.put("count", 1);
			//����dao�㷽��
			map.put("data", serviceTableMapper_xwc.selectServiceTableSole(id));
		}else if(select!=null){
			map.put("count", 1);
			map.put("data", serviceTableMapper_xwc.selectServiceTableStatus(select));
		}else {
			map.put("count", serviceTableMapper_xwc.selectServiceTableAll().size());
			//����dao���ҳ�ķ���
			map.put("data", serviceTableMapper_xwc.selectServiceTableAllpage((pages-1)*rows,rows));
		}
		return map;
	}
	/**
	 * 
	 *���ܣ�����
	 * @param serviceTable_xwc
	 */
	public void insertServiceTable(ServiceTable_xwc serviceTable_xwc) {
		//
		serviceTableMapper_xwc.insertServiceTable(serviceTable_xwc);
	}
	/**
	 * 
	 *���ܣ�ɾ��
	 * @param serviceTable_xwc
	 */
	public void deleteServiceTable(ServiceTable_xwc serviceTable_xwc) {
		serviceTableMapper_xwc.deleteServiceTable(serviceTable_xwc);
	}
	
	/**
	 * 
	 *���ܣ��޸�
	 * @param serviceTable_xwc
	 */
	public void updateServiceTable(ServiceTable_xwc serviceTable_xwc) {
		serviceTableMapper_xwc.updateServiceTable(serviceTable_xwc);
	}
}
