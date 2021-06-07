package com.huaxia.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.huaxia.course.common.prop.LinkProp;
import com.huaxia.course.dao.UserMapper;
import com.huaxia.course.pojo.Menu;
import com.huaxia.course.pojo.Role;
import com.huaxia.course.pojo.User;
import com.huaxia.course.service.UserService;
import com.huaxia.course.web.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User login(User user, HttpSession session) throws Exception {
		User result = userMapper.getUser(user.getUname(), user.getUpassword());
		if(result!=null){
			//封装用户对应的菜单
			Map<Role, List<Menu>> roleListMap = (Map<Role, List<Menu>>) session.getServletContext().getAttribute("rolemenus");
			Set<Role> roles = roleListMap.keySet();
			for (Role role : roles) {
				if(role.getRid() == result.getRid()){
					//目标角色
					result.setRole(role);
					result.setMenus(roleListMap.get(role));
				}
			}

//			//菜单分类
//			Map<LinkProp,List<LinkProp>> menuMap  = new HashMap<>();
//
//			//菜单对应链接
//			Map<String, String> menuLinks = (Map<String, String>) session.getServletContext().getAttribute("menulinks");
//
//			List<Menu> allmenus = result.getMenus();
//			for (Menu menu : allmenus) {
//				if(menu.getMenulevel() == 1){
//					//获取一级菜单下的所有二级菜单
//					List<LinkProp> subList = new ArrayList<>();
//					for (Menu m2 : allmenus) {
//						 if(m2.getMenulevel() ==2 && m2.getMeneparent() == menu.getMenuid()){
//							 subList.add(new LinkProp(m2.getMenuname(),menuLinks.get(m2.getMenuname())));
//						 }
//					}
//					menuMap.put(new LinkProp(menu.getMenuname(),menuLinks.get(menu.getMenuname())),subList);
//				}
//			}
//			result.setMenuList(menuMap);
		}
		return result;
	}


	//@Autowired
	//UserMapper userMapper;
	//分页查询
	@Override
	public PageInfo<User> findPage(QueryVo queryVo) throws Exception {
		PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
		List<User> List = userMapper.getAll();
		PageInfo<User> pageInfo = new PageInfo<User>(List);
		return pageInfo;
	}

	//修改密码
	@Override
	public int repasswd(User user) throws Exception {
		return userMapper.resetpasswd(user);
	}

	//删除用户
	@Override
	public void userDelete(List<Integer> list) {
		userMapper.userDelete(list);
	}

	//添加用户
	@Override
	public void addUser(User u) throws Exception {
		userMapper.addOne(u);
	}

	//根据id查找用户
	@Override
	public User selectById(int uid) {
		return userMapper.selectById(uid);
	}

	//编辑用户信息
	@Override
	public int update(User user) {
		return userMapper.updateUser(user);
	}

	//开始选课
	@Override
	public User startcourse(String uname) {
		userMapper.startcourse(uname);
		return null;
	}

	//停止选课
	@Override
	public User stopcourse(String uname) {
		 userMapper.stopcourse(uname);
		 return null;
	}


}
