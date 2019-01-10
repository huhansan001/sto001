package com.yidu.bean.wsq;

import java.io.Serializable;
import org.springframework.stereotype.Component;
/**
 *  描述:业务表的实体类
 * @author 文思晴
 * @date2018年12月22日下午3:54:56
 */
@Component
public class StoWorkOrder_wsq implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int workerNumber; //工单号
	private String employeeNumber;  //员工编号
	private String orderNumber;  //订单号
	private String serviceHours;  //收件时间
	public int getWorkerNumber() {
		return workerNumber;
	}
	public void setWorkerNumber(int workerNumber) {
		this.workerNumber = workerNumber;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getServiceHours() {
		return serviceHours;
	}
	public void setServiceHours(String serviceHours) {
		this.serviceHours = serviceHours;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "StoWorkOrder_wsq [workerNumber=" + workerNumber + ", employeeNumber=" + employeeNumber + ", orderNumber="
				+ orderNumber + ", serviceHours=" + serviceHours + "]";
	}
	
	
	
}