package com.yidu.controller.hcy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @Description: 后台业务控制层
 * @author: 胡春毅
 * @date 2018年12月22日 上午11:23:46
 * @version 1.0
 */
@Controller
public class IntegRationAction {
	
	@RequestMapping("IntegRation.action")
	public @ResponseBody String IntegRation() {
		//Integer.parseInt(s)
		return "测试";
	}
}
