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
	private int comPackageId;
	private int shuttleId;//�೵id
	private String packageId;//����id
	private String dotName;//��վ��ַ������id��
	
	public int getComPackageId() {
		return comPackageId;
	}
	public void setComPackageId(int comPackageId) {
		this.comPackageId = comPackageId;
	}
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
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	public ComPackage(int shuttleId, String packageId, String dotName) {
		super();
		this.shuttleId = shuttleId;
		this.packageId = packageId;
		this.dotName = dotName;
	}
	
	public ComPackage() {
		super();
	}
	@Override
	public String toString() {
		return "ComPackage [comPackageId=" + comPackageId + ", shuttleId=" + shuttleId + ", packageId=" + packageId
				+ ", dotName=" + dotName + "]";
	}
	
}
