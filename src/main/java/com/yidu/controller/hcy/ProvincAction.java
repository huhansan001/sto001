package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.Province;
import com.yidu.service.hcy.ProvinceService;
/**
 * 
 * @Description: 区县控制层
 * @author: 胡春毅
 * @date 2018年12月19日 上午10:38:38
 * @version 1.0
 */
@Controller
public class ProvincAction {
	@Autowired ProvinceService provinceService;
	/**
	 * 
	 * @Explain:分页区
	 * @date 2018年12月17日上午11:04:54
	 * @return 区分页数据
	 */
	@RequestMapping("pageProvince.action")
	public @ResponseBody Map<String, Object> pageProvince(String page,String limit){
		return provinceService.pageProvince(page,limit);
	}
	
	/**
	 * 
	 * @Explain:新增区
	 * @date 2018年12月17日上午11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insProvince.action")
	public @ResponseBody int insProvince(@ModelAttribute Province Province){
		return provinceService.insProvince(Province);
	}
	/**
	 * 
	 * @Explain:删除区
	 * @date 2018年12月17日上午11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delProvince.action")
	public @ResponseBody int delProvince(String proId){
		return provinceService.delProvince(proId);
	}
	/**
	 * 
	 * @Explain:修改区
	 * @date 2018年12月17日上午11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upProvince.action")
	public @ResponseBody int upProvince(@ModelAttribute Province Province){
		return provinceService.upProvince(Province);
	}
}
