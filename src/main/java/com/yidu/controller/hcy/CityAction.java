package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.City;
import com.yidu.service.hcy.CityService;
/**
 * 
 * @Description: 市级控制层
 * @author: 胡春毅
 * @date 2018年12月19日 上午10:37:53
 * @version 1.0
 */
@Controller
public class CityAction {
	@Autowired CityService cityService;
	/**
	 * 
	 * @Explain:分页市
	 * @date 2018年12月17日上午11:04:54
	 * @return 市分页数据
	 */
	@RequestMapping("pageCity.action")
	public @ResponseBody Map<String, Object> pageProvince(String page,String limit){
		return cityService.pageCity(page,limit);
	}
	
	/**
	 * 
	 * @Explain:新增市
	 * @date 2018年12月17日上午11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insCity.action")
	public @ResponseBody int insCity(@ModelAttribute City city){
		return cityService.insCity(city);
	}
	/**
	 * 
	 * @Explain:删除市
	 * @date 2018年12月17日上午11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delCity.action")
	public @ResponseBody int delProvince(String cityId){
		return cityService.delCity(cityId);
	}
	/**
	 * 
	 * @Explain:修改市
	 * @date 2018年12月17日上午11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upCity.action")
	public @ResponseBody int upProvince(@ModelAttribute City city){
		return cityService.upCity(city);
	}
}
