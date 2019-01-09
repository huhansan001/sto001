package com.yidu.controller.hy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yidu.bean.hy.Menu;
import com.yidu.bean.hy.Positions;
import com.yidu.bean.hy.StoEmp;
import com.yidu.service.hy.PositionInfoService;
import com.yidu.service.hy.StoEmpService;
/**
 * ������ Ա����̨Ȩ�޹�����Ʋ�
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��7�� ����1:33:45 
 *
 */
@Controller
public class EmpAdminAction {

	
	@Autowired
	private StoEmpService stoEmpService;
	@Autowired
	private PositionInfoService positionInfoService;
	
	/**
	 * ���ܣ�Ա����¼
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("stoLogin.action")
	public @ResponseBody List<StoEmp> selectEmpNoByNameAndPass(String account,String pass) {
		return stoEmpService.selectEmpNoByNameAndPass(account, pass);
	}
	/**
	 * ���ܣ������˺ź������ѯԱ����ţ��ӵ�¼��ת��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("selectMenuId.action")
	public String selectMenuIdByEmpNo(int empNo,String empName,Model model) {
		List<Menu> menuList=stoEmpService.selectMenuByPid(empNo);	
		model.addAttribute("empName",empName);
		model.addAttribute("empNo",empNo);
		model.addAttribute("menuList",menuList);
		return "stoShow";
	}
	/**
	   * ���ܣ���ѯ����Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("selectEmpAll.action")
	public @ResponseBody Map<String, Object>selectEmpAll(int page,int row){
		return stoEmpService.selectStoEmpAll(page,row);
	}
	/**
	   * ���ܣ�����Ա������޸�Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("updateStoEmpByEmpNo.action")
	public void updateStoEmpByEmpNo(@ModelAttribute StoEmp stoEmp){
		stoEmpService.updateStoEmpByEmpNo(stoEmp);
	}
	/**
	   * ���ܣ�����Ա������޸�Ա��״̬
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("updateStateByEmpNo.action")
	public void updateStateByEmpNo(int empNo,String empState) {
		stoEmpService.updateStateByEmpNo(empNo, empState);
	}
	/**
	   * ���ܣ����ݶ��Ա���������ɾ��Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("deleteBatchStoEmp.action")
	public void deleteBatchStoEmp(@RequestParam(value="empNo[]") Integer[] empNo){
		List<Integer> list= Arrays.asList(empNo);
		for (Integer i : list) {
			stoEmpService.deleteBatchStoEmp(i);
		}
	}
	/**
	   * ���ܣ�����Ա�����ɾ��Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("deleteStoEmp.action")
	public void deleteStoEmp(int empNo){
		stoEmpService.deleteBatchStoEmp(empNo);
	}
	/**
	   * ���ܣ�����Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("insertStoEmp.action")
	public @ResponseBody String insertStoEmp(StoEmp stoEmp,int empPosition) {
		stoEmpService.insertStoEmp(stoEmp);
		positionInfoService.insertPositioninfo(stoEmp.getEmpNo(),empPosition);
		return "ok";
	}
	/**
	   * ���ܣ�����Ա����Ų�ѯ��Ӧ�Ľ�ɫ���������н�ɫ��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping(value="lookPosition.action",produces = {"application/json;charset=utf-8"})
	public @ResponseBody List<Positions> lookPosition(int empNo) {
		return positionInfoService.selectPosiIdByEmpNo(empNo);
	}
	/**
	   * ���ܣ�����Ա������޸Ľ�ɫ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("updatePositionByEmpNo.action")
	public @ResponseBody String updatePositionByEmpNo(int posiId,int empNo) {
		positionInfoService.updatePositionByEmpNo(posiId, empNo);
		return "ok";
	}
	/**
	   * ���ܣ���ѯ���н�ɫ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping(value="selectPositionsAll.action",produces = {"application/json;charset=utf-8"})
	public @ResponseBody List<Positions> selectPositionsAll() {
		return positionInfoService.selectPositionsAll();
	}
	/**
	   * ���ܣ�����ͷ��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("changeImg.action")
	public @ResponseBody Map<String,Object> changeImg(HttpServletRequest request,MultipartFile file,int empNo) throws IOException {
		String myFileName = file.getOriginalFilename();// �ļ�ԭ����
		 stoEmpService.updateEmpImgByEmpNo(myFileName, empNo);
		InputStream input=file.getInputStream();
		 OutputStream out=new FileOutputStream("C:\\Users\\Administrator\\git\\sto001\\src\\main\\webapp\\imgs\\"+myFileName);
		 byte[] bytes=new byte[1024];
		 int len=-1;
		while((len=input.read(bytes))!=-1) {
			out.write(bytes,0, len);
		}
		out.close();
		input.close();
		Map<String,Object> map=new HashMap<String, Object>();
		Map<String,Object> maps=new HashMap<String, Object>();
		map.put("src","www.baidu.com");
		map.put("code","0");
		map.put("msg","");
		map.put("data",maps);
		return map;
	}
}
