package com.yidu.bean.hy;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 描述： 员工实体类
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月6日 上午10:43:43 
 *
 */
@Component
public class StoEmp implements Serializable{

	/** 
	 * @Fields serialVersionUID ：TODO
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int empNo;//员工编号
	private String empName;//员工姓名
	private String empDate;//入职日期
	private String posi_account;//账户
	private String posi_pass;//账户
	private String empState;//员工状态
	private String empImg;//头像
	private int districtId;//网点id
	
	public String getEmpImg() {
		return empImg;
	}
	public void setEmpImg(String empImg) {
		this.empImg = empImg;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public String getEmpState() {
		return empState;
	}
	public void setEmpState(String empState) {
		this.empState = empState;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDate() {
		return empDate;
	}
	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}
	public String getPosi_account() {
		return posi_account;
	}
	public void setPosi_account(String posi_account) {
		this.posi_account = posi_account;
	}
	public String getPosi_pass() {
		return posi_pass;
	}
	public void setPosi_pass(String posi_pass) {
		this.posi_pass = posi_pass;
	}
	@Override
	public String toString() {
		return "StoEmp [empNo=" + empNo + ", empName=" + empName + ", empDate=" + empDate + ", posi_account="
				+ posi_account + ", posi_pass=" + posi_pass + ", empState=" + empState + ", empImg=" + empImg
				+ ", districtId=" + districtId + "]";
	}
}
