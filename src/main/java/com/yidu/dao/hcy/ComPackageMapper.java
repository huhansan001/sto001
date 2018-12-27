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
 * @Description: 合包持久层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:41:51
 * @version 1.0
 */
@Repository
public interface ComPackageMapper {
	/**
	 * 
	 * @Explain: 查询全部合包并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
	 */
	@Select("select * from comPackage_hcy")
	public List<ComPackage> pageComPackage();
	@Select("select * from comPackage_hcy limit #{page},#{rows}")
	public List<ComPackage> pageComPackages(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: 新增合包
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	@Insert("insert into comPackage_hcy(shuttleId,packageId,dotName) values(#{shuttleId},#{packageId},#{dotName})")
	public int insComPackage(ComPackage comPackage);
	/**
	 * 
	 * @Explain: 根据id删除合包
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	@Delete("delete from comPackage_hcy where shuttleId=#{0}")
	public int delComPackage(int comPackageId);
	/**
	 * 
	 * @Explain: 根据id修改合包
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE comPackage_hcy SET packageId=#{packageId},dotName=#{dotName} WHERE shuttleId=#{shuttleId}")
	public int upComPackage(ComPackage comPackage);
}
