package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.Areas;
import com.yidu.service.hcy.AreasService;
/**
 * 
 * @Description: 省级控制层
 * @author: 胡春毅
 * @date 2018年12月19日 上午10:37:31
 * @version 1.0
 */
@Controller
public class AreasAction {
	@Autowired AreasService areasService;
	/**
	 * 
	 * @Explain:分页省
	 * @date 2018年12月17日上午11:04:54
	 * @return 省分页数据
	 */
	@RequestMapping("pageAreas.action")
	public @ResponseBody Map<String, Object> pageAreas(String page,String limit){
		return areasService.pageAreas(page,limit);
	}
	
	/**
	 * 
	 * @Explain:新增省
	 * @date 2018年12月17日上午11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insAreas.action")
	public @ResponseBody int insAreas(@ModelAttribute Areas areas){
		return areasService.insAreas(areas);
	}
	/**
	 * 
	 * @Explain:删除省
	 * @date 2018年12月17日上午11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delAreas.action")
	public @ResponseBody int delAreas(String areasId){
		return areasService.delAreas(areasId);
	}
	/**
	 * 
	 * @Explain:修改省
	 * @date 2018年12月17日上午11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upAreas.action")
	public @ResponseBody int upAreas(@ModelAttribute Areas areas){
		return areasService.upAreas(areas);
	}
}
