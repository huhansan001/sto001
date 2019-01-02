package com.yidu.controller.lyq;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.lyq.Distribute;
import com.yidu.service.lyq.DistributeService;

@Controller
public class DistributeAction {
@Autowired private DistributeService distributeService;

@RequestMapping("selectdistributeAll.action")
public @ResponseBody Map<String, Object> selectdistributeAll(String page,String limit){
	return distributeService.selectdistributeAll(page,limit) ;
	
}
@RequestMapping("insertDistribute.action")
public @ResponseBody int  insertdistribute(@ModelAttribute Distribute distribute){
	return distributeService.insertdistribute(distribute);
}
@RequestMapping("updatedistribute.action")
public @ResponseBody  String updatedistribute(@ModelAttribute Distribute distribute) {
	distributeService.updatedistribute(distribute);
	return "ok";
	
}
@RequestMapping("deletedistribute.action")
public @ResponseBody  String  dletedistribute(@ModelAttribute Distribute distribute) {
	distributeService.deletedistribute(distribute);
	return "ok";
	
}
}
