package com.huaxia.course.web;

import com.github.pagehelper.PageInfo;
import com.huaxia.course.pojo.Course;
import com.huaxia.course.pojo.User;
import com.huaxia.course.service.UserService;
import com.huaxia.course.web.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/userinfo")
    //todo:会员信息逻辑
    public String show(QueryVo queryVo, ModelMap map) throws Exception {
        //todo:分页查询所有客户数据
        PageInfo<User> page = userService.findPage(queryVo);
        map.put("page",page);
        map.put("queryVo",queryVo);
        return "/user/userinfo.html";
    }

    @RequestMapping("/userDelete")
    public String userDelete(@RequestParam(value = "uid") String uid) {
        String[] uids = uid.split(",");
        List<Integer> list = new ArrayList<>();
        for(String str:uids){
            list.add(Integer.parseInt(str));
        }
        userService.userDelete(list);
        return "redirect:userinfo";
    }

    @RequestMapping("/useradd")
    public String confirmAdd(User u) throws Exception {
        userService.addUser(u);
        return "redirect:userinfo";
    }

    @RequestMapping("/update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:userinfo";
    }

    @RequestMapping("/edit")
    public String listUser(int uid,Model model){
        User c = userService.selectById(uid);
        model.addAttribute("c",c);
        return "/user/edit.html";
    }
    //开始选课
    @RequestMapping("/startcourse")
    public String startcourse(String uname,Model model, RedirectAttributes attr) throws Exception {
        User c = userService.startcourse(uname);
        model.addAttribute("c",c);
        attr.addAttribute("c_teacher", uname);
        return "redirect:mycourse";
    }

    //停止选课
    @RequestMapping("/stopcourse")
    public String stopcourse(String uname,Model model, RedirectAttributes attr) throws Exception {
        User c = userService.stopcourse(uname);
        model.addAttribute("c",c);
        attr.addAttribute("c_teacher", uname);
        return "redirect:mycourse";
    }

}
