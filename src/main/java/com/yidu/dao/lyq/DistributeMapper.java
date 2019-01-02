package com.yidu.dao.lyq;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.lyq.Distribute;

@Repository
public interface DistributeMapper {
	
	
	@Select("select*from distribute")
	public List<Distribute> selectdistributeAll();
	
	@Select("select*from distribute limit #{page},#{rows}")
	public List<Distribute> distributeLimit(@Param("page") int page,@Param("rows") int rows);
	@Insert("insert into distribute values(#{employee},#{indent},#{waybill},#{sender},#{recipients},#{county},#{address},#{number},#{shippingState})")
	public int insertdistribute(Distribute distribute);
	
	
	@Update("UPDATE distribute SET indent=#{indent},waybill=#{waybill},sender=#{sender},recipients=#{recipients},county=#{county},address=#{address},number=#{number},shippingState=#{shippingState} WHERE employee=#{employee}")
	public void updatedistribute(Distribute distribute);
	
	
	@Delete("delete from distribute where employee=#{employee} ")
	public void deletedistribute(Distribute distribute);
}
