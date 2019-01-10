package com.yidu.bean.zsh;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * 描述：用户地址中心（寄件）
 * 
 * @author zhoushihao
 * @date2018年12月21日上午8:46:17
 */
@Component
public class userSender_zsh implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int senderId; // 用户地址寄件人ID
	private String senderName; // 姓名
	private String senderMobile; // 手机号码
	private String senderPhone; // 座机
	private String senderAddress; // 寄件人发件地址
	private String senderDetailed; // 详细地址
	private String senderType; // 类别
	private String userInfoPhone;// 用户的手机号

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderMobile() {
		return senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderDetailed() {
		return senderDetailed;
	}

	public void setSenderDetailed(String senderDetailed) {
		this.senderDetailed = senderDetailed;
	}

	public String getSenderType() {
		return senderType;
	}

	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}

	public String getUserInfoPhone() {
		return userInfoPhone;
	}

	public void setUserInfoPhone(String userInfoPhone) {
		this.userInfoPhone = userInfoPhone;
	}

	@Override
	public String toString() {
		return "userSender_zsh [senderId=" + senderId + ", senderName=" + senderName + ", senderMobile=" + senderMobile
				+ ", senderPhone=" + senderPhone + ", senderAddress=" + senderAddress + ", senderDetailed="
				+ senderDetailed + ", senderType=" + senderType + ", userInfoPhone=" + userInfoPhone + "]";
	}

}
