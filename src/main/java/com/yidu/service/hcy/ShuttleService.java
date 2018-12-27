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
 * @Description: 班车业务层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:45:58
 * @version 1.0
 */
@Service
public class ShuttleService {
	@Autowired
	private ShuttleMapper shuttleMapper;
	/**
	 * 
	 * @Explain: 查询全部班车并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
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
			//得到每一站
			lists.add(new Shuttle(s.getShuttleId(),s.getGoodsNo(),s.getShuttleState(),listss,listsss));
		}
		comPackageMap.put("data", lists);
		return comPackageMap;
	}
	/**
	 * 
	 * @Explain: 新增班车
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	public int insShuttle(Shuttle shuttle) {
		shuttle.setStation("未发车-未发车-未发车-未发车");
		shuttle.setShuttleState("未发车");
		return shuttleMapper.insShuttle(shuttle);
	}
	/**
	 * 
	 * @Explain: 根据id删除班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
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
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	public int upShuttle(Shuttle shuttle) {
		return shuttleMapper.upShuttle(shuttle);
	}
	/**
	 * 
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	public void updateStation(int shuttleId) {
		shuttleMapper.updateStation(shuttleId);
	}
	/**
	 * 
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
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
						result+=""+station+":已过站-";
					}else {
						if(i==1) {
							result+=""+station+":已过站-";
						}else {
							result+=""+station+":已过站";
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
		//修改
		if(index==3) {
			shuttleMapper.upState(shuttleId,"已到站");
		}
		shuttleMapper.updateStationById(shuttleId,result);
		return "ok";
	}
}
