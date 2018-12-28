package com.yidu.bean.lyq;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Distribute implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String employee;
private String	indent;
private String waybill;
private int sender;
private int recipients;
private int county;
private String address;
private String number;
private String shippingState;
public String getEmployee() {
	return employee;
}
public void setEmployee(String employee) {
	this.employee = employee;
}
public String getIndent() {
	return indent;
}
public void setIndent(String indent) {
	this.indent = indent;
}
public String getWaybill() {
	return waybill;
}
public void setWaybill(String waybill) {
	this.waybill = waybill;
}
public int getSender() {
	return sender;
}
public void setSender(int sender) {
	this.sender = sender;
}
public int getRecipients() {
	return recipients;
}
public void setRecipients(int recipients) {
	this.recipients = recipients;
}
public int getCounty() {
	return county;
}
public void setCounty(int county) {
	this.county = county;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getShippingState() {
	return shippingState;
}
public void setShippingState(String shippingState) {
	this.shippingState = shippingState;
}
@Override
public String toString() {
	return "distribute [employee=" + employee + ", indent=" + indent + ", waybill=" + waybill + ", sender=" + sender
			+ ", recipients=" + recipients + ", county=" + county + ", address=" + address + ", number=" + number
			+ ", shippingState=" + shippingState + "]";
}

}
