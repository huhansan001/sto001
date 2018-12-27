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
 * @Description: ·�ɿ��Ʋ�
 * @author: ������
 * @date 2018��12��20�� ����1:38:26
 * @version 1.0
 */
@Controller
public class RoutingAction {
	@Autowired 
	private RoutingService routingService;
	/**
	 * 
	 * @Explain:��ҳ�ϰ�
	 * @date 2018��12��17������11:04:54
	 * @return �ϰ���ҳ����
	 */
	@RequestMapping("pageRouting.action")
	public @ResponseBody Map<String, Object> pageRouting(String page,String limit){
		return routingService.pageRouting(page,limit);
	}
	
	/**
	 * 
	 * @Explain:�����ϰ�
	 * @date 2018��12��17������11:34:38
	 * @param Province
	 * @return
	 */
	@RequestMapping("insRouting.action")
	public @ResponseBody int insShuttle(@ModelAttribute Routing routing){
		return routingService.insRouting(routing);
	}
	/**
	 * 
	 * @Explain:ɾ���ϰ�
	 * @date 2018��12��17������11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delRouting.action")
	public @ResponseBody int delShuttle(String shuttleId){
		return routingService.delShuttle(shuttleId);
	}
	/**
	 * 
	 * @Explain:�޸ĺϰ�
	 * @date 2018��12��17������11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upRouting.action")
	public @ResponseBody int upShuttle(Routing routing){
		return routingService.upRouting(routing);
	}
}
