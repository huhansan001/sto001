package com.yidu.dao.hy;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.hy.Positions;
/**
 * 描述： 角色和角色中间表的dao层
 * @Description：
 * @author ：huYang 
 * @date ：2018年12月11日 下午6:53:10 
 *
 */
@Repository
public interface PositionInfoMapper {

	/**
	   * 功能：根据员工编号查询角色id
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT p2.posiName FROM positioninfo p1,positions p2 WHERE p1.posiId=p2.posiId AND p1.empNo=#{empNo}")
	public String selectPosiIdByEmpNo(@Param("empNo") int empNo);
	
	/**
	   * 功能：查询所有角色
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT * from positions")
	public List<Positions> selectPositionsAll();
	/**
	   * 功能：分页查询
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Select("SELECT * from positions limit #{page},#{row}")
	public List<Positions> selectPositionsAllPaging(@Param("page") int page,@Param("row") int row);
	/**
	   * 功能：根据员工编号修改角色
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Update("update positioninfo set posiId=#{posiId} where empNo=#{empNo}")
	public void updatePositionByEmpNo(@Param("posiId")int posiId,@Param("empNo") int empNo);
	/**
	   * 功能：新增角色中间表
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Insert("INSERT INTO positioninfo(empNo,posiId)VALUES (#{empNo},#{posiId})")
	public void insertPositioninfo(@Param("empNo") int empNo,@Param("posiId") int posiId);
	/**
	   * 功能：根据职位id修改职位信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Update("update positions set posiName=#{posiName},salary=#{salary} where posiId=#{posiId}")
	public void updatePositions(Positions positions);
	/**
	   * 功能：根据职位id修改职位信息
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Update("delete from positions where posiId=#{posiId}")
	public void deletePositionById(int posiId);
	/**
	 * 功能：新增员工职位
	 * @param ：
	 * @return ：
	 * @throws
	 */
	@Insert("INSERT INTO positions(posiName,salary)VALUES(#{posiName},#{salary})")
	@Options(useGeneratedKeys=true, keyProperty="posiId", keyColumn="id")
	public void insertPositions(Positions positions);
}
