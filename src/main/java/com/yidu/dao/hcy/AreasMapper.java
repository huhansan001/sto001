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
	 * @Explain: 查询全部市并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有区
	 */
	@Select("select * from areas_hcy")
	public List<Areas> pageAreas();
	@Select("select * from areas_hcy limit #{page},#{rows}")
	public List<Areas> pageAreass(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: 新增区县
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	@Insert("insert into areas_hcy(areasName,locals,shuttleId,staffId) values(#{areasName},#{locals},#{shuttleId},#{staffId})")
	public int insAreas(Areas areas);
	/**
	 * 
	 * @Explain: 根据id删除区县
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	@Delete("delete from areas_hcy where areasId=#{0}")
	public int delAreas(int AreasId);
	/**
	 * 
	 * @Explain: 根据id修改区县
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE areas_hcy SET areasName=#{areasName},locals=#{locals},shuttleId=#{shuttleId},staffId=#{staffId} WHERE areasId=#{areasId}")
	public int upAreas(Areas areas);
}
