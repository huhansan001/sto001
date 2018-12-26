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
 * ������ Ա����Ϣ������ɾ���ģ��飨dao�㣩
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��7�� ����1:37:43 
 *
 */
@Repository
public interface StoEmpMapper {
	
	/**
	 * ���ܣ������˺ź������ѯԱ����ţ���¼��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("select * from stoemp where posi_account=#{account} and posi_pass=#{pass}")
	public List<StoEmp> selectEmpNoByNameAndPass(@Param("account")String account,@Param("pass")String pass);
	/**
	   * ���ܣ�����pid��ѯ�˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT m2.menuId,m2.pid,m2.title,m2.url FROM positioninfo p,stoemp s,menuinfo m,menu m2 WHERE p.empNo=s.empNo AND p.posiId=m.posiId AND m.menuId=m2.menuId AND p.empNo=#{empNo} GROUP BY m2.menuId")
	public List<Menu> selectMenuByMenuId(@Param("empNo") int empNo);
	/**
	   * ���ܣ���ѯ����Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("select * from stoemp")
	public List<StoEmp> selectStoEmpAll();
	/**
	   * ���ܣ���ҳ��ѯ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("select * from stoemp limit #{page},#{row}")
	public List<StoEmp> selectStoEmpAllPaging(@Param("page")int page,@Param("row")int row);
	/**
	   * ���ܣ�����Ա������޸�Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Update("update stoemp set empName=#{empName},empDate=#{empDate},posi_account=#{posi_account},posi_pass=#{posi_pass} where empNo=#{empNo}")
	public void updateStoEmpByEmpNo(StoEmp stoEmp);
	/**
	   * ���ܣ�����Ա������޸�Ա��״̬
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Update("update stoemp set empState=#{empState} where empNo=#{empNo}")
	public void updateStateByEmpNo(@Param("empNo")int empNo,@Param("empState")String empState);
	/**
	   * ���ܣ����ݶ��Ա���������ɾ��Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Delete("delete from stoemp where empNo=#{empNo}")
	public void deleteBatchStoEmp(@Param("empNo")int empNo);
	/**
	   * ���ܣ�����Ա����Ϣ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Insert("INSERT INTO stoemp VALUES (#{empNo},#{empName},#{empDate},#{posi_account},#{posi_pass},#{empState})")
	public void insertStoEmp(StoEmp stoEmp);
	/**
	   * ���ܣ�����Ա������޸�ͷ���ַ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Update("update stoemp set empImg=#{empImg} where empNo=#{empNo}")
	public void updateEmpImgByEmpNo(@Param("empImg")String empImg,@Param("empNo")int empNo);
}
