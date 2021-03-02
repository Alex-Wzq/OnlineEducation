package com.suda.eduService.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程简介 前端控制器
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/eduService/edu-course-description")
@CrossOrigin(origins = "*", allowCredentials = "true") // 解决跨域
public class EduCourseDescriptionController {

}

