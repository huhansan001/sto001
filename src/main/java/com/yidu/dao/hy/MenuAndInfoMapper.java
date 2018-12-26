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
 * ������ Ա������Ȩ�޳־ò�
 * @Description��
 * @author ��huYang 
 * @date ��2018��12��14�� ����7:01:01 
 *
 */
@Repository
public interface MenuAndInfoMapper {
	/**
	 * ���ܣ�����ְλid��ѯ����(�����ѯ)
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT m1.menuId,m1.title,m1.pid FROM menu m1,menuinfo m2 WHERE m1.menuId=m2.menuId AND m2.posiId=#{posiId} ORDER BY m1.menuId")
	public List<Menu> selectMenuIdByPosiId(@Param("posiId") int posiId);
	/**
	 * ���ܣ���ѯ���в˵�����ְλid
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT m1.menuId,m1.title,m1.pid FROM menu m1 WHERE m1.menuId NOT IN(SELECT m1.menuId FROM menuinfo m2 WHERE m1.menuId=m2.menuId AND m1.pid !='root' AND m2.posiId=#{posiId}) GROUP BY m1.menuId")
	public List<Menu> selectMenuIdAll(@Param("posiId") int posiId);
	/**
	 * ���ܣ�����ְλid�Ͳ˵�idɾ���˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Delete("delete from menuinfo where posiId=#{posiId} and menuId=#{menuId}")
	public void deleteMenuinfoByPidAndMid(@Param("posiId") int posiId,@Param("menuId") String menuId);
	/**
	   * ���ܣ�����ְλid����Ȩ��
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Insert("insert into menuinfo (posiId,menuId) values(#{posiId},#{menuId})")
	public void insertMenuinfoByPidAndMid(@Param("posiId") int posiId,@Param("menuId") String menuId);
	/**
	   * ���ܣ���ѯ����һ���˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT menuId FROM menu WHERE pid='root'")
	public List<String> selectMenuIdByRoot();
	/**
	   * ���ܣ���ѯ���в˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT * FROM menu GROUP BY menuId")
	public List<Menus> selectMenuAll();
	/**
	   * ���ܣ���ҳ��ѯ
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Select("SELECT * FROM menu GROUP BY menuId LIMIT #{page},#{row}")
	public List<Menus> selectMenuAllPaging(@Param("page")int page,@Param("row")int row);
	/**
	   * ���ܣ�����id�޸Ĳ˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Update("update menu set title=#{title},url=#{url},pid=#{pid} where menuId=#{menuId}")
	public void updateMenuById(Menus menus);
	/**
	   * ���ܣ�����idɾ���˵�
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Delete("delete from menu where menuId=#{menuId}")
	public void deleteMenuById(@Param("menuId") String menuId);
	/**
	   * ���ܣ����ܲ˵�����
	 * @param ��
	 * @return ��
	 * @throws
	 */
	@Insert("insert into menu values(#{menuId},#{title},#{url},#{pid})")
	public void insertMneu(Menu menu);
	
}
