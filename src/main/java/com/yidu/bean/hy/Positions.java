package com.yidu.bean.hy;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 描述： 职位实体类
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月6日 上午10:48:41 
 *
 */
@Component
public class Positions implements Serializable{

	/** 
	 * @Fields serialVersionUID ：TODO
	 */
	private static final long serialVersionUID = 1L;

	private int posiId;//职位id
	private String posiName;//职位名称
	private int salary;//职位薪水
	
	public int getPosiId() {
		return posiId;
	}
	public void setPosiId(int posiId) {
		this.posiId = posiId;
	}
	public String getPosiName() {
		return posiName;
	}
	public void setPosiName(String posiName) {
		this.posiName = posiName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Positions [posiId=" + posiId + ", posiName=" + posiName + ", salary=" + salary + "]";
	}
}
