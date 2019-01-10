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
 * @Description: �೵���Ʋ�
 * @author: ������
 * @date 2018��12��20�� ����1:39:01
 * @version 1.0
 */
@Controller
public class ShuttleAction {
	@Autowired 
	private ShuttleService shuttleService;

	//����·�ɱ�����ݶ���
	@Autowired
	private Routing routing;
	//����·�ɱ��ҵ���
	@Autowired
	private RoutingService routingService;
	/**
	 * 
	 * @Explain:��ҳ�ϰ�
	 * @date 2018��12��17������11:04:54
	 * @return �ϰ���ҳ����
	 */
	@RequestMapping("pageShuttle.action")
	public @ResponseBody Map<String, Object> pageShuttle(String page,String limit,HttpSession session){
		return shuttleService.pageShuttle(page,limit);
	}

	/**
	 * 
	 * @Explain:�����ϰ�
	 * @date 2018��12��17������11:34:38
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
	 * @Explain:ɾ���ϰ�
	 * @date 2018��12��17������11:35:07
	 * @param proId
	 * @return
	 */
	@RequestMapping("delShuttle.action")
	public @ResponseBody int delShuttle(String shuttleId){
		return shuttleService.delShuttle(shuttleId);
	}
	/**
	 * 
	 * @Explain:�޸ĺϰ�
	 * @date 2018��12��17������11:35:19
	 * @param Province
	 * @return
	 */
	@RequestMapping("upShuttle.action")
	public @ResponseBody int upShuttle(Shuttle shuttle){
		return shuttleService.upShuttle(shuttle);
	}
	/**
	 * ���ܣ��������
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("depart.action")
	public @ResponseBody String depart(@RequestParam(value="shuttleId[]") Integer[] shuttleId) {
		List<Integer> list= Arrays.asList(shuttleId);
		for (Integer i : list) {
			//��·�ɱ�İ೵id��ֵ
			routing.setShuttleId(i);
			//��·�ɱ��·��״̬��ֵ
			routing.setRoutingState("ת�������ѷ���");
			//����·�ɱ�ҵ������������
			routingService.insertRouting(routing);

			shuttleService.updateStation(i);
		}
		return "ok";
	}
	/**
	 * ���ܣ������һվ���޸������б��ֵ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("nextStie.action")
	public @ResponseBody String nextStie(int shuttleId,String station,int index) {
		//��·�ɱ�İ೵id��ֵ
		routing.setShuttleId(shuttleId);
		//��·�ɱ��·��״̬��ֵ
		routing.setRoutingState(station+"�ѷ���");
		//����·�ɱ�ҵ������������
		return shuttleService.updateStationById(shuttleId,station,index);
	}
}
