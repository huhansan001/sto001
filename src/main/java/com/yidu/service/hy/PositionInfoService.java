package com.yidu.service.hy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hy.Positions;
import com.yidu.dao.hy.PositionInfoMapper;

@Service
public class PositionInfoService {

	@Autowired
	private PositionInfoMapper positionInfoMapper;
	/**
	   * 功能：查询所有角色并且将对应员工编号的角色放在前面
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public List<Positions> selectPosiIdByEmpNo(int empNo) {
		List<Positions> posiList=positionInfoMapper.selectPositionsAll();
		List<Positions> newPosiList=new ArrayList<Positions>();
		boolean result=false;
		for (Positions p : posiList) {
			//判断员工当前的角色
			if(p.getPosiName().equals(positionInfoMapper.selectPosiIdByEmpNo(empNo))&&!positionInfoMapper.selectPosiIdByEmpNo(empNo).equals(null)) {
				newPosiList.add(p);
			}else {
				result=true;
			}
		}
		if(result==true) {
			result=false;
			Positions positions=new Positions();
			positions.setPosiName("无职位");
			newPosiList.add(positions);
		}
		for (Positions p : posiList) {
			if(!p.getPosiName().equals(positionInfoMapper.selectPosiIdByEmpNo(empNo))) {
				newPosiList.add(p);
			}
		}
		return newPosiList;
	}
	/**
	   * 功能：根据员工编号修改角色
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void updatePositionByEmpNo(int posiId,int empNo) {
		positionInfoMapper.updatePositionByEmpNo(posiId, empNo);
	}
	/**
	   * 功能：查询所有角色(包含分页)
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public Map<String, Object> selectPositionsAllPaging(int page,int row){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",positionInfoMapper.selectPositionsAll().size());
		map.put("data",positionInfoMapper.selectPositionsAllPaging((page-1)*row, row));
		return map;
	}
	/**
	   * 功能：查询所有角色
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public List<Positions> selectPositionsAll(){
		return positionInfoMapper.selectPositionsAll();
	}
	/**
	   * 功能：新增角色中间表
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void insertPositioninfo(int empNo,int posiId) {
		positionInfoMapper.insertPositioninfo(empNo, posiId);
	}
	/**
	   * 功能：根据职位id修改职位信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void updatePositions(Positions positions) {
		positionInfoMapper.updatePositions(positions);
	}
	/**
	   * 功能：根据职位id修改职位信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void deletePositionById(int posiId) {
		positionInfoMapper.deletePositionById(posiId);
	}
	/**
	 * 功能：新增员工职位
	 * @param ：
	 * @return ：
	 * @throws
	 */
	public void insertPositions(Positions positions) {
		positionInfoMapper.insertPositions(positions);
	}
	/*public static void main(String[] args) {
		String str="甘肃省/甘南藏族自治州/临潭县";
		//System.out.println(str.lastIndexOf("/"));
		//System.out.println(str.substring(str.lastIndexOf("/")+1));
		//包含
		//System.out.println(str.contains("临潭县"));
	}*/
}
