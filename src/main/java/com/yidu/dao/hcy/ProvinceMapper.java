package com.yidu.dao.hcy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hcy.Province;


@Repository
public interface ProvinceMapper {
	/**
	 * 
	 * @Explain: ��ѯȫ��ʡ����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ��������ʡ
	 */
	@Select("select * from province_hcy")
	public List<Province> pageProvince();
	@Select("select * from province_hcy limit #{page},#{rows}")
	public List<Province> pageProvinces(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: ����ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	@Insert("insert into province_hcy(provinceName,proNumber,cityId) values(#{provinceName},#{proNumber},#{cityId})")
	public int insProvince(Province Province);
	/**
	 * 
	 * @Explain: ����idɾ��ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
	 */
	@Delete("delete from province_hcy where proId=#{0}")
	public int delProvince(int proId);
	/**
	 * 
	 * @Explain: ����id�޸�ʡ��
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE province_hcy SET provinceName=#{provinceName},proNumber=#{proNumber},cityId=#{cityId} WHERE proId=#{proId}")
	public int upProvince(Province Province);
}
