package com.yidu.service.lyx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.dao.lyx.ShuttleMapper;

@Service
public class ShuttleService {
	@Autowired
    private ShuttleMapper shuttleMapper;
	
	public Map<String,Object> selectdistributeAll(){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",shuttleMapper.selectSenderAll().size());
		map.put("data",shuttleMapper.selectSenderAll());
		return map;
	}
	
	public int insertdistribute(ShuttleMapper distribute) {
		return shuttleMapper.insertdistribute(distribute);
	}
	public void updatedistribute(ShuttleMapper distribute) {
		 shuttleMapper.updatedistribute(distribute);
		
	}
	public void deletedistribute(ShuttleMapper distribute) {
		 shuttleMapper.deletedistribute(distribute);
		
	}
}
