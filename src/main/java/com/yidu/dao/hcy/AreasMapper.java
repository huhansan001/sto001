package com.yidu.dao.hcy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hcy.Areas;

@Repository
public interface AreasMapper {
	/**
	 * 
	 * @Explain: ��ѯȫ���в���ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
	 */
	@Select("select * from areas_hcy")
	public List<Areas> pageAreas();
	@Select("select * from areas_hcy limit #{page},#{rows}")
	public List<Areas> pageAreass(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: ��������
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	@Insert("insert into areas_hcy(areasName,locals,shuttleId,staffId) values(#{areasName},#{locals},#{shuttleId},#{staffId})")
	public int insAreas(Areas areas);
	/**
	 * 
	 * @Explain: ����idɾ������
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
	 */
	@Delete("delete from areas_hcy where areasId=#{0}")
	public int delAreas(int AreasId);
	/**
	 * 
	 * @Explain: ����id�޸�����
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE areas_hcy SET areasName=#{areasName},locals=#{locals},shuttleId=#{shuttleId},staffId=#{staffId} WHERE areasId=#{areasId}")
	public int upAreas(Areas areas);
}
