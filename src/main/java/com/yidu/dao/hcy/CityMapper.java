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
	 * @Explain: 查询全部市并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
	 */
	@Select("select * from city_hcy")
	public List<City> pageCity();
	@Select("select * from city_hcy limit #{page},#{rows}")
	public List<City> pageCitys(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: 新增市份
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	@Insert("insert into city_hcy(cityName,cityNumber,areasId) values(#{cityName},#{cityNumber},#{areasId})")
	public int insCity(City city);
	/**
	 * 
	 * @Explain: 根据id删除省份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	@Delete("delete from city_hcy where cityId=#{0}")
	public int delCity(int cityId);
	/**
	 * 
	 * @Explain: 根据id修改市份
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE city_hcy SET cityName=#{cityName},cityNumber=#{cityNumber},areasId=#{areasId} WHERE cityId=#{cityId}")
	public int upCity(City city);
}
