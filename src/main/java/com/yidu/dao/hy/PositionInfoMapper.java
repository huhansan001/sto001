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
 * ������ ��ɫ�ͽ�ɫ�м���dao��
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��11�� ����6:53:10 
 *
 */
@Repository
public interface PositionInfoMapper {

	/**
	   * ���ܣ�����Ա����Ų�ѯ��ɫid
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT p2.posiName FROM positioninfo p1,positions p2 WHERE p1.posiId=p2.posiId AND p1.empNo=#{empNo}")
	public String selectPosiIdByEmpNo(@Param("empNo") int empNo);
	
	/**
	   * ���ܣ���ѯ���н�ɫ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT * from positions")
	public List<Positions> selectPositionsAll();
	/**
	   * ���ܣ���ҳ��ѯ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT * from positions limit #{page},#{row}")
	public List<Positions> selectPositionsAllPaging(@Param("page") int page,@Param("row") int row);
	/**
	   * ���ܣ�����Ա������޸Ľ�ɫ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Update("update positioninfo set posiId=#{posiId} where empNo=#{empNo}")
	public void updatePositionByEmpNo(@Param("posiId")int posiId,@Param("empNo") int empNo);
	/**
	   * ���ܣ�������ɫ�м��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Insert("INSERT INTO positioninfo(empNo,posiId)VALUES (#{empNo},#{posiId})")
	public void insertPositioninfo(@Param("empNo") int empNo,@Param("posiId") int posiId);
	/**
	   * ���ܣ�����ְλid�޸�ְλ��Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Update("update positions set posiName=#{posiName},salary=#{salary} where posiId=#{posiId}")
	public void updatePositions(Positions positions);
	/**
	   * ���ܣ�����ְλid�޸�ְλ��Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Update("delete from positions where posiId=#{posiId}")
	public void deletePositionById(int posiId);
	/**
	 * ���ܣ�����Ա��ְλ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Insert("INSERT INTO positions(posiName,salary)VALUES(#{posiName},#{salary})")
	@Options(useGeneratedKeys=true, keyProperty="posiId", keyColumn="id")
	public void insertPositions(Positions positions);
}
