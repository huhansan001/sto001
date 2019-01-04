package com.yidu.bean.lyx;

import org.springframework.stereotype.Component;

/**
 * 
 * @author 2018
 *
 */
@Component
public class ShuttleWatch {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int carNumber;//班车编号
	private int driverNumber;//司机编号
	private int state;//班车状态
	private int departureTime;//发车时间
	private int arrivalTime;//到站时间
	private int startingPoint;//发车起点
	private int Terminus;//班车终点
	private int dotId;//班车所属网点
	@Override
	public String toString() {
		return "ShuttleWatch [carNumber=" + carNumber + ", driverNumber=" + driverNumber + ", state=" + state
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", startingPoint="
				+ startingPoint + ", Terminus=" + Terminus + ", dotId=" + dotId + "]";
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public int getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(int driverNumber) {
		this.driverNumber = driverNumber;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}
	public int getTerminus() {
		return Terminus;
	}
	public void setTerminus(int terminus) {
		Terminus = terminus;
	}
	public int getDotId() {
		return dotId;
	}
	public void setDotId(int dotId) {
		this.dotId = dotId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
