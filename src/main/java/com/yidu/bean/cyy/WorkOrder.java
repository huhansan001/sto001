package com.yidu.bean.cyy;

import org.springframework.stereotype.Component;

/**
 * ��������������
 * @author Administrator
 *
 */
@Component
public class WorkOrder {
	private int packageId;//����id
	private String empNo;//Ա�����
	private String sendTime;//�ɷ�ʱ��
	private String worksheet;//����״̬
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getWorksheet() {
		return worksheet;
	}
	public void setWorksheet(String worksheet) {
		this.worksheet = worksheet;
	}
	@Override
	public String toString() {
		return "workOrder [packageId=" + packageId + ", empNo=" + empNo + ", sendTime=" + sendTime + ", worksheet="
				+ worksheet + "]";
	}
}
