package com.yidu.dao.hy;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hy.Menu;
import com.yidu.bean.hy.StoEmp;
/**
 * 描述： 员工信息的增，删，改，查（dao层）
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月7日 下午1:37:43 
 *
 */
@Repository
public interface StoEmpMapper {
	
	/**
	 * 功能：根据账号和密码查询员工编号（登录）
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("select * from stoemp where posi_account=#{account} and posi_pass=#{pass}")
	public List<StoEmp> selectEmpNoByNameAndPass(@Param("account")String account,@Param("pass")String pass);
	/**
	   * 功能：根据pid查询菜单功能
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT m2.menuId,m2.pid,m2.title,m2.url FROM positioninfo p,stoemp s,menuinfo m,menu m2 WHERE p.empNo=s.empNo AND p.posiId=m.posiId AND m.menuId=m2.menuId AND p.empNo=#{empNo} GROUP BY m2.menuId")
	public List<Menu> selectMenuByMenuId(@Param("empNo") int empNo);
	/**
	   * 功能：查询所有员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("select * from stoemp")
	public List<StoEmp> selectStoEmpAll();
	/**
	   * 功能：分页查询
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("select * from stoemp limit #{page},#{row}")
	public List<StoEmp> selectStoEmpAllPaging(@Param("page")int page,@Param("row")int row);
	/**
	   * 功能：根据员工编号修改员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Update("update stoemp set empName=#{empName},empDate=#{empDate},posi_account=#{posi_account},posi_pass=#{posi_pass} where empNo=#{empNo}")
	public void updateStoEmpByEmpNo(StoEmp stoEmp);
	/**
	   * 功能：根据员工编号修改员工状态
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Update("update stoemp set empState=#{empState} where empNo=#{empNo}")
	public void updateStateByEmpNo(@Param("empNo")int empNo,@Param("empState")String empState);
	/**
	   * 功能：根据多个员工编号批量删除员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Delete("delete from stoemp where empNo=#{empNo}")
	public void deleteBatchStoEmp(@Param("empNo")int empNo);
	/**
	   * 功能：新增员工信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Insert("INSERT INTO stoemp VALUES (#{empNo},#{empName},#{empDate},#{posi_account},#{posi_pass},#{empState})")
	public void insertStoEmp(StoEmp stoEmp);
	/**
	   * 功能：根据员工编号修改头像地址
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Update("update stoemp set empImg=#{empImg} where empNo=#{empNo}")
	public void updateEmpImgByEmpNo(@Param("empImg")String empImg,@Param("empNo")int empNo);
}
