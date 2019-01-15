package com.yidu.controller.xwc;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.bean.xwc.ServiceTable_xwc;
import com.yidu.service.xwc.ServiceTableService_xwc;
/**
 * 
 *������ҵ���Ŀ��Ʋ�
 * @author ������
 *@date2018��12��22������4:11:09
 */
@Controller
public class ServiceTableAction_xwc {

	@Autowired
	//ҵ���
	private ServiceTableService_xwc serviceTableService_xwc;
	
	/**
	 * 
	 *���ܣ���ѯ����
	 * @return
	 */
	@RequestMapping("selectServiceTableAll.action")
	public @ResponseBody Map<String, Object> selectServiceTableAll(String page,String limit,String id,String select,HttpServletRequest request){
		//����ҵ���ķ���
		return serviceTableService_xwc.selectServiceTableAll(page,limit,id,select);
	}
	
	/**
	 * 
	 *���ܣ�����
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("insertServiceTable.action")
	public @ResponseBody String insertServiceTable(@ModelAttribute  ServiceTable_xwc serviceTable_xwc ) {
		//����ҵ���ķ���
		serviceTableService_xwc.insertServiceTable(serviceTable_xwc);
		return "ok";
	}
	/**
	 * 
	 *���ܣ�ɾ��
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("deleteServiceTable.action")
	public @ResponseBody String deleteServiceTable(@ModelAttribute  ServiceTable_xwc serviceTable_xwc) {
		//����ҵ���ķ���
		serviceTableService_xwc.deleteServiceTable(serviceTable_xwc);
		return "ok";
	}
	/**
	 * 
	 *���ܣ�ɾ��
	 * @param serviceTable_xwc
	 * @return
	 */
	@RequestMapping("updateServiceTable.action")
	public @ResponseBody String updateServiceTable(@ModelAttribute  ServiceTable_xwc serviceTable_xwc) {
		//����ҵ���ķ���
		serviceTableService_xwc.updateServiceTable(serviceTable_xwc);
		return "ok";
	}
	
	
	/**
	 * 
	 *���ܣ���ѯ����
	 * @return
	 */
	@RequestMapping("selectServiceTableCourier.action")
	public  void selectServiceTableCourier(HttpServletRequest request,HttpServletResponse response){
		//����ҵ���ķ���
		request.getSession().setAttribute("empName", serviceTableService_xwc.selectServiceTableCourier());
		try {
			response.sendRedirect("SeviceTable_xwc.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return  new ModelAndView("SeviceTable_xwc.jsp");
	}
}
