package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.ComPackage;
import com.yidu.service.hcy.ComPackageService;
/**
 * 
 * @Description: 合包控制层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:38:02
 * @version 1.0
 */
@Controller
public class ComPackageAction {
	@Autowired 
	private ComPackageService comPackageService;
	/**
	 * 
	 * @Explain:分页合包
	 * @date 2018年12月17日上午11:04:54
	 * @return 合包分页数据
	 */
	@RequestMapping("pageComPackage.action")
	public @ResponseBody Map<String, Object> pageComPackage(String page,String limit){
		return comPackageService.pageComPackage(page,limit);
	}
	
	/**
	 * 
	 * @Explain:新增合包
	 * @date 2018年12月17日上午11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insComPackage.action")
	public @ResponseBody int insComPackage(ComPackage comPackage){
		return comPackageService.insComPackage(comPackage);
	}
	/**
	 * 
	 * @Explain:删除合包
	 * @date 2018年12月17日上午11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delComPackage.action")
	public @ResponseBody int delComPackage(String shuttleId){
		return comPackageService.delComPackage(shuttleId);
	}
	/**
	 * 
	 * @Explain:修改合包
	 * @date 2018年12月17日上午11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upComPackage.action")
	public @ResponseBody int upComPackage(ComPackage comPackage){
		return comPackageService.upComPackage(comPackage);
	}
}
