package com.yidu.service.hcy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.hcy.Routing;
import com.yidu.dao.hcy.RoutingMapper;
/**
 * 
 * @Description: ·��ҵ���
 * @author: ������
 * @date 2018��12��20�� ����1:44:01
 * @version 1.0
 */
@Service
public class RoutingService {
	@Autowired
	private RoutingMapper routingMapper;
	/**
	 * 
	 * @Explain: ��ѯȫ���೵����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
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
	 * @Explain: �����೵
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	public int insRouting(Routing routing) {
		return routingMapper.insRouting(routing);
	}
	/**
	 * 
	 * @Explain: ����idɾ���೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
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
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	public int upRouting(Routing routing) {
		return routingMapper.upRouting(routing);
	}
}
