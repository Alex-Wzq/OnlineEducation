package com.suda.eduService.controller;


import com.suda.commonutils.R;
import com.suda.eduService.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@Api(description = "Subject管理")
@RestController
@RequestMapping("/eduService/subject")
@CrossOrigin(origins = "*", allowCredentials = "true") // 解决跨域
public class EduSubjectController {

    @Autowired
    EduSubjectService eduSubjectService;

    @ApiOperation(value = "增加一个subject")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file);
        return R.ok();
    }

}

