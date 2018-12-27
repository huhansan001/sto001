package com.yidu.service.hcy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.Routing;
import com.yidu.dao.hcy.RoutingMapper;
/**
 * 
 * @Description: 路由业务层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:44:01
 * @version 1.0
 */
@Service
public class RoutingService {
	@Autowired
	private RoutingMapper routingMapper;
	/**
	 * 
	 * @Explain: 查询全部班车并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
	 */
	public Map<String, Object> pageRouting(String page,String limit) {
		Map<String, Object> comPackageMap = new HashMap<String, Object>();
		comPackageMap.put("code", 0);
		comPackageMap.put("msg", "");
		comPackageMap.put("count", routingMapper.pageRouting().size());
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(limit);
		comPackageMap.put("data", routingMapper.pageRoutings((pages-1)*rows,rows));
		return comPackageMap;
	}
	/**
	 * 
	 * @Explain: 新增班车
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	public int insRouting(Routing routing) {
		return routingMapper.insRouting(routing);
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
			routingMapper.delRouting(Integer.parseInt(id[i]));
		}
		return delcomPackageId;
	}
	/**
	 * 
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	public int upRouting(Routing routing) {
		return routingMapper.upRouting(routing);
	}
}
