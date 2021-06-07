package com.huaxia.course.dao;

import com.huaxia.course.pojo.Course;
import com.huaxia.course.pojo.User;

import java.util.List;

public interface CourseMapper {
    //分页查询
    public List<Course> getAll() throws Exception;

    //删除课程
    public void courseDelete(List<Integer> list);

    //添加课程
    public void addOne(Course course) throws Exception;

    //根据id查询课程
    public Course selectCourseById(int c_id);

    //修改课程信息
    public int updateCourse(Course course);

    //根据教师姓名分页显示
    public List<Course> selectCourseByname(String c_teacher);

    //根据学生姓名分页显示
    public List<Course> selectCourseBystudent(String u_name);

    //选中课程
    public void courseok(String ucourse,String uname);

    //退选课程
    public void coursenotok(String uname);

    //分页查询
    public List<Course> lookAll(String u_name) throws Exception;

    //查看学生
    public List<User> mystudent(String ucourse);

    //退课增加课程余量
    public void coursep(String ucourse) throws Exception;

    //选课减少课程余量
    public void courser(String ucourse) throws Exception;

}
