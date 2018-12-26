package com.yidu.service.hy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.hy.Menu;
import com.yidu.bean.hy.StoEmp;
import com.yidu.dao.hy.StoEmpMapper;
/**
 * 描述： 员工信息的业务层
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月7日 下午1:38:49 
 *
 */
@Service
public class StoEmpService {

	
	@Autowired
	private StoEmpMapper stoEmpMapper;//员工信息的dao层
	/**
	 * 功能：根据账号和密码查询员工编号（登录）
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public List<StoEmp> selectEmpNoByNameAndPass(String account,String pass) {
		return stoEmpMapper.selectEmpNoByNameAndPass(account, pass);
	}
	
	/**
	   * 功能：根据pid查询菜单功能
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public List<Menu> selectMenuByPid(int empNo){
		List<Menu> menuList=stoEmpMapper.selectMenuByMenuId(empNo);
		List<Menu> oenList=new ArrayList<Menu>();
		List<Menu> twoList=null;
		for (Menu menu : menuList) {
			if(menu.getPid().equals("root")) {
				twoList=new ArrayList<Menu>();
				Menu me=new Menu(menu.getMenuId(), menu.getTitle(),menu.getUrl(), menu.getPid(), twoList);
				oenList.add(me);
			}else {
				twoList.add(new Menu(menu.getMenuId(), menu.getTitle(),menu.getUrl(), menu.getPid()));
			}
		}
		return oenList;
	}
	/**
	   * 功能：查询所有员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public Map<String, Object> selectStoEmpAll(int page,int row){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",stoEmpMapper.selectStoEmpAll().size());
		map.put("data",stoEmpMapper.selectStoEmpAllPaging((page-1)*row, row));
		return map;
	}
	/**
	   * 功能：根据员工编号修改员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void updateStoEmpByEmpNo(StoEmp stoEmp) {
		stoEmpMapper.updateStoEmpByEmpNo(stoEmp);
	}
	/**
	   * 功能：根据员工编号修改员工状态
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void updateStateByEmpNo(int empNo,String empState) {
		stoEmpMapper.updateStateByEmpNo(empNo, empState);
	}
	/**
	   * 功能：根据多个员工编号批量删除员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void deleteBatchStoEmp(int empNo) {
		stoEmpMapper.deleteBatchStoEmp(empNo);
	}
	/**
	   * 功能：新增员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void insertStoEmp(StoEmp stoEmp) {
		stoEmpMapper.insertStoEmp(stoEmp);
	}
	/**
	   * 功能：根据员工编号修改头像地址
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void updateEmpImgByEmpNo(String empImg,int empNo) {
		stoEmpMapper.updateEmpImgByEmpNo(empImg, empNo);
	}
}
