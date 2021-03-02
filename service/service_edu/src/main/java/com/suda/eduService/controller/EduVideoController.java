package com.suda.eduService.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/eduService/video")
@CrossOrigin(origins = "*", allowCredentials = "true") // 解决跨域
public class EduVideoController {

}

