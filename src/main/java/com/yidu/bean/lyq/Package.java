package com.yidu.bean.lyq;

import java.io.Serializable;
import org.springframework.stereotype.Component;
@Component
/**
 * 
 * 功能：实体层
 * @author 刘永琪
 * @date 2018年12月22日
 * @version V1.0
 */
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;
	private String packageId ;//包裹id
	private int workOrderNumber;//工单号
	private String nameOfSender ;//寄件人姓名
	private String senderAddress ;//寄件人地址 	
	private String fullAddressOfSender ;//寄件人详细地址
	private String sendersTelephoneNumber ;//寄件人电话
	private String addresseeName ;//收件人姓名
	private String direction ;//收件人地址
	private String addresseeDetailedAddress ;//收件人详细地址
	private String addresseeTelephoneNumber ;//收件人电话
	private int theParcelWeighs ;//包裹重量
	private int freight ;//运费
	private String auditStatus ;//审核状态
	private String waybillNumber ;//运单号
	private String remark ; //备注
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public int getWorkOrderNumber() {
		return workOrderNumber;
	}
	public void setWorkOrderNumber(int workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}
	public String getNameOfSender() {
		return nameOfSender;
	}
	public void setNameOfSender(String nameOfSender) {
		this.nameOfSender = nameOfSender;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getFullAddressOfSender() {
		return fullAddressOfSender;
	}
	public void setFullAddressOfSender(String fullAddressOfSender) {
		this.fullAddressOfSender = fullAddressOfSender;
	}
	public String getSendersTelephoneNumber() {
		return sendersTelephoneNumber;
	}
	public void setSendersTelephoneNumber(String sendersTelephoneNumber) {
		this.sendersTelephoneNumber = sendersTelephoneNumber;
	}
	public String getAddresseeName() {
		return addresseeName;
	}
	public void setAddresseeName(String addresseeName) {
		this.addresseeName = addresseeName;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getAddresseeDetailedAddress() {
		return addresseeDetailedAddress;
	}
	public void setAddresseeDetailedAddress(String addresseeDetailedAddress) {
		this.addresseeDetailedAddress = addresseeDetailedAddress;
	}
	public String getAddresseeTelephoneNumber() {
		return addresseeTelephoneNumber;
	}
	public void setAddresseeTelephoneNumber(String addresseeTelephoneNumber) {
		this.addresseeTelephoneNumber = addresseeTelephoneNumber;
	}
	public int getTheParcelWeighs() {
		return theParcelWeighs;
	}
	public void setTheParcelWeighs(int theParcelWeighs) {
		this.theParcelWeighs = theParcelWeighs;
	}
	public int getFreight() {
		return freight;
	}
	public void setFreight(int freight) {
		this.freight = freight;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getWaybillNumber() {
		return waybillNumber;
	}
	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", workOrderNumber=" + workOrderNumber + ", nameOfSender="
				+ nameOfSender + ", senderAddress=" + senderAddress + ", fullAddressOfSender=" + fullAddressOfSender
				+ ", sendersTelephoneNumber=" + sendersTelephoneNumber + ", addresseeName=" + addresseeName
				+ ", direction=" + direction + ", addresseeDetailedAddress=" + addresseeDetailedAddress
				+ ", addresseeTelephoneNumber=" + addresseeTelephoneNumber + ", theParcelWeighs=" + theParcelWeighs
				+ ", freight=" + freight + ", auditStatus=" + auditStatus + ", waybillNumber=" + waybillNumber
				+ ", remark=" + remark + "]";
	}
	
}
