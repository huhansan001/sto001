package com.yidu.bean.hcy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: 路游状态实力类
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:35:03
 * @version 1.0
 */
@Component
public class Routing implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shuttleId;//班车id
	private String routingState;//路由状态
	private String shuStaTime;//状态更新的时间
	public int getShuttleId() {
		return shuttleId;
	}
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	public String getRoutingState() {
		return routingState;
	}
	public void setRoutingState(String routingState) {
		this.routingState = routingState;
	}
	public String getShuStaTime() {
		return shuStaTime;
	}
	public void setShuStaTime(String shuStaTime) {
		this.shuStaTime = shuStaTime;
	}
	@Override
	public String toString() {
		return "Routing [shuttleId=" + shuttleId + ", routingState=" + routingState + ", shuStaTime=" + shuStaTime
				+ "]";
	}
	
	
}
