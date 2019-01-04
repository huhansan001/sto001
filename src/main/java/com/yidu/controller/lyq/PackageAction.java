package com.yidu.controller.lyq;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.service.lyq.PackageService;

@Controller
/**
 * 
 * 鍔熻兘锛氭帶鍒跺眰
 * @author 鍒樻案鐞�
 * @date 2018骞�12鏈�22鏃�
 * @version V1.0
 */
public class PackageAction {
@Autowired 
private PackageService packageService;
/**
 * 鍔熻兘锛氭煡璇㈡墍鏈夊姞鍒嗛〉
 * @param page
 * @param limit
 * @return
 */
@RequestMapping("selectpackageAll.action")
public @ResponseBody Map<String, Object> selectpackageAll(String page,String limit){
	return packageService.selectpackageAll(page,limit);
}
/**
 * 鍔熻兘锛氭柊澧炰竴鏉℃暟鎹�
 * @param packages
 * @return
 */
@RequestMapping("insertpackage.action")
public @ResponseBody int  insertpackage(@ModelAttribute com.yidu.bean.lyq.Package packages){
	return packageService.insertpackage(packages);
}
/**
 * 鍔熻兘锛氫慨鏀�
 * @param packages
 * @return
 */
@RequestMapping("updatepackage.action")
public @ResponseBody  String updatepackage(@ModelAttribute com.yidu.bean.lyq.Package packages) {
	packageService.updatepackage(packages);
	return "ok";
	
}
/**
 * 鍔熻兘锛氬垹闄�
 * @param packages
 * @return
 */
@RequestMapping("deletepackage.action")
public @ResponseBody  String  dletepackage(@ModelAttribute com.yidu.bean.lyq.Package packages) {
	packageService.deletepackage(packages);
	return "ok";
	
}
}
