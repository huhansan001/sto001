package com.yidu.service.hcy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.Province;
import com.yidu.dao.hcy.ProvinceMapper;

@Service
public class ProvinceService {
	@Autowired
	private ProvinceMapper provinceDao;
	
	/**
	 * 
	 * @Explain: 查询全部省并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有省
	 */
	public Map<String, Object> pageProvince(String page,String limit){
		Map<String, Object> provinceMap = new HashMap<String, Object>();
		provinceMap.put("code", 0);
		provinceMap.put("msg", "");
		provinceMap.put("count", provinceDao.pageProvince().size());
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(limit);
		provinceMap.put("data", provinceDao.pageProvinces((pages-1)*rows,rows));
		return provinceMap;
	};
	/**
	 * 
	 * @Explain: 新增省份
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	public int insProvince(Province Province) {
		return provinceDao.insProvince(Province);
	};
	/**
	 * 
	 * @Explain: 根据id删除省份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	public int delProvince(String proId) {
		String[] id=proId.split("-");
		int delProvince=0;
		for (int i = 0; i < id.length; i++) {
			 delProvince = provinceDao.delProvince(Integer.parseInt(id[i]));
		}
		return delProvince;
	};
	/**
	 * 
	 * @Explain: 根据id修改省份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	public int upProvince(Province Province) {
		return provinceDao.upProvince(Province);
	};
}
