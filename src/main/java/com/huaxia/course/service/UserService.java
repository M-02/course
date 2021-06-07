package com.huaxia.course.service;

import com.github.pagehelper.PageInfo;
import com.huaxia.course.pojo.User;
import com.huaxia.course.web.vo.QueryVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

	User login(User user, HttpSession session) throws Exception;

	public PageInfo<User> findPage(QueryVo queryVo) throws Exception;

	int repasswd(User user) throws Exception;

	void userDelete(List<Integer> list);

	public void addUser(User u) throws Exception;

	User selectById(int uid);

	int update(User user);

	User startcourse(String uname);

	User stopcourse(String uname);
}
