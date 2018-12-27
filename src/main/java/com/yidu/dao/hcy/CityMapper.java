package com.yidu.dao.hcy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hcy.City;

@Repository
public interface CityMapper {
	/**
	 * 
	 * @Explain: ��ѯȫ���в���ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
	 */
	@Select("select * from city_hcy")
	public List<City> pageCity();
	@Select("select * from city_hcy limit #{page},#{rows}")
	public List<City> pageCitys(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: �����з�
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	@Insert("insert into city_hcy(cityName,cityNumber,areasId) values(#{cityName},#{cityNumber},#{areasId})")
	public int insCity(City city);
	/**
	 * 
	 * @Explain: ����idɾ��ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
	 */
	@Delete("delete from city_hcy where cityId=#{0}")
	public int delCity(int cityId);
	/**
	 * 
	 * @Explain: ����id�޸��з�
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE city_hcy SET cityName=#{cityName},cityNumber=#{cityNumber},areasId=#{areasId} WHERE cityId=#{cityId}")
	public int upCity(City city);
}
