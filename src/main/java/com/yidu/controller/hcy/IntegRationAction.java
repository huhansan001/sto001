package com.yidu.controller.hcy;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void  IntegRation(HttpServletRequest  request,HttpServletResponse response) {
		/*System.out.println(12321321);
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("http://localhost:8080/stoMaven/FrontEnd/STO.jsp");
		return mav;*/
		//request.getSession().setAttribute("list", "123");
		//System.out.println(12321321);
		//try {
			//response.sendRedirect("http://localhost:8080/stoMaven/FrontEnd/admin/query.jsp");
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		//Integer.parseInt(s)
	}
}
