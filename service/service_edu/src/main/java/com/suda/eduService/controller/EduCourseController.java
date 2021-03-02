package com.suda.eduService.controller;


import com.suda.commonutils.R;
import com.suda.eduService.entity.vo.CourseInfoVo;
import com.suda.eduService.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/eduService/course")
@CrossOrigin(origins = "*", allowCredentials = "true") // 解决跨域
public class EduCourseController {

    @Autowired
    EduCourseService courseService;

    //添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        // 返回添加之后课程id，为了后面添加大纲使用
        String id = courseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",id);
    }

}

