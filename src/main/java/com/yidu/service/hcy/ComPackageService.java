package com.yidu.service.hcy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.hcy.ComPackage;
import com.yidu.bean.hcy.Shuttle;
import com.yidu.bean.lyq.Package;
import com.yidu.dao.hcy.ComPackageMapper;
import com.yidu.dao.hcy.ShuttleMapper;
import com.yidu.dao.lyq.PackageMapper;
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
	@Autowired
	private PackageMapper packageMapper;//����İ��� �೵
	@Autowired 
	private ShuttleMapper shuttleMapper;
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
	/**
	 * 
	 * @Explain  һ���ϰ�
	 * @param ids ����id
	 * @return
	 */
	public  String comPackage(String ids){
		String [] packageid=ids.split("-");
		//�����ĵ����а����ļ���
		List<List<Package>> list=new ArrayList<List<Package>>();
		//�õ����а���
		for (int i = 0; i < packageid.length; i++) {
			list.add(packageMapper.packageAll(packageid[i]));
		}
		//�õ����а೵
		List<Shuttle> pageShuttle = shuttleMapper.pageShuttle();
		//ѭ��ÿһ���೵
		for (Shuttle shuttle : pageShuttle) {
			//System.out.println("�೵�ţ�"+shuttle.getGoodsNo());
			//�õ��೵��վ��ַ��վ��
			String [] stand = shuttle.getStand().split("-");
			//ѭ��ÿ���೵�ĵ�վ��ַ
			for (int i = 0; i < stand.length; i++) {
				//ѭ�����а���
				for (int j = 0; j < list.size(); j++) {
					//ÿ�������ĵ�վ��ַ
					String [] direction=list.get(j).get(0).getDirection().split("/");
					//�жϰ೵�ĵ�վ�ص��Ƿ�Ͱ��������ص�ַһ��
					if(stand[i].equals(direction[2])) {
						//���ɺϰ�
						ComPackage comPackage = new ComPackage(shuttle.getShuttleId(), list.get(j).get(0).getPackageId(), stand[i]);
						//���úϰ��־ò������ϰ�
						comPackageMapper.insComPackage(comPackage);
						//ɾ���Ѿ��ϰ��İ���
						list.remove(j);
					}
				}
			}
		}
		return "�ϰ��ɹ�";
	}
}
