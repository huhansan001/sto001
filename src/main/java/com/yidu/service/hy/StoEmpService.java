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
 * ������ Ա����Ϣ��ҵ���
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��7�� ����1:38:49 
 *
 */
@Service
public class StoEmpService {

	
	@Autowired
	private StoEmpMapper stoEmpMapper;//Ա����Ϣ��dao��
	/**
	 * ���ܣ������˺ź������ѯԱ����ţ���¼��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public List<StoEmp> selectEmpNoByNameAndPass(String account,String pass) {
		return stoEmpMapper.selectEmpNoByNameAndPass(account, pass);
	}
	
	/**
	   * ���ܣ�����pid��ѯ�˵�����
	 * @param ��
	 * @return ��
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
	   * ���ܣ���ѯ����Ա����Ϣ
	 * @param ��
	 * @return ��
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
	   * ���ܣ�����Ա������޸�Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void updateStoEmpByEmpNo(StoEmp stoEmp) {
		stoEmpMapper.updateStoEmpByEmpNo(stoEmp);
	}
	/**
	   * ���ܣ�����Ա������޸�Ա��״̬
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void updateStateByEmpNo(int empNo,String empState) {
		stoEmpMapper.updateStateByEmpNo(empNo, empState);
	}
	/**
	   * ���ܣ����ݶ��Ա���������ɾ��Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void deleteBatchStoEmp(int empNo) {
		stoEmpMapper.deleteBatchStoEmp(empNo);
	}
	/**
	   * ���ܣ�����Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void insertStoEmp(StoEmp stoEmp) {
		stoEmpMapper.insertStoEmp(stoEmp);
	}
	/**
	   * ���ܣ�����Ա������޸�ͷ���ַ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	public void updateEmpImgByEmpNo(String empImg,int empNo) {
		stoEmpMapper.updateEmpImgByEmpNo(empImg, empNo);
	}
}
