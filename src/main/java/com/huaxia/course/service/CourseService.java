package com.huaxia.course.service;

import com.github.pagehelper.PageInfo;
import com.huaxia.course.pojo.Course;
import com.huaxia.course.pojo.User;
import com.huaxia.course.web.vo.QueryVo;

import java.util.List;

public interface CourseService {

    //分页查询
    public PageInfo<Course> findPage(QueryVo queryVo) throws Exception;

    //编辑课程
    int updateCourse(Course course);

    //删除课程
    void courseDelete(List<Integer> list);

    //添加课程
    public void addCourse(Course u) throws Exception;

    //修改课程信息
    Course selectCourseById(int cid);

    //根据教师姓名分页显示
    PageInfo<Course> selectCourseByname(QueryVo queryVo,String c_teacher) throws Exception;

    //根据学生姓名分页显示
    PageInfo<Course> selectCourseBystudent(QueryVo queryVo,String u_name) throws Exception;

    //选中课程
    Course courseok(String ucourse, String uname);

    //退选课程
    Course coursenotok(String uname);

    //分页查询
    public PageInfo<Course> lookall(QueryVo queryVo,String u_name) throws Exception;

    //根据课程名称分页显示
    PageInfo<User> mystudent(QueryVo queryVo, String ucourse) throws Exception;

    //退课增加课程余量
    Course coursep(String ucourse) throws Exception;

    //选课减少课程余量
    Course courser(String ucourse) throws Exception;
}
