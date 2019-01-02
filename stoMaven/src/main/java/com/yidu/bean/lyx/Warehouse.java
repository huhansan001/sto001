package com.yidu.bean.lyx;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 
 * ���ܣ�ʵ���
 * @author ��Ӿϣ
 * @date 2018��12��22��
 * @version V1.0
 */
@Component
public class Warehouse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String packageId;//����ID
	private String courier; //�ɼ���
	private String whether;//�Ƿ��ɼ�
	private String unloading;//ж����
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public String getWhether() {
		return whether;
	}
	public void setWhether(String whether) {
		this.whether = whether;
	}
	public String getUnloading() {
		return unloading;
	}
	public void setUnloading(String unloading) {
		this.unloading = unloading;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Warehouse [packageId=" + packageId + ", courier=" + courier + ", whether=" + whether + ", unloading="
				+ unloading + "]";
	}

}
	
