package com.yidu.service.lyq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.lyq.Distribute;
import com.yidu.dao.lyq.PackageMapper;

@Service
/**
 * 
 * 功能：业务层
 * @author 刘永琪
 * @date 2018年12月22日
 * @version V1.0
 */
public class PackageService {
@Autowired
private PackageMapper packageMapper;
/**
 * 功能：实现查询所有和分页
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
 * 功能：实现新增
 * @return
 */
public int insertpackage(com.yidu.bean.lyq.Package packages) {
	return packageMapper.insertpackage(packages);
}
/**
 * 功能：实现修改
 * @return
 */
public void updatepackage(com.yidu.bean.lyq.Package packages) {
	packageMapper.updatepackage(packages);
	
}
/**
 * 功能：实现删除
 * @return
 */
public void deletepackage(com.yidu.bean.lyq.Package packages) {
	packageMapper.deletepackage(packages);
	
}


}
