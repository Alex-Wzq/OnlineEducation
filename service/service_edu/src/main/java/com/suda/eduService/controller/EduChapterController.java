package com.suda.eduService.controller;


import com.suda.commonutils.R;
import com.suda.eduService.entity.vo.ChapterVo;
import com.suda.eduService.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/eduService/chapter")
@CrossOrigin(origins = "*", allowCredentials = "true") // 解决跨域
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    //课程大纲列表,根据课程id进行查询
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId) {
        List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("allChapterVideo",list);
    }

}

