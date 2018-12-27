package com.yidu.service.hcy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.Shuttle;
import com.yidu.dao.hcy.ShuttleMapper;
/**
 * 
 * @Description: �೵ҵ���
 * @author: ������
 * @date 2018��12��20�� ����1:45:58
 * @version 1.0
 */
@Service
public class ShuttleService {
	@Autowired
	private ShuttleMapper shuttleMapper;
	/**
	 * 
	 * @Explain: ��ѯȫ���೵����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
	 */
	public Map<String, Object> pageShuttle(String page,String limit) {
		Map<String, Object> comPackageMap = new HashMap<String, Object>();
		comPackageMap.put("code", 0);
		comPackageMap.put("msg", "");
		comPackageMap.put("count", shuttleMapper.pageShuttle().size());
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(limit);
		List<Shuttle> list=shuttleMapper.pageShuttles((pages-1)*rows,rows);
		List<Shuttle> lists=new ArrayList<Shuttle>();
		for (Shuttle s : list) {
			String[] lli=s.getStation().split("-");
			String[] llii=s.getStand().split("-");
			List<String> listss=new ArrayList<String>();
			List<String> listsss=new ArrayList<String>();
			for (int i = 0; i < lli.length; i++) {
				listss.add(lli[i]);
				listsss.add(llii[i]);
			}
			//�õ�ÿһվ
			lists.add(new Shuttle(s.getShuttleId(),s.getGoodsNo(),s.getShuttleState(),listss,listsss));
		}
		comPackageMap.put("data", lists);
		return comPackageMap;
	}
	/**
	 * 
	 * @Explain: �����೵
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	public int insShuttle(Shuttle shuttle) {
		shuttle.setStation("δ����-δ����-δ����-δ����");
		shuttle.setShuttleState("δ����");
		return shuttleMapper.insShuttle(shuttle);
	}
	/**
	 * 
	 * @Explain: ����idɾ���೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
	 */
	public int delShuttle(String shuttleId) {
		String[] id=shuttleId.split("-");
		int delcomPackageId=0;
		for (int i = 0; i < id.length; i++) {
			shuttleMapper.delShuttle(Integer.parseInt(id[i]));
		}
		return delcomPackageId;
	}
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public int upShuttle(Shuttle shuttle) {
		return shuttleMapper.upShuttle(shuttle);
	}
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public void updateStation(int shuttleId) {
		shuttleMapper.updateStation(shuttleId);
	}
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public String updateStationById(int shuttleId,String station,int index) {
		List<Shuttle> shuttleList=shuttleMapper.selectShuttleById(shuttleId);
		String [] array=null;
		for (Shuttle shuttle : shuttleList) {
			array=shuttle.getStation().split("-");
		}
		String result="";
		for (int i = 0; i < array.length; i++) {
				if(array[i].equals(station)) {
					if(i==0) {
						result+=""+station+":�ѹ�վ-";
					}else {
						if(i==1) {
							result+=""+station+":�ѹ�վ-";
						}else {
							result+=""+station+":�ѹ�վ";
						}
					}
				}else{
					if(i==0||i==1) {
						result+=array[i]+"-";
					}else{
						if(i!=2) {
							result+="-"+array[i];
						}else {
							result+=array[i];
						}
					}
				}
			}
		//�޸�
		if(index==3) {
			shuttleMapper.upState(shuttleId,"�ѵ�վ");
		}
		shuttleMapper.updateStationById(shuttleId,result);
		return "ok";
	}
}
