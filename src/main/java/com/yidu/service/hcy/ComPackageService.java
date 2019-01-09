package com.yidu.service.hcy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.ComPackage;
import com.yidu.bean.hcy.Shuttle;
import com.yidu.bean.lyq.Package;
import com.yidu.dao.hcy.ComPackageMapper;
import com.yidu.dao.hcy.ShuttleMapper;
import com.yidu.dao.lyq.PackageMapper;
/**
 * 
 * @Description: 合包业务层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:41:37
 * @version 1.0
 */
@Service
public class ComPackageService {
	@Autowired
	private ComPackageMapper comPackageMapper;
	@Autowired
	private PackageMapper packageMapper;//佩奇的包裹 班车
	@Autowired 
	private ShuttleMapper shuttleMapper;
	/**
	 * 
	 * @Explain: 查询全部合包并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
	 */
	public Map<String, Object> pageComPackage(String page,String limit) {
		Map<String, Object> comPackageMap = new HashMap<String, Object>();
		comPackageMap.put("code", 0);
		comPackageMap.put("msg", "");
		comPackageMap.put("count", comPackageMapper.pageComPackage().size());
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(limit);
		comPackageMap.put("data", comPackageMapper.pageComPackages((pages-1)*rows,rows));
		return comPackageMap;
	}
	/**
	 * 
	 * @Explain: 新增合包
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	public int insComPackage(ComPackage comPackage) {
		return comPackageMapper.insComPackage(comPackage);
	}
	/**
	 * 
	 * @Explain: 根据id删除合包
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	public int delComPackage(String shuttleId) {
		String[] id=shuttleId.split("-");
		int delcomShuttleId=0;
		for (int i = 0; i < id.length; i++) {
			comPackageMapper.delComPackage(Integer.parseInt(id[i]));
		}
		return delcomShuttleId;
	}
	/**
	 * 
	 * @Explain: 根据id修改合包
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	public int upComPackage(ComPackage comPackage) {
		return comPackageMapper.upComPackage(comPackage);
	}
	/**
	 * 
	 * @Explain  一键合包
	 * @param ids 包裹id
	 * @return
	 */
	public  String comPackage(String ids){
		String [] packageid=ids.split("-");
		//声明的到所有包裹的集合
		List<List<Package>> list=new ArrayList<List<Package>>();
		//得到所有包裹
		for (int i = 0; i < packageid.length; i++) {
			list.add(packageMapper.packageAll(packageid[i]));
		}
		//得到所有班车
		List<Shuttle> pageShuttle = shuttleMapper.pageShuttle();
		//循环每一辆班车
		for (Shuttle shuttle : pageShuttle) {
			//System.out.println("班车号："+shuttle.getGoodsNo());
			//得到班车到站地址的站点
			String [] stand = shuttle.getStand().split("-");
			//循环每辆班车的到站地址
			for (int i = 0; i < stand.length; i++) {
				//循环所有包裹
				for (int j = 0; j < list.size(); j++) {
					//每个包裹的到站地址
					String [] direction=list.get(j).get(0).getDirection().split("/");
					//判断班车的到站地点是否和包裹的区县地址一致
					if(stand[i].equals(direction[2])) {
						//生成合包
						ComPackage comPackage = new ComPackage(shuttle.getShuttleId(), list.get(j).get(0).getPackageId(), stand[i]);
						//调用合包持久层新增合包
						comPackageMapper.insComPackage(comPackage);
						//删除已经合包的包裹
						list.remove(j);
					}
				}
			}
		}
		return "合包成功";
	}
}
