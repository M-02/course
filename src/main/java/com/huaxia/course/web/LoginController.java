package com.huaxia.course.web;

import com.huaxia.course.pojo.User;
import com.huaxia.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public String showInfo(User u, HttpSession session, Model model) throws Exception {
		//判断session是否已登录
		User sessionU= (User) session.getAttribute("user");

		if(sessionU!=null){

             return "/user/index.html";
		}
		if(StringUtils.isEmpty(u.getUname()) || StringUtils.isEmpty(u.getUpassword())){
            return "404";
        }
		User user = userService.login(u,session);
		session.setAttribute("user",user);
		//System.out.println(user.getUname());
		if(user==null) {
			model.addAttribute("message","账号或密码错误");
			return "login";
		}
		else{ return "/user/index.html";}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/login.html";
	}

	@RequestMapping("/updatepasswd")
	public String userrepasswd(User user,HttpSession session) throws Exception {
		userService.repasswd(user);
		session.removeAttribute("user");
		return "redirect:/login.html";
	}

	@RequestMapping("/repasswd")
	public String listUser(){
		return "/user/resetpasswd.html";
	}

}


