package com.yidu.service.lyq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.lyq.Distribute;
import com.yidu.dao.lyq.DistributeMapper;

@Service
public class DistributeService {
	@Autowired
	private DistributeMapper distributeMapper;
	public Map<String,Object> selectdistributeAll(String page,String rows){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",distributeMapper.selectdistributeAll().size());
		map.put("data",distributeMapper.distributeLimit((Integer.parseInt(page)-1)*Integer.parseInt(rows),Integer.parseInt(rows)));
		return map;
	}
	
	public int insertdistribute(Distribute distribute) {
		return distributeMapper.insertdistribute(distribute);
	}
	public void updatedistribute(Distribute distribute) {
		 distributeMapper.updatedistribute(distribute);
		
	}
	public void deletedistribute(Distribute distribute) {
		 distributeMapper.deletedistribute(distribute);
		
	}
}
