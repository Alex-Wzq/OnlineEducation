package com.suda.eduService.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suda.eduService.entity.EduCourse;
import com.suda.eduService.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
public interface EduCourseService extends IService<EduCourse> {

    public String saveCourseInfo(CourseInfoVo courseInfoVo);

}
