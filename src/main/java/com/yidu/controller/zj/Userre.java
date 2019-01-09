package com.yidu.controller.zj;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yidu.bean.zj.UserReg;
import com.yidu.service.zj.Userraln;
/**
 * 类描述：控制�?
 * @author 周江
 */
@Controller
public class Userre {
	@Autowired
	private Userraln userservice;//调用service

	/*
	 * 方法描述：查询所有的用户信息
	 * name :Quiet
	 * @param selectUserRelaAll
	 * @return userservice.selectUserRelaAll()
	 * @date 2018�?12�?14日下�?2:23:29
	 */
	@RequestMapping("selectUserRelaAll.action")
	public @ResponseBody Map<String, Object> selectUserRelaAll(String page,String limit){

		return userservice.selectUserRelaAll(page,limit);
	}
	/*
	 * 方法描述：新增用户信�?
	 * name :Quiet
	 * @param insertUserRela
	 * @return temp
	 * @date 2018�?12�?14日下�?2:23:29
	 */
	@RequestMapping("insertUserRela.action")
	public @ResponseBody String insertUserRela(@ModelAttribute UserReg user) {
		int i = userservice.insertuserRela(user);
		String temp = "";
		temp=i>0?"ok":"no";
		return temp;
	}
	/*
	 * function:修改用户信息
	 * name :Quiet
	 * @param receiptWorkorder_czq
	 * @return temp
	 * @date 2018�?12�?14日下�?2:23:29
	 */
	@RequestMapping("updateUserRela.action")
	public @ResponseBody String updateUserReg(@ModelAttribute UserReg user) {

		int i=userservice.updateuserRela(user);
		String temp = "";
		temp=i>0?"ok":"no";
		System.out.println(userservice+temp+i);
		return temp;
	}

	/*
	 * function:删除用户信息
	 * name :Quiet
	 * @param receiptWorkorder_czq
	 * @return temp
	 * @date 2018�?12�?14日下�?2:23:46
	 */
	@RequestMapping("deleteUserRela.action")
	public @ResponseBody String deleteUserReg(@ModelAttribute UserReg user) {
		System.out.println(userservice);
		int i = userservice.deleteuserRela(user);
		String temp = "";
		temp=i>0?"ok":"no";
		System.out.println("删除执行结果:"+temp+"-----"+i);
		return temp;
	}
}
