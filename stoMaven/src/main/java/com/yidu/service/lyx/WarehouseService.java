package com.yidu.service.lyx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.lyx.Warehouse;

import com.yidu.dao.lyx.WarehouseMapper;

@Service
/**
 * 
 * ���ܣ�ҵ���
 * @author ��Ӿϣ
 * @date 2018��12��22��
 * @version V1.0
 */
public class WarehouseService {
	@Autowired
    private WarehouseMapper waehouse;
	/**
	 * ���ܣ�ʵ�ֲ�ѯ���кͷ�ҳ
	 * @param page
	 * @param rows
	 * @return map
	 */
	public Map<String,Object> selectdistributeAll(String page,String rows){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",waehouse.warehouses().size());
		map.put("data",waehouse.selectwarehousesAllpage((Integer.parseInt(page)-1)*Integer.parseInt(rows),Integer.parseInt(rows)));
		return map;
	}
	/**
	 * ���ܣ�ʵ������
	 * @return
	 */
	public void insertdistribute(Warehouse WarehouseMapper) {
		 waehouse.insertdistribute(WarehouseMapper);
	}
	 /**
	  * ���ܣ�ʵ���޸�
	  * @return
	  */
	public void updateSenders(Warehouse WarehouseMapper) {
		waehouse.updateSenders(WarehouseMapper);	
	}
	/**
	 * ���ܣ�ʵ��ɾ��
	 * @return
	 */
	public void deletedistribute(Warehouse Warehouse) {
		waehouse.deletedistribute(Warehouse);
		
	}
}

