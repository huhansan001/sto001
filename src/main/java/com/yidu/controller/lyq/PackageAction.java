package com.yidu.controller.lyq;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.service.lyq.PackageService;
import com.yidu.service.lyx.WarehouseService;

@Controller
/**
 * 鍔熻兘锛氬寘瑁硅〃鎺у埗灞�
 * @author 鍒樻案鐞�
 * @date 2019骞�1鏈�4鏃�
 * @version V1.0
 */
public class PackageAction {
	@Autowired 
	private PackageService packageService;
	
	@Autowired
	 private WarehouseService warehouseService;
	/**
	 * 鍔熻兘:鏌ヨ鎵�鏈夊拰鍒嗛〉
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("selectpackageAll.action")
	public @ResponseBody Map<String, Object> selectpackageAll(String page,String limit){
		return packageService.selectpackageAll(page,limit);
	}
	/**
	 * 鍔熻兘:鏂板涓�鏉℃暟鎹�
	 * @param packages
	 * @return
	 */
	@RequestMapping("insertpackage.action")
	public @ResponseBody int  insertpackage(@ModelAttribute com.yidu.bean.lyq.Package packages){
		return packageService.insertpackage(packages);
	}
	/**
	 * 鍔熻兘:淇敼鏁版嵁
	 * @param packages
	 * @return
	 */
	@RequestMapping("updatepackage.action")
	public @ResponseBody  String updatepackage(@ModelAttribute com.yidu.bean.lyq.Package packages) {
		packageService.updatepackage(packages);
		return "ok";

	}
	/**
	 * 鍔熻兘:鍒犻櫎涓�鏉℃暟鎹�
	 * @param packages
	 * @return
	 */
	@RequestMapping("deletepackage.action")
	public @ResponseBody  String  dletepackage(@ModelAttribute com.yidu.bean.lyq.Package packages) {
		packageService.deletepackage(packages);
		return "ok";

	}

	/**
	 * 鍔熻兘:淇敼鏁版嵁
	 * @param packages
	 * @return
	 */
	@RequestMapping("updateState.action")
	public @ResponseBody  String updateState(String ids) {
		packageService.updateState(ids+"id");
		return "ok";

	}
	/**
	 * 鍔熻兘:淇敼鏁版嵁
	 * @param packages
	 * @return
	 */
	@RequestMapping("updateState1.action")
	public @ResponseBody  String updateState1(String ids) {
		packageService.updateState1(ids);
		return "ok";
	}
}
