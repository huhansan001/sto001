package com.yidu.dao.hcy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hcy.Routing;
/**
 * 
 * @Description: ·�ɳ־ò�
 * @author: ������
 * @date 2018��12��20�� ����1:43:31
 * @version 1.0
 */
@Repository
public interface RoutingMapper {
	/**
	 * 
	 * @Explain: ��ѯȫ���೵����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
	 */
	@Select("select * from routing_hcy")
	public List<Routing> pageRouting();
	@Select("select * from routing_hcy limit #{page},#{rows}")
	public List<Routing> pageRoutings(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: �����೵
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	@Insert("insert into routing_hcy(routingState,shuStaTime) values(#{routingState},#{shuStaTime})")
	public int insRouting(Routing routing);
	/**
	 * 
	 * @Explain: ����idɾ���೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
	 */
	@Delete("delete from routing_hcy where id=#{0}")
	public int delRouting(int shuttleId);
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE routing_hcy SET shuttleId=#{shuttleId},routingState=#{routingState},shuStaTime=#{shuStaTime} WHERE id=${id}")
	public int upRouting(Routing routing);
	
	/**
	 * 
	 * function:����·�ɱ�����
	 * name :Quiet
	 * @param routing ·�ɱ����ݶ���
	 * @return
	 * @date 2019��1��9������3:53:47
	 */
	@Insert("INSERT INTO routing_hcy(shuttleId,routingState,shuStaTime) VALUES(#{shuttleId},#{routingState},#{shuStaTime})")
	public int insertRouting(Routing routing);
}
