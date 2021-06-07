package com.huaxia.course.dao;



import com.huaxia.course.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

	//用户登录
	public User getUser(@Param("uname") String uname, @Param("upassword") String upass) throws Exception;

	//查询所有用户信息
	public List<User> getAll() throws Exception;

	//修改密码
	public int resetpasswd(User user) throws Exception;

	//删除用户
	public void userDelete(List<Integer> list);

	//添加用户
	public void addOne(User user) throws Exception;

	//根据id查找用户
	public User selectById(int uid);

	//编辑用户信息
	public int updateUser(User user);

	//编辑学生成绩
	public int scoreupdate(User user);

	//查询所有用户成绩
	public List<User> scoreinfo() throws Exception;

	//开始选课
	public void startcourse(String uname);

	//停止选课
	public void stopcourse(String uname);


}
