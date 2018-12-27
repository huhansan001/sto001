package com.yidu.service.hcy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.Areas;
import com.yidu.dao.hcy.AreasMapper;

@Service
public class AreasService {
	@Autowired
	private AreasMapper areasMapper;
	/**
	 * 
	 * @Explain: 查询全部市并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有区
	 */
	public Map<String, Object> pageAreas(String page,String limit){
		Map<String, Object> areasMap = new HashMap<String, Object>();
		areasMap.put("code", 0);
		areasMap.put("msg", "");
		areasMap.put("count", areasMapper.pageAreas().size());
		int pages=Integer.parseInt(page);
		int rows=Integer.parseInt(limit);
		areasMap.put("data", areasMapper.pageAreass((pages-1)*rows,rows));
		return areasMap;
	};
	/**
	 * 
	 * @Explain: 新增区县
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	public int insAreas(Areas areas) {
		return areasMapper.insAreas(areas);
	}
	/**
	 * 
	 * @Explain: 根据id删除区县
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	public int delAreas(String areasId) {
		String[] id=areasId.split("-");
		int delAreas=0;
		for (int i = 0; i < id.length; i++) {
			delAreas=areasMapper.delAreas(Integer.parseInt(id[i]));
		}
		return delAreas;
	}
	/**
	 * 
	 * @Explain: 根据id修改区县
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	public int upAreas(Areas areas) {
		return areasMapper.upAreas(areas);
	}
}
