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
	   * ���ܣ���ѯ���н�ɫ���ҽ���ӦԱ����ŵĽ�ɫ����ǰ��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public List<Positions> selectPosiIdByEmpNo(int empNo) {
		List<Positions> posiList=positionInfoMapper.selectPositionsAll();
		List<Positions> newPosiList=new ArrayList<Positions>();
		boolean result=false;
		for (Positions p : posiList) {
			//�ж�Ա����ǰ�Ľ�ɫ
			if(p.getPosiName().equals(positionInfoMapper.selectPosiIdByEmpNo(empNo))&&!positionInfoMapper.selectPosiIdByEmpNo(empNo).equals(null)) {
				newPosiList.add(p);
			}else {
				result=true;
			}
		}
		if(result==true) {
			result=false;
			Positions positions=new Positions();
			positions.setPosiName("��ְλ");
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
	   * ���ܣ�����Ա������޸Ľ�ɫ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void updatePositionByEmpNo(int posiId,int empNo) {
		positionInfoMapper.updatePositionByEmpNo(posiId, empNo);
	}
	/**
	   * ���ܣ���ѯ���н�ɫ(������ҳ)
	 * @param ��
	 * @return ��
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
	   * ���ܣ���ѯ���н�ɫ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public List<Positions> selectPositionsAll(){
		return positionInfoMapper.selectPositionsAll();
	}
	/**
	   * ���ܣ�������ɫ�м��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void insertPositioninfo(int empNo,int posiId) {
		positionInfoMapper.insertPositioninfo(empNo, posiId);
	}
	/**
	   * ���ܣ�����ְλid�޸�ְλ��Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void updatePositions(Positions positions) {
		positionInfoMapper.updatePositions(positions);
	}
	/**
	   * ���ܣ�����ְλid�޸�ְλ��Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void deletePositionById(int posiId) {
		positionInfoMapper.deletePositionById(posiId);
	}
	/**
	 * ���ܣ�����Ա��ְλ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void insertPositions(Positions positions) {
		positionInfoMapper.insertPositions(positions);
	}
	/*public static void main(String[] args) {
		String str="����ʡ/���ϲ���������/��̶��";
		//System.out.println(str.lastIndexOf("/"));
		//System.out.println(str.substring(str.lastIndexOf("/")+1));
		//����
		//System.out.println(str.contains("��̶��"));
	}*/
}
