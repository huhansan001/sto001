package com.yidu.service.hcy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.ComPackage;
import com.yidu.dao.hcy.ComPackageMapper;
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
}
