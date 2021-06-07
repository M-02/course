package com.huaxia.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaxia.course.dao.CourseMapper;
import com.huaxia.course.pojo.Course;
import com.huaxia.course.pojo.User;
import com.huaxia.course.service.CourseService;
import com.huaxia.course.web.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service(value = "courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    //分页查询
    @Override
    public PageInfo<Course> findPage(QueryVo queryVo) throws Exception {
        PageHelper.startPage(queryVo.getPage(), queryVo.getPageSize());
        List<Course> List = courseMapper.getAll();
        PageInfo<Course> pageInfo = new PageInfo<Course>(List);
        return pageInfo;
    }

    //删除课程
    @Override
    public void courseDelete(List<Integer> list) {
        courseMapper.courseDelete(list);
    }

    //添加课程
    @Override
    public void addCourse(Course d) throws Exception {
        courseMapper.addOne(d);
    }

    //根据id查找课程
    @Override
    public Course selectCourseById(int c_id) {
        return courseMapper.selectCourseById(c_id);
    }

    //编辑课程
    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    //根据教师姓名分页显示
    @Override
    public PageInfo<Course> selectCourseByname(QueryVo queryVo,String c_teacher) throws Exception {
        PageHelper.startPage(queryVo.getPage(),queryVo.getPageSize());
        List<Course> list1 = courseMapper.selectCourseByname(c_teacher);
        PageInfo<Course> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }

    //根据学生姓名分页显示
    @Override
    public PageInfo<Course> selectCourseBystudent(QueryVo queryVo,String u_name) throws Exception {
        PageHelper.startPage(queryVo.getPage(),queryVo.getPageSize());
        List<Course> list1 = courseMapper.selectCourseBystudent(u_name);
        PageInfo<Course> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }


    //选中课程
    @Override
    public Course courseok(String ucourse,String uname ) { courseMapper.courseok(ucourse,uname);
        return null;
    }

    //退选课程
    @Override
    public Course coursenotok(String uname) {courseMapper.coursenotok(uname);
        return null;
    }

    //分页查询
    @Override
    public PageInfo<Course> lookall(QueryVo queryVo,String u_name) throws Exception {
        PageHelper.startPage(queryVo.getPage(),queryVo.getPageSize());
        List<Course> list1 = courseMapper.lookAll(u_name);
        PageInfo<Course> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }

    //根据课程名称分页显示
    @Override
    public PageInfo<User> mystudent(QueryVo queryVo, String ucourse) throws Exception {
        PageHelper.startPage(queryVo.getPage(),queryVo.getPageSize());
        List<User> list1 = courseMapper.mystudent(ucourse);
        PageInfo<User> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }

    //退课增加课程余量
    @Override
    public Course coursep(String ucourse) throws Exception { courseMapper.coursep(ucourse);
        return null;
    }

    //选课减少课程余量
    @Override
    public Course courser(String ucourse) throws Exception { courseMapper.courser(ucourse);
        return null;
    }

}
