package com.yidu.bean.xwc;

import java.io.Serializable;

import org.springframework.stereotype.Component;


/**
 * 
 *�������û���ַ���ĵ�ʵ����
 * @author ������
 *@date2018��12��24������9:01:01
 */
@Component
public class UserAddress_xwc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userAddressId;//�û���ַ����id
	private String userName;//����
	private String userPhone;//�ֻ�����
	private String landlineNumbers;//������
	private String fullAddress;//��ϸ��ַ
	private String category;//���
	private String sendName;//�ļ�������
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
