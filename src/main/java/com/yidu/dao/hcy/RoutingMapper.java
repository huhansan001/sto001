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
 * @Description: 路由持久层
 * @author: 胡春毅
 * @date 2018年12月20日 下午1:43:31
 * @version 1.0
 */
@Repository
public interface RoutingMapper {
	/**
	 * 
	 * @Explain: 查询全部班车并分页
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回所有市
	 */
	@Select("select * from routing_hcy")
	public List<Routing> pageRouting();
	@Select("select * from routing_hcy limit #{page},#{rows}")
	public List<Routing> pageRoutings(@Param("page") int page,@Param("rows") int rows);
	/**
	 * 
	 * @Explain: 新增班车
	 * @date 2018年12月17日上午10:03:54
	 * @return 返回是否新增成功
	 */
	@Insert("insert into routing_hcy(routingState,shuStaTime) values(#{routingState},#{shuStaTime})")
	public int insRouting(Routing routing);
	/**
	 * 
	 * @Explain: 根据id删除班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否删除成功
	 */
	@Delete("delete from routing_hcy where id=#{0}")
	public int delRouting(int shuttleId);
	/**
	 * 
	 * @Explain: 根据id修改班车
	 * @date 2018年12月17日上午10:03:54
	 * @return  返回是否修改成功
	 */
	@Update("UPDATE routing_hcy SET shuttleId=#{shuttleId},routingState=#{routingState},shuStaTime=#{shuStaTime} WHERE id=${id}")
	public int upRouting(Routing routing);
	
	/**
	 * 
	 * function:新增路由表数据
	 * name :Quiet
	 * @param routing 路由表数据对象
	 * @return
	 * @date 2019年1月9日下午3:53:47
	 */
	@Insert("INSERT INTO routing_hcy(shuttleId,routingState,shuStaTime) VALUES(#{shuttleId},#{routingState},#{shuStaTime})")
	public int insertRouting(Routing routing);
}
