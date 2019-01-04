package com.yidu.bean.lyx;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 
 * 功能：实体层
 * @author 李泳希
 * @date 2018年12月22日
 * @version V1.0
 */
@Component
public class Warehouse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String packageId;//包裹ID
	private String courier; //派件人
	private String whether;//是否派件
	private String unloading;//卸货人
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
	
