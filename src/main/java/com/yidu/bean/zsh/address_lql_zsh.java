package com.yidu.bean.zsh;

import java.io.Serializable;


import org.springframework.stereotype.Component;

/**
 * 
 * 描述：用户地址中心（收件）
 * 
 * @author zhoushihao
 * @date2018年12月21日上午8:53:55
 */
@Component
public class address_lql_zsh implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recipientId; // 用户地址收件人ID
	private String recipName; // 姓名
	private String recipMobile; // 手机号码
	private String recipPhone; // 座机号
	private String recipAddress;// 收件人发件地址
	private String recipDetailed; // 详细地址
	private String recipType; // 类别
	private String senderName; // 寄件人姓名
	private String userInfoPhone;// 用户的手机号

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public String getRecipName() {
		return recipName;
	}

	public void setRecipName(String recipName) {
		this.recipName = recipName;
	}

	public String getRecipMobile() {
		return recipMobile;
	}

	public void setRecipMobile(String recipMobile) {
		this.recipMobile = recipMobile;
	}

	public String getRecipPhone() {
		return recipPhone;
	}

	public void setRecipPhone(String recipPhone) {
		this.recipPhone = recipPhone;
	}

	public String getRecipAddress() {
		return recipAddress;
	}

	public void setRecipAddress(String recipAddress) {
		this.recipAddress = recipAddress;
	}

	public String getRecipDetailed() {
		return recipDetailed;
	}

	public void setRecipDetailed(String recipDetailed) {
		this.recipDetailed = recipDetailed;
	}

	public String getRecipType() {
		return recipType;
	}

	public void setRecipType(String recipType) {
		this.recipType = recipType;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getUserInfoPhone() {
		return userInfoPhone;
	}

	public void setUserInfoPhone(String userInfoPhone) {
		this.userInfoPhone = userInfoPhone;
	}

	@Override
	public String toString() {
		return "address_lql_zsh [recipientId=" + recipientId + ", recipName=" + recipName + ", recipMobile="
				+ recipMobile + ", recipPhone=" + recipPhone + ", recipAddress=" + recipAddress + ", recipDetailed="
				+ recipDetailed + ", recipType=" + recipType + ", senderName=" + senderName + ", userInfoPhone="
				+ userInfoPhone + "]";
	}

}
