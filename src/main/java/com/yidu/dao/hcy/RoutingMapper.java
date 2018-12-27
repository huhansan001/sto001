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
	@Delete("delete from routing_hcy where shuttleId=#{0}")
	public int delRouting(int shuttleId);
	/**
	 * 
	 * @Explain: ����id�޸İ೵
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE routing_hcy SET routingState=#{routingState},shuStaTime=#{shuStaTime} WHERE shuttleId=#{shuttleId}")
	public int upRouting(Routing routing);
}
