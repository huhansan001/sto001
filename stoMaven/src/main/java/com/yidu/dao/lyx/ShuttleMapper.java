package com.yidu.dao.lyx;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.lyx.ShuttleWatch;;

@Repository
public interface ShuttleMapper {
   /**
    * 
    */
	@Select("select * from VehicleTable") 
	public List<ShuttleWatch> selectSenderAll();
	
	
	@Insert("insert into distribute values(#{eemploye},#{indent},#{waybill},#{sender},#{recipients},#{county},#{address},#{number},#{shippingState})")
	public int insertdistribute(ShuttleMapper shuttleMaper);
	
	
	@Update("UPDATE VehicleTable SET carNumber=#{carNumber},driverNumber=#{driverNumber},state=#{state},departureTime=#{departureTime},drrivalTime=#{drrivalTime},startingPoint=#{startingPoint},Terminus=#{Terminus},dotId=#{dotId} WHERE carNumber=#{carNumber}")
	public void updatedistribute(ShuttleMapper shuttlemaper);
	
	
	@Delete("delete from distribute where employee=#{employee} ")
	public void deletedistribute(ShuttleMapper shuttlemaper);
}
