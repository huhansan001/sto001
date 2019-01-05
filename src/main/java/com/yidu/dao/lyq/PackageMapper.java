package com.yidu.dao.lyq;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yidu.bean.lyq.Package;


@Repository
/**
 * 
 * 功能：Dao接口层
 * @author 刘永琪
 * @date 2018年12月22日
 * @version V1.0
 */
public interface PackageMapper {
/**
 * 功能：查询所有的方法
 * @return
 */
@Select("select * from package_lyq ")
public List<com.yidu.bean.lyq.Package> selectpackageAll();
/**
 * 功能：新增的方法
 * @return
 */
@Insert("insert into package_lyq values(#{packageId},#{workOrderNumber},#{nameOfSender},#{senderAddress},#{fullAddressOfSender},#{sendersTelephoneNumber},#{addresseeName},#{direction},#{addresseeDetailedAddress},#{addresseeTelephoneNumber},#{theParcelWeighs},#{freight},#{auditStatus},#{waybillNumber},#{remark})")
public int insertpackage(com.yidu.bean.lyq.Package packages);
/**
 * 功能：分页的方法
 * @return
 */
@Select("select * from package_lyq limit #{page},#{rows}")
public List<com.yidu.bean.lyq.Package> selectpackageAllpage(@Param("page") int page,@Param("rows") int rows);
/**
 * 功能：根据ID修改的方法
 * @return
 */
@Update("update package_lyq set workOrderNumber=#{workOrderNumber},nameOfSender=#{nameOfSender},senderAddress=#{senderAddress},fullAddressOfSender=#{fullAddressOfSender},sendersTelephoneNumber=#{sendersTelephoneNumber},addresseeName=#{addresseeName},direction=#{direction},addresseeDetailedAddress=#{addresseeDetailedAddress},addresseeTelephoneNumber=#{addresseeTelephoneNumber},theParcelWeighs=#{theParcelWeighs},freight=#{freight},auditStatus=#{auditStatus},waybillNumber=#{waybillNumber},remark=#{remark} where packageId=#{packageId}")
public void updatepackage(com.yidu.bean.lyq.Package packages);
/**
 * 功能：根据ID删除的方法
 * @return
 */
@Delete("delete from package_lyq where packageId=#{packageId}")
public void deletepackage(com.yidu.bean.lyq.Package packages);

/**
 * 功能：根据ID查询所有
 * @param packageId
 * @return
 */
@Select("SELECT * FROM package_lyq WHERE packageId=${packageId}")
public List<Package> packageAll(@Param("packageId") String packageId);
}
