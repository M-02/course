package com.huaxia.course.web;

import com.github.pagehelper.PageInfo;
import com.huaxia.course.pojo.Course;
import com.huaxia.course.pojo.User;
import com.huaxia.course.service.CourseService;
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
public class CourseController {

    @Autowired
    CourseService courseService;


    @RequestMapping("/courseinfo")
    //todo:会员信息逻辑
    public String show(QueryVo queryVo, ModelMap map) throws Exception {
        //todo:分页查询所有客户数据
        PageInfo<Course> page = courseService.findPage(queryVo);
        map.put("page",page);
        map.put("queryVo",queryVo);
        return "/course/courseinfo.html";
    }

    //删除课程
    @RequestMapping("/courseDelete")
    public String courseDelete(@RequestParam(value = "c_id") String c_id) {
        String[] c_ids = c_id.split(",");
        List<Integer> list = new ArrayList<>();
        for(String str:c_ids){
            list.add(Integer.parseInt(str));
        }
        courseService.courseDelete(list);
        return "redirect:courseinfo";
    }

    //添加课程
    @RequestMapping("/courseadd")
    public String confirmAdd(Course u) throws Exception {
        courseService.addCourse(u);
        return "redirect:courseinfo";
    }

    //修改课程信息
    @RequestMapping("/courseupdate")
    public String updateCourse(Course course){
        courseService.updateCourse(course);
        return "redirect:courseinfo";
    }

    //修改课程信息
    @RequestMapping("/courseedit")
    public String listCourse(int c_id,Model model){
        Course c = courseService.selectCourseById(c_id);
        model.addAttribute("c",c);
        return "/course/edit.html";
    }

    //根据教师姓名分页显示
    @RequestMapping("/mycourse")
    public String Mohu(@RequestParam("c_teacher") String c_teacher, QueryVo queryVo, ModelMap map) throws Exception {
        PageInfo<Course> page = courseService.selectCourseByname(queryVo,c_teacher);
        map.put("page",page);
        map.put("queryVo",queryVo);
        map.put("c_teacher",c_teacher);
        map.addAttribute("map",map);
        return "/course/teachermycourseinfo.html";
    }

    //根据学生姓名分页显示
    @RequestMapping("/studentmycourse")
    public String studentmycourse(@RequestParam("u_name") String u_name, QueryVo queryVo, ModelMap map) throws Exception {
        PageInfo<Course> page = courseService.selectCourseBystudent(queryVo,u_name);
        map.put("page",page);
        map.put("queryVo",queryVo);
        map.put("u_name",u_name);
        map.addAttribute("map",map);
        return "/course/studentmycourseinfo.html";
    }

    //选中课程
    @RequestMapping("/courseok")
    public String Courseok(String ucourse,String uname,Model model, RedirectAttributes attr) throws Exception {
        Course c = courseService.courseok(ucourse,uname);
        model.addAttribute("c",c);
        Course v = courseService.courser(ucourse);
        model.addAttribute("v",v);
        attr.addAttribute("u_name", uname);
        return "redirect:lookallcourseinfo";
    }
    //退选课程
    @RequestMapping("/coursenotok")
        public String Coursenotok(String uname, Model model, String ucourse, RedirectAttributes attr) throws Exception {
            Course c = courseService.coursenotok(uname);
            model.addAttribute("c",c);
            Course v = courseService.coursep(ucourse);
            model.addAttribute("v",v);
            attr.addAttribute("u_name", uname);
            return "redirect:lookallcourseinfo";
    }

    @RequestMapping("/lookallcourseinfo")
    //todo:会员信息逻辑
    public String lookall(@RequestParam("u_name") String u_name,QueryVo queryVo, ModelMap map) throws Exception {
        //todo:分页查询所有客户数据
        PageInfo<Course> page = courseService.lookall(queryVo,u_name);
        map.put("page",page);
        map.put("queryVo",queryVo);
        map.put("u_name",u_name);
        map.addAttribute("map",map);
        return "/course/mycourseinfo.html";
    }

    //根据课程分页显示
    @RequestMapping("/mystudent")
    public String mystudent(@RequestParam("ucourse") String ucourse, QueryVo queryVo, ModelMap map) throws Exception {
        PageInfo<User> page = courseService.mystudent(queryVo,ucourse);
        map.put("page",page);
        map.put("queryVo",queryVo);
        map.put("ucourse",ucourse);
        map.addAttribute("map",map);
        System.out.println(ucourse);
        return "/course/mystudent.html";
    }


}
