package com.yidu.dao.hcy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hcy.ComPackage;
/**
 * 
 * @Description: �ϰ��־ò�
 * @author: ������
 * @date 2018��12��20�� ����1:41:51
 * @version 1.0
 */
@Repository
public interface ComPackageMapper {
	/**
	 * 
	 * @Explain: ��ѯȫ���ϰ�����ҳ
	 * @date 2018��12��17������10:03:54
	 * @return ����������
	 */
	@Select("select * from comPackage_hcy")
	public List<ComPackage> pageComPackage();
	@Select("select * from comPackage_hcy limit #{page},#{rows}")
	public List<ComPackage> pageComPackages(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: �����ϰ�
	 * @date 2018��12��17������10:03:54
	 * @return �����Ƿ������ɹ�
	 */
	@Insert("insert into comPackage_hcy(shuttleId,packageId,dotName) values(#{shuttleId},#{packageId},#{dotName})")
	public int insComPackage(ComPackage comPackage);
	/**
	 * 
	 * @Explain: ����idɾ���ϰ�
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ�ɾ���ɹ�
	 */
	@Delete("delete from comPackage_hcy where shuttleId=#{0}")
	public int delComPackage(int comPackageId);
	/**
	 * 
	 * @Explain: ����id�޸ĺϰ�
	 * @date 2018��12��17������10:03:54
	 * @return  �����Ƿ��޸ĳɹ�
	 */
	@Update("UPDATE comPackage_hcy SET packageId=#{packageId},dotName=#{dotName} WHERE shuttleId=#{shuttleId}")
	public int upComPackage(ComPackage comPackage);
}
