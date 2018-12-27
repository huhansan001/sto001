package com.yidu.dao.hcy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hcy.Shuttle;
/**
 * 
 * @Description: �೵�־ò�
 * @author: ������
 * @date 2018��12��20�� ����1:45:20
 * @version 1.0
 */
@Repository
public interface ShuttleMapper {
	/**
	 * 
	 * @Explain: ��ѯȫ���೵����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
	 */
	@Select("select * from shuttle_hcy")
	public List<Shuttle> pageShuttle();
	@Select("select * from shuttle_hcy limit #{page},#{rows}")
	public List<Shuttle> pageShuttles(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: �����೵
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	@Insert("INSERT INTO shuttle_hcy(goodsNo,station,stand,shuttleState) VALUES(#{goodsNo},#{station},#{stand},#{shuttleState})")
	public int insShuttle(Shuttle shuttle);
	/**
	 * 
	 * @Explain: ����idɾ���೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
	 */
	@Delete("delete from shuttle_hcy where shuttleId=#{0}")
	public int delShuttle(int shuttleId);
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE shuttle_hcy SET station=#{station},shuttleState=#{shuttleState} WHERE shuttleId=#{shuttleId}")
	public int upShuttle(Shuttle shuttle);
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE shuttle_hcy SET station=stand,shuttleState='�ѷ���' WHERE shuttleId=#{shuttleId}")
	public void updateStation(@Param("shuttleId")int shuttleId);
	/**
	 * ���ܣ�����id��ѯ��һվ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("select * from shuttle_hcy where shuttleId=#{shuttleId}")
	public List<Shuttle> selectShuttleById(@Param("shuttleId") int shuttleId);
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE shuttle_hcy SET station=#{station} WHERE shuttleId=#{shuttleId}")
	public void updateStationById(@Param("shuttleId")int shuttleId,@Param("station")String station);
	/**
	 * 
	 * @Explain: �޸��ѵ�վ
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE shuttle_hcy SET shuttleState=#{shuttleState} WHERE shuttleId=#{shuttleId}")
	public void upState(@Param("shuttleId")int shuttleId,@Param("shuttleState")String shuttleState);
}
