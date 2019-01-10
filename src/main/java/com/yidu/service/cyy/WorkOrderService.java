package com.yidu.service.cyy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.cyy.WorkOrder;
import com.yidu.dao.cyy.WorkOrderMapper;


/**
 * ������ �������ҵ���
 * ���ܣ� ʵ�ַ���
 * @Description��
 * @author ����ӨӨ
 * @date ��2018��12��11�� ����1:46:55 
 *
 */
@Service
public class WorkOrderService {
	@Autowired
	private WorkOrderMapper workOrderMapper;//����dao��
	
	/*
	 * ��ѯ����
	 * public Map<String, Object> selectWorkOrderAll(){
		Map<String, Object> map=new HashMap<String, Object>();//����������װ��ȥ
		map.put("code",0);//��ҳ
		map.put("msg","");
		map.put("count",workOrderMapper.selectWorkOrderAll().size());//���� ������ҳ
		map.put("data",workOrderMapper.selectWorkOrderAll());//��������
		              //��ע��workOrderMapper.selectWorkOrderAll() �ɻ�ȡ���ݿ�����ݣ�
		return map;//��map�Ž�ȥ
	}*/
	
	/**
	 * ��ҳ��ѯ �Ӳ�ѯ����
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> selectWorkOrderAll(int page,int row){
		Map<String, Object> map=new HashMap<String, Object>();//����������װ��ȥ
		map.put("code",0);//��ҳ
		map.put("msg","");
		map.put("count",workOrderMapper.selectWorkOrderAll().size());//���� ������ҳ
		map.put("data",workOrderMapper.selectWorkOrderAllPaging((page-1)*row,row));//��������
						//��ע��workOrderMapper.selectWorkOrderAll() �ɻ�ȡ���ݿ�����ݣ�
		return map;//��map�Ž�ȥ
	}
	/**
	 * 
	 *���ܣ�ɾ��
	 * @param receiptOrders
	 */
	public void deleteWork(WorkOrder workOrder) {
		workOrderMapper.deleteWork(workOrder);
	}
	
	/**
	 * 
	 *���ܣ��޸�
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



