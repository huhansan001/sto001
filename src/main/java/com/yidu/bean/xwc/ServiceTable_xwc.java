package com.yidu.bean.xwc;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 *������ҵ����ʵ����
 * @author ������
 *@date2018��12��22������3:54:56
 */
@Component
public class ServiceTable_xwc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderNumber;//������
	private int ordersId;//�ռ���id
	private String orderStatus;//����״̬
	private String remarks;//��ע
	private String customer;//�ͷ�
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getordersId() {
		return ordersId;
	}
	public void setordersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "ServiceTable [orderNumber=" + orderNumber + ", ordersId=" + ordersId + ", orderStatus="
				+ orderStatus + ", remarks=" + remarks + ", customer=" + customer + "]";
	}
	
	
	

}
