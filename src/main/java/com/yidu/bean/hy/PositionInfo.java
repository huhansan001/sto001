package com.yidu.bean.hy;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 描述： 员工职位分配实体类
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月6日 上午10:44:25 
 *
 */
@Component
public class PositionInfo implements Serializable{

	/** 
	 * @Fields serialVersionUID ：TODO
	 */
	private static final long serialVersionUID = 1L;

	private int posiInfoId;//职位id
	private int empNo;//员工编号
	private int posiId;//职位id
	
	public int getPosiInfoId() {
		return posiInfoId;
	}
	public void setPosiInfoId(int posiInfoId) {
		this.posiInfoId = posiInfoId;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getPosiId() {
		return posiId;
	}
	public void setPosiId(int posiId) {
		this.posiId = posiId;
	}
	@Override
	public String toString() {
		return "PositionInfo [posiInfoId=" + posiInfoId + ", empNo=" + empNo + ", posiId=" + posiId + "]";
	}
}
