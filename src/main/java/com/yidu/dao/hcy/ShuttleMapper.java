package com.yidu.dao.hcy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hcy.Shuttle;
/**
 * 
 * @Description: 班车持久层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:45:20
 * @version 1.0
 */
@Repository
public interface ShuttleMapper {
	/**
	 * 
	 * @Explain: 查询全部班车并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
	 */
	@Select("select * from shuttle_hcy")
	public List<Shuttle> pageShuttle();
	@Select("select * from shuttle_hcy limit #{page},#{rows}")
	public List<Shuttle> pageShuttles(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: 新增班车
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	@Insert("INSERT INTO shuttle_hcy(goodsNo,station,stand,shuttleState) VALUES(#{goodsNo},#{station},#{stand},#{shuttleState})")
	public int insShuttle(Shuttle shuttle);
	/**
	 * 
	 * @Explain: 根据id删除班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	@Delete("delete from shuttle_hcy where shuttleId=#{0}")
	public int delShuttle(int shuttleId);
	/**
	 * 
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE shuttle_hcy SET station=#{station},shuttleState=#{shuttleState} WHERE shuttleId=#{shuttleId}")
	public int upShuttle(Shuttle shuttle);
	/**
	 * 
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE shuttle_hcy SET station=stand,shuttleState='已发车' WHERE shuttleId=#{shuttleId}")
	public void updateStation(@Param("shuttleId")int shuttleId);
	/**
	 * 功能：根据id查询下一站
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("select * from shuttle_hcy where shuttleId=#{shuttleId}")
	public List<Shuttle> selectShuttleById(@Param("shuttleId") int shuttleId);
	/**
	 * 
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE shuttle_hcy SET station=#{station} WHERE shuttleId=#{shuttleId}")
	public void updateStationById(@Param("shuttleId")int shuttleId,@Param("station")String station);
	/**
	 * 
	 * @Explain: 修改已到站
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE shuttle_hcy SET shuttleState=#{shuttleState} WHERE shuttleId=#{shuttleId}")
	public void upState(@Param("shuttleId")int shuttleId,@Param("shuttleState")String shuttleState);
}
