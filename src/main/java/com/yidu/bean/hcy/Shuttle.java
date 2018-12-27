package com.yidu.bean.hcy;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: �೵ʵ����
 * @author: ������
 * @date 2018��12��20�� ����1:32:23
 * @version 1.0
 */
@Component
public class Shuttle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shuttleId;//�೵id
	private String goodsNo;//�೵
	private String station;//��վ(�����б�)
	private String stand;
	private String shuttleState;//�೵״̬
	private List<String> stationList;//��վ(�����б�)
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	private List<String> standList;//��վ(�����б�)
	
	public List<String> getStandList() {
		return standList;
	}
	public void setStandList(List<String> standList) {
		this.standList = standList;
	}
	public String getStand() {
		return stand;
	}
	public void setStand(String stand) {
		this.stand = stand;
	}
	
	
	public Shuttle(int shuttleId,String goodsNo, String shuttleState, List<String> stationList, List<String> standList) {
		super();
		this.shuttleId = shuttleId;
		this.goodsNo=goodsNo;
		this.shuttleState = shuttleState;
		this.stationList = stationList;
		this.standList = standList;
	}
	public Shuttle(int shuttleId,String goodsNo, String station, String nextStation, String shuttleState) {
		super();
		this.shuttleId = shuttleId;
		this.goodsNo=goodsNo;
		this.station = station;
		this.shuttleState = shuttleState;
	}
	public Shuttle() {
		super();
	}
	public List<String> getStationList() {
		return stationList;
	}
	public void setStationList(List<String> stationList) {
		this.stationList = stationList;
	}
	public int getShuttleId() {
		return shuttleId;
	}
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getShuttleState() {
		return shuttleState;
	}
	
	public void setShuttleState(String shuttleState) {
		this.shuttleState = shuttleState;
	}
	@Override
	public String toString() {
		return "Shuttle [shuttleId=" + shuttleId + ", goodsNo=" + goodsNo + ", station=" + station + ", stand=" + stand
				+ ", shuttleState=" + shuttleState + ", stationList=" + stationList + ", standList=" + standList + "]";
	}
	
}
