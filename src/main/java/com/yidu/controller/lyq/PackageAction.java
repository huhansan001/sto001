package com.yidu.controller.lyq;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.lyq.Distribute;
import com.yidu.service.lyq.PackageService;

@Controller
/**
 * 
 * 功能：控制层
 * @author 刘永琪
 * @date 2018年12月22日
 * @version V1.0
 */
public class PackageAction {
@Autowired 
private PackageService packageService;
/**
 * 功能：查询所有加分页
 * @param page
 * @param limit
 * @return
 */
@RequestMapping("selectpackageAll.action")
public @ResponseBody Map<String, Object> selectpackageAll(String page,String limit){
	return packageService.selectpackageAll(page,limit);
}
/**
 * 功能：新增一条数据
 * @param packages
 * @return
 */
@RequestMapping("insertpackage.action")
public @ResponseBody int  insertpackage(@ModelAttribute com.yidu.bean.lyq.Package packages){
	return packageService.insertpackage(packages);
}
/**
 * 功能：修改
 * @param packages
 * @return
 */
@RequestMapping("updatepackage.action")
public @ResponseBody  String updatepackage(@ModelAttribute com.yidu.bean.lyq.Package packages) {
	packageService.updatepackage(packages);
	return "ok";
	
}
/**
 * 功能：删除
 * @param packages
 * @return
 */
@RequestMapping("deletepackage.action")
public @ResponseBody  String  dletepackage(@ModelAttribute com.yidu.bean.lyq.Package packages) {
	packageService.deletepackage(packages);
	return "ok";
	
}
}
