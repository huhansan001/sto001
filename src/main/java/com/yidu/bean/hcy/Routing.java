package com.yidu.bean.hcy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: ·��״̬ʵ����
 * @author: ������
 * @date 2018��12��20�� ����1:35:03
 * @version 1.0
 */
@Component
public class Routing implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shuttleId;//�೵id
	private String routingState;//·��״̬
	private String shuStaTime;//״̬���µ�ʱ��
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
