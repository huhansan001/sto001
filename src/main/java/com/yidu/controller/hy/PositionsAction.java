package com.yidu.controller.hy;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hy.Positions;
import com.yidu.service.hy.MenuAndInfoService;
import com.yidu.service.hy.PositionInfoService;
/**
 * ������ ��ɫ���Ʋ�
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��12�� ����11:17:24 
 *
 */
@Controller
public class PositionsAction {
	
	@Autowired
	private PositionInfoService positionInfoService;//ְλҵ����
	@Autowired
	private MenuAndInfoService menuAndInfoService;//�˵�ҵ����
	/**
	   * ���ܣ���ѯ���н�ɫ����������Ϣ������
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("selectPositionsAlljsp.action")
	public @ResponseBody Map<String, Object> selectPositionsAll(int page,int row) {
		return positionInfoService.selectPositionsAllPaging(page, row);
	}
	/**
	   * ���ܣ�����ְλid�޸�ְλ��Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("updatePositions.action")
	public void updatePositions(Positions positions) {
		positionInfoService.updatePositions(positions);
	}
	/**
	   * ���ܣ�����ְλidɾ��ְλ��Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("deletePositionById.action")
	public void deletePositionById(int posiId) {
		positionInfoService.deletePositionById(posiId);
	}
	/**
	 * ���ܣ�����Ա��ְλ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@RequestMapping("insertPositions.action")
	public @ResponseBody String insertPositioninfo(Positions positions) {
		positionInfoService.insertPositions(positions);
		List<String > list=menuAndInfoService.selectMenuIdByRoot();
		for (String str : list) {
			menuAndInfoService.insertMenuinfoByPidAndMid(positions.getPosiId(),str);
		}
		return "ok";
	}
}
