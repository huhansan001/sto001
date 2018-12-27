package com.yidu.bean.hcy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: 全国省份网点数量
 * @author: 胡春毅
 * @date 2018年12月11日 上午11:38:15
 * @version 1.0
 */
@Component
public class Province  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int proId;//省级Id
	private String provinceName;//省级名称
	private int proNumber;//省级网点数量
	private int cityId;//市级ID
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public int getProNumber() {
		return proNumber;
	}
	public void setProNumber(int proNumber) {
		this.proNumber = proNumber;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	@Override
	public String toString() {
		return "Province [proId=" + proId + ", provinceName=" + provinceName + ", proNumber=" + proNumber + ", cityId="
				+ cityId + "]";
	}
	
}
