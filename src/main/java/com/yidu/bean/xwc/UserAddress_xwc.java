package com.yidu.bean.xwc;

import java.io.Serializable;

import org.springframework.stereotype.Component;


/**
 * 
 *描述：用户地址中心的实体类
 * @author 夏望城
 *@date2018年12月24日上午9:01:01
 */
@Component
public class UserAddress_xwc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userAddressId;//用户地址中心id
	private String userName;//姓名
	private String userPhone;//手机号码
	private String landlineNumbers;//座机号
	private String fullAddress;//详细地址
	private String category;//类别
	private String sendName;//寄件人姓名
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getLandlineNumbers() {
		return landlineNumbers;
	}
	public void setLandlineNumbers(String landlineNumbers) {
		this.landlineNumbers = landlineNumbers;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public int getUserAddressId() {
		return userAddressId;
	}
	public void setUserAddressId(int userAddressId) {
		this.userAddressId = userAddressId;
	}
	@Override
	public String toString() {
		return "UserAddress_xwc [userAddressId=" + userAddressId + ", userName=" + userName + ", userPhone=" + userPhone
				+ ", landlineNumbers=" + landlineNumbers + ", fullAddress=" + fullAddress + ", category=" + category
				+ ", sendName=" + sendName + "]";
	}
	
	
}
