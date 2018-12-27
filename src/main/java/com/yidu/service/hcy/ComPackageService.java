package com.yidu.service.hcy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.ComPackage;
import com.yidu.dao.hcy.ComPackageMapper;
/**
 * 
 * @Description: �ϰ�ҵ���
 * @author: ������
 * @date 2018��12��20�� ����1:41:37
 * @version 1.0
 */
@Service
public class ComPackageService {
	@Autowired
	private ComPackageMapper comPackageMapper;
	/**
	 * 
	 * @Explain: ��ѯȫ���ϰ�����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
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
	 * @Explain: �����ϰ�
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	public int insComPackage(ComPackage comPackage) {
		return comPackageMapper.insComPackage(comPackage);
	}
	/**
	 * 
	 * @Explain: ����idɾ���ϰ�
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
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
	 * @Explain: ����id�޸ĺϰ�
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public int upComPackage(ComPackage comPackage) {
		return comPackageMapper.upComPackage(comPackage);
	}
}
