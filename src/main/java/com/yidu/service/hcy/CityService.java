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
	 * @Explain: ��ѯȫ���в���ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
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
	 * @Explain: �����з�
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	public int insCity(City city) {
		return cityMapper.insCity(city);
	}
	/**
	 * 
	 * @Explain: ����idɾ��ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
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
	 * @Explain: ����id�޸��з�
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public int upCity(City city) {
		return cityMapper.upCity(city);
	}
}
