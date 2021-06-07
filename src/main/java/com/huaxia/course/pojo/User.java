package com.huaxia.course.pojo;

import com.huaxia.course.common.prop.LinkProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	int uid;

	int ustatus;

	String uname;

	String upassword;

	String utel;

	String uimg;

	String rname;

	int rid;

	Role role;

	List<Menu> menus;

	String ucourse;

	int cstatus;
	int c_status;

	public int getC_status() {
		return c_status;
	}

	public void setC_status(int c_status) {
		this.c_status = c_status;
	}

	public String getUcourse() {
		return ucourse;
	}

	public void setUcourse(String ucourse) {
		this.ucourse = ucourse;
	}

	public int getCstatus() {
		return cstatus;
	}

	public void setCstatus(int cstatus) {
		this.cstatus = cstatus;
	}

	//菜单分类
	Map<LinkProp,List<LinkProp>> menuList;

	public Map<LinkProp, List<LinkProp>> getMenuList() {
		return menuList;
	}

	public void setMenuList(Map<LinkProp, List<LinkProp>> menuList) {
		this.menuList = menuList;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public int getUstatus() {
		return ustatus;
	}

	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}
}
