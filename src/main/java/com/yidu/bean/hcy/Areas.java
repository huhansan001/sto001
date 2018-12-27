package com.yidu.bean.hcy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: ȫ����������
 * @author: ������
 * @date 2018��12��11�� ����11:41:28
 * @version 1.0
 */
@Component
public class Areas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int areasId;//����ID
	private String areasName;//��������
	private String locals;//��ϸ��ַ
	private int shuttleId;//�೵id
	private String staffId;//Ա�����
	
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public int getShuttleId() {
		return shuttleId;
	}
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	public int getAreasId() {
		return areasId;
	}
	public void setAreasId(int areasId) {
		this.areasId = areasId;
	}
	public String getAreasName() {
		return areasName;
	}
	public void setAreasName(String areasName) {
		this.areasName = areasName;
	}
	public String getLocals() {
		return locals;
	}
	public void setLocals(String locals) {
		this.locals = locals;
	}
	@Override
	public String toString() {
		return "Areas [areasId=" + areasId + ", areasName=" + areasName + ", locals=" + locals + ", shuttleId="
				+ shuttleId + ", staffId=" + staffId + "]";
	}

}
