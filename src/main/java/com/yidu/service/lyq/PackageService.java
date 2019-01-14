package com.yidu.service.lyq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.dao.lyq.PackageMapper;

@Service
/**
 * 
 * 功能：业务层（接口）
 * @author 刘永琪
 * @date 2019年1月4日
 * @version V1.0
 */
public class PackageService {
@Autowired
private PackageMapper packageMapper;
/**
 * 功能:查询所有和分页
 * @param page
 * @param rows
 * @return
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
 * 功能:新增
 * @param packages
 */
public int insertpackage(com.yidu.bean.lyq.Package packages,String ids) {
	for (int i = 0; i < ids.split("-").length; i++) {
		//循环调用修改
	}
	int insertpackage = packageMapper.insertpackage(packages);
	return insertpackage;
}
/**
 * 功能:修改
 * @param packages
 */
public void updatepackage(com.yidu.bean.lyq.Package packages) {
	packageMapper.updatepackage(packages);
	
}
/**
 * 功能:删除
 * @param packages
 */
public void deletepackage(com.yidu.bean.lyq.Package packages) {
	packageMapper.deletepackage(packages);
	
}
/**
 * 功能:修改审核状态
 * @param packages
 */
public void updateState(String ids) {
	System.out.println(ids);
	String[] idss=ids.split("-");
	for (int i = 0; i <idss.length ; i++) {
		packageMapper.updateState(idss[i],"审核通过");
	}
}

/**
 * 功能:修改审核状态
 * @param packages
 */
public void updateState1(String ids) {
	System.out.println(ids);
	
	String[] idsss=ids.split("-");
	for (int i = 0; i <idsss.length ; i++) {
		packageMapper.updateState1(idsss[i],"未通过审核");
	}
}

}
