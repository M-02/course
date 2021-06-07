package com.huaxia.course.dao;


import com.huaxia.course.pojo.Menu;

import java.util.List;


public interface MenuMapper {

	public List<Menu> getMenus(int rid) throws Exception;
	
}
