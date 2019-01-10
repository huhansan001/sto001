package com.yidu.controller.hcy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.Routing;
import com.yidu.bean.hcy.Shuttle;
import com.yidu.service.hcy.RoutingService;
import com.yidu.service.hcy.ShuttleService;

/**
 * 
 * @Description: 班车控制层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:39:01
 * @version 1.0
 */
@Controller
public class ShuttleAction {
	@Autowired 
	private ShuttleService shuttleService;

	//调用路由表的数据对象
	@Autowired
	private Routing routing;
	//调用路由表的业务层
	@Autowired
	private RoutingService routingService;
	/**
	 * 
	 * @Explain:分页合包
	 * @date 2018年12月17日上午11:04:54
	 * @return 合包分页数据
	 */
	@RequestMapping("pageShuttle.action")
	public @ResponseBody Map<String, Object> pageShuttle(String page,String limit,HttpSession session){
		return shuttleService.pageShuttle(page,limit);
	}

	/**
	 * 
	 * @Explain:新增合包
	 * @date 2018年12月17日上午11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insShuttle.action")
	public @ResponseBody int insShuttle(@ModelAttribute Shuttle shuttle){
		System.out.println(shuttle.toString());
		return shuttleService.insShuttle(shuttle);
	}
	/**
	 * 
	 * @Explain:删除合包
	 * @date 2018年12月17日上午11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delShuttle.action")
	public @ResponseBody int delShuttle(String shuttleId){
		return shuttleService.delShuttle(shuttleId);
	}
	/**
	 * 
	 * @Explain:修改合包
	 * @date 2018年12月17日上午11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upShuttle.action")
	public @ResponseBody int upShuttle(Shuttle shuttle){
		return shuttleService.upShuttle(shuttle);
	}
	/**
	 * 功能：点击发车
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@RequestMapping("depart.action")
	public @ResponseBody String depart(@RequestParam(value="shuttleId[]") Integer[] shuttleId) {
		List<Integer> list= Arrays.asList(shuttleId);
		for (Integer i : list) {
			//给路由表的班车id赋值
			routing.setShuttleId(i);
			//给路由表的路由状态赋值
			routing.setRoutingState("转运中心已发车");
			//调用路由表业务层的新增方法
			routingService.insertRouting(routing);

			shuttleService.updateStation(i);
		}
		return "ok";
	}
	/**
	 * 功能：点击下一站后修改下拉列表的值
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@RequestMapping("nextStie.action")
	public @ResponseBody String nextStie(int shuttleId,String station,int index) {
		//给路由表的班车id赋值
		routing.setShuttleId(shuttleId);
		//给路由表的路由状态赋值
		routing.setRoutingState(station+"已发车");
		//调用路由表业务层的新增方法
		return shuttleService.updateStationById(shuttleId,station,index);
	}
}
