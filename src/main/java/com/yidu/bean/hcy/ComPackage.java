package com.yidu.bean.hcy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: �ϰ�ʵ����
 * @author: ������
 * @date 2018��12��20�� ����1:29:46
 * @version 1.0
 */
@Component
public class ComPackage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shuttleId;//�೵id
	private int packageId;//����id
	private String dotName;//��վ��ַ������id��
	public int getShuttleId() {
		return shuttleId;
	}
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	public String getDotName() {
		return dotName;
	}
	public void setDotName(String dotName) {
		this.dotName = dotName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	@Override
	public String toString() {
		return "ComPackage [shuttleId=" + shuttleId + ", packageId=" + packageId + ", dotName=" + dotName + "]";
	}
	
}
