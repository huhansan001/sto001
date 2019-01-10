package com.yidu.bean.wsq;

import java.io.Serializable;
import org.springframework.stereotype.Component;
/**
 *  ����:ҵ����ʵ����
 * @author ��˼��
 * @date2018��12��22������3:54:56
 */
@Component
public class StoWorkOrder_wsq implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int workerNumber; //������
	private String employeeNumber;  //Ա�����
	private String orderNumber;  //������
	private String serviceHours;  //�ռ�ʱ��
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