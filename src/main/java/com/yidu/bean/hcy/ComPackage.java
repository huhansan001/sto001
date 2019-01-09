package com.yidu.bean.hcy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: 合包实体类
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:29:46
 * @version 1.0
 */
@Component
public class ComPackage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int comPackageId;
	private int shuttleId;//班车id
	private String packageId;//包裹id
	private String dotName;//到站地址（网点id）
	
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
