package com.yidu.bean.zj;
import java.io.Serializable;
import org.springframework.stereotype.Component;
@SuppressWarnings("serial")
@Component
public class UserReg implements Serializable{
	private String urealNameId;//ID
	private String userName;//姓名
	private String userSex;//性别
	private String userNation;//民族
	private String userBirthday;//生日
	private  String userIDnumber;//身份�?
	private String homeAddress;//地址
	private String detailedAddress;//国家
	private String phoneNumber;//电话
	private String userPass;//密码
	public String getUserSex() {
		return userSex;
	}
	public String getUrealNameId() {
		return urealNameId;
	}
	public void setUrealNameId(String urealNameId) {
		this.urealNameId = urealNameId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserNation() {
		return userNation;
	}
	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserIDnumber() {
		return userIDnumber;
	}
	public void setUserIDnumber(String userIDnumber) {
		this.userIDnumber = userIDnumber;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	@Override
	public String toString() {
		return "UserReg [urealNameId=" + urealNameId + ", userName=" + userName + ", userSex=" + userSex
				+ ", userNation=" + userNation + ", userBirthday=" + userBirthday + ", userIDnumber=" + userIDnumber
				+ ", homeAddress=" + homeAddress + ", detailedAddress=" + detailedAddress + ", phoneNumber="
				+ phoneNumber + ", userPass=" + userPass + "]";
	}
}
