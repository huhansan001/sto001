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
	 * @Explain: 查询全部省并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有省
	 */
	@Select("select * from province_hcy")
	public List<Province> pageProvince();
	@Select("select * from province_hcy limit #{page},#{rows}")
	public List<Province> pageProvinces(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: 新增省份
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	@Insert("insert into province_hcy(provinceName,proNumber,cityId) values(#{provinceName},#{proNumber},#{cityId})")
	public int insProvince(Province Province);
	/**
	 * 
	 * @Explain: 根据id删除省份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	@Delete("delete from province_hcy where proId=#{0}")
	public int delProvince(int proId);
	/**
	 * 
	 * @Explain: 根据id修改省份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE province_hcy SET provinceName=#{provinceName},proNumber=#{proNumber},cityId=#{cityId} WHERE proId=#{proId}")
	public int upProvince(Province Province);
}
