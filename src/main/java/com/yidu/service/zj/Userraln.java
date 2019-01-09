package com.yidu.service.zj;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.bean.zj.UserReg;
import com.yidu.dao.zj.UserRela;
/**
 * 类描述：业务�?
 * @author 周江
 */
@Service
public class Userraln {
	@Autowired
	private  UserRela userrela;//调用Bean层用户信�?
	/*
	 * 方法说明：查询所有用户信息与分页
	 * @name :Quiet
	 * @param selectUserRelaAll
	 * @return map
	 * @date 2018�?12�?14日下�?2:23:29
	 */
	public Map<String, Object> selectUserRelaAll(String page,String rows){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", userrela.SelectuserRelaAll().size());
		map.put("data", userrela.SelectuserRelaAllpage((Integer.parseInt(page)-1)*Integer.parseInt(rows), Integer.parseInt(rows)));
		return map;
	}
	/*
	 * 方法说明：添加用户信�?
	 * @name :Quiet
	 * @param insertuserRela
	 * @return userrela.insertuserRela(user)
	 * @date 2018�?12�?14日下�?2:23:29
	 */
	public int insertuserRela(UserReg user){
		return userrela.insertuserRela(user);

	}
	/*
	 * 方法说明：修改用户信�?
	 * @name :Quiet
	 * @param updateuserRela
	 * @return userrela.updateuserRela(user)
	 * @date 2018�?12�?14日下�?2:23:29
	 */
	public int updateuserRela(UserReg user){
		return userrela.updateuserRela(user);
	}

	/*
	 * 方法说明：删除用户信�?
	 * @name :Quiet
	 * @param deleteuserRela
	 * @return i
	 * @date 2018�?12�?14日下�?2:23:29
	 */
	public int deleteuserRela(UserReg user){
		int i = userrela.deleteuserRela(user);
		System.out.println(i);
		return i;
	}
}
