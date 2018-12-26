package com.yidu.dao.hy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hy.Menu;
import com.yidu.bean.hy.Menus;
/**
 * 描述： 员工功能权限持久层
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月14日 下午7:01:01 
 *
 */
@Repository
public interface MenuAndInfoMapper {
	/**
	 * 功能：根据职位id查询功能(连表查询)
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT m1.menuId,m1.title,m1.pid FROM menu m1,menuinfo m2 WHERE m1.menuId=m2.menuId AND m2.posiId=#{posiId} ORDER BY m1.menuId")
	public List<Menu> selectMenuIdByPosiId(@Param("posiId") int posiId);
	/**
	 * 功能：查询所有菜单根据职位id
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT m1.menuId,m1.title,m1.pid FROM menu m1 WHERE m1.menuId NOT IN(SELECT m1.menuId FROM menuinfo m2 WHERE m1.menuId=m2.menuId AND m1.pid !='root' AND m2.posiId=#{posiId}) GROUP BY m1.menuId")
	public List<Menu> selectMenuIdAll(@Param("posiId") int posiId);
	/**
	 * 功能：根据职位id和菜单id删除菜单分配
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Delete("delete from menuinfo where posiId=#{posiId} and menuId=#{menuId}")
	public void deleteMenuinfoByPidAndMid(@Param("posiId") int posiId,@Param("menuId") String menuId);
	/**
	   * 功能：根据职位id新增权限
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Insert("insert into menuinfo (posiId,menuId) values(#{posiId},#{menuId})")
	public void insertMenuinfoByPidAndMid(@Param("posiId") int posiId,@Param("menuId") String menuId);
	/**
	   * 功能：查询所有一级菜单
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT menuId FROM menu WHERE pid='root'")
	public List<String> selectMenuIdByRoot();
	/**
	   * 功能：查询所有菜单功能
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT * FROM menu GROUP BY menuId")
	public List<Menus> selectMenuAll();
	/**
	   * 功能：分页查询
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT * FROM menu GROUP BY menuId LIMIT #{page},#{row}")
	public List<Menus> selectMenuAllPaging(@Param("page")int page,@Param("row")int row);
	/**
	   * 功能：根据id修改菜单
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Update("update menu set title=#{title},url=#{url},pid=#{pid} where menuId=#{menuId}")
	public void updateMenuById(Menus menus);
	/**
	   * 功能：根据id删除菜单
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Delete("delete from menu where menuId=#{menuId}")
	public void deleteMenuById(@Param("menuId") String menuId);
	/**
	   * 功能：功能菜单新增
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Insert("insert into menu values(#{menuId},#{title},#{url},#{pid})")
	public void insertMneu(Menu menu);
	
}
