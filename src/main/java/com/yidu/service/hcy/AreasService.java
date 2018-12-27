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
	 * @Explain: ��ѯȫ���в���ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
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
	 * @Explain: ��������
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	public int insAreas(Areas areas) {
		return areasMapper.insAreas(areas);
	}
	/**
	 * 
	 * @Explain: ����idɾ������
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
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
	 * @Explain: ����id�޸�����
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public int upAreas(Areas areas) {
		return areasMapper.upAreas(areas);
	}
}
