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
 * 描述： 角色控制层
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月12日 上午11:17:24 
 *
 */
@Controller
public class PositionsAction {
	
	@Autowired
	private PositionInfoService positionInfoService;//职位业务类
	@Autowired
	private MenuAndInfoService menuAndInfoService;//菜单业务类
	/**
	   * 功能：查询所有角色并将所有信息放入表格
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@RequestMapping("selectPositionsAlljsp.action")
	public @ResponseBody Map<String, Object> selectPositionsAll(int page,int row) {
		return positionInfoService.selectPositionsAllPaging(page, row);
	}
	/**
	   * 功能：根据职位id修改职位信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@RequestMapping("updatePositions.action")
	public void updatePositions(Positions positions) {
		positionInfoService.updatePositions(positions);
	}
	/**
	   * 功能：根据职位id删除职位信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@RequestMapping("deletePositionById.action")
	public void deletePositionById(int posiId) {
		positionInfoService.deletePositionById(posiId);
	}
	/**
	 * 功能：新增员工职位
	 * @param ：
	 * @return ：
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
