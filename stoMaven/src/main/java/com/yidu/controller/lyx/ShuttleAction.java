package com.yidu.controller.lyx;

import java.util.Map;

import org.apache.catalina.ha.backend.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.service.lyx.ShuttleService;

@Controller
public class ShuttleAction {
	@Autowired
	private ShuttleService senderService;
	
	@RequestMapping("selectSenderAll.action")
	public @ResponseBody Map<String, Object> selectSenderAll(){
		Map<String, Object> map = senderService.selectdistributeAll();
		System.out.println(map);
		return map;
	}
	
	@RequestMapping("insertSender.action")
	public @ResponseBody String insertSender(@ModelAttribute Sender sender){
		System.out.println(sender.toString());
		return "ok";
	}
	@RequestMapping("updateSender.action")
	public void updateSender(@ModelAttribute Sender sender){
		System.out.println(sender.toString());
	}
	public static void main(String[] args) {
		new ShuttleAction().selectSenderAll();
	}
}
