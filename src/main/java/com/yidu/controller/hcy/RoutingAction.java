package com.yidu.controller.hcy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.Routing;
import com.yidu.service.hcy.RoutingService;

/**
 * 
 * @Description: 路由控制层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:38:26
 * @version 1.0
 */
@Controller
public class RoutingAction {
	@Autowired 
	private RoutingService routingService;
	/**
	 * 
	 * @Explain:分页合包
	 * @date 2018年12月17日上午11:04:54
	 * @return 合包分页数据
	 */
	@RequestMapping("pageRouting.action")
	public @ResponseBody Map<String, Object> pageRouting(String page,String limit){
		return routingService.pageRouting(page,limit);
	}
	
	/**
	 * 
	 * @Explain:新增合包
	 * @date 2018年12月17日上午11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insRouting.action")
	public @ResponseBody int insShuttle(@ModelAttribute Routing routing){
		return routingService.insRouting(routing);
	}
	/**
	 * 
	 * @Explain:删除合包
	 * @date 2018年12月17日上午11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delRouting.action")
	public @ResponseBody int delShuttle(String shuttleId){
		return routingService.delShuttle(shuttleId);
	}
	/**
	 * 
	 * @Explain:修改合包
	 * @date 2018年12月17日上午11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upRouting.action")
	public @ResponseBody int upShuttle(Routing routing){
		return routingService.upRouting(routing);
	}
}
