package com.yidu.service.lyq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.dao.lyq.PackageMapper;

@Service
/**
 * 
 * 鍔熻兘锛氫笟鍔″眰
 * @author 鍒樻案鐞�
 * @date 2018骞�12鏈�22鏃�
 * @version V1.0
 */
public class PackageService {
@Autowired
private PackageMapper packageMapper;
/**
 * 鍔熻兘锛氬疄鐜版煡璇㈡墍鏈夊拰鍒嗛〉
 * @param page
 * @param rows
 * @return map
 */
public Map<String, Object> selectpackageAll(String page,String rows){
	Map<String, Object> map=new HashMap<String,Object>();
	map.put("code",0);
	map.put("msg","");
	map.put("count",packageMapper.selectpackageAll().size());
	map.put("data",packageMapper.selectpackageAllpage((Integer.parseInt(page)-1)*Integer.parseInt(rows),Integer.parseInt(rows)));
	return map;
	
}
/**
 * 鍔熻兘锛氬疄鐜版柊澧�
 * @return
 */
public int insertpackage(com.yidu.bean.lyq.Package packages) {
	return packageMapper.insertpackage(packages);
}
/**
 * 鍔熻兘锛氬疄鐜颁慨鏀�
 * @return
 */
public void updatepackage(com.yidu.bean.lyq.Package packages) {
	packageMapper.updatepackage(packages);
	
}
/**
 * 鍔熻兘锛氬疄鐜板垹闄�
 * @return
 */
public void deletepackage(com.yidu.bean.lyq.Package packages) {
	packageMapper.deletepackage(packages);
	
}


}
