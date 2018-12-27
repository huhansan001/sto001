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
	 * @Explain: ��ѯȫ��ʡ����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ��������ʡ
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
	 * @Explain: ����ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	public int insProvince(Province Province) {
		return provinceDao.insProvince(Province);
	};
	/**
	 * 
	 * @Explain: ����idɾ��ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
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
	 * @Explain: ����id�޸�ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public int upProvince(Province Province) {
		return provinceDao.upProvince(Province);
	};
}
