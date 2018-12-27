package com.yidu.service.hcy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.City;
import com.yidu.dao.hcy.CityMapper;

@Service
public class CityService {
	@Autowired
	private CityMapper cityMapper;
	/**
	 * 
	 * @Explain: 查询全部市并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
	 */
	public Map<String, Object> pageCity(String page,String limit){
		Map<String, Object> cityMap = new HashMap<String, Object>();
		cityMap.put("code", 0);
		cityMap.put("msg", "");
		cityMap.put("count", cityMapper.pageCity().size());
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(limit);
		cityMap.put("data", cityMapper.pageCitys((pages-1)*rows,rows));
		return cityMap;
		
	};
	/**
	 * 
	 * @Explain: 新增市份
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	public int insCity(City city) {
		return cityMapper.insCity(city);
	}
	/**
	 * 
	 * @Explain: 根据id删除省份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	public int delCity(String cityId) {
		String[] id=cityId.split("-");
		int delProvince=0;
		for (int i = 0; i < id.length; i++) {
			cityMapper.delCity(Integer.parseInt(id[i]));
		}
		return delProvince;
	}
	/**
	 * 
	 * @Explain: 根据id修改市份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	public int upCity(City city) {
		return cityMapper.upCity(city);
	}
}
