package com.suda.eduService.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suda.eduService.entity.EduCourse;
import com.suda.eduService.entity.vo.CourseInfoVo;
import com.suda.eduService.entity.vo.CoursePublishVo;

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

    public CourseInfoVo getCourseInfo(String courseId);

    public void updateCourseInfo(CourseInfoVo courseInfoVo);

    public CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

}
