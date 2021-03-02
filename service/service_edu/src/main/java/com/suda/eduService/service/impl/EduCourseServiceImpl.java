package com.suda.eduService.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.eduService.entity.EduCourse;
import com.suda.eduService.entity.EduCourseDescription;
import com.suda.eduService.entity.vo.CourseInfoVo;
import com.suda.eduService.mapper.EduCourseMapper;
import com.suda.eduService.service.EduCourseDescriptionService;
import com.suda.eduService.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    EduCourseDescriptionService eduCourseDescriptionService;

    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, course);
        int insert = 0;
        if (course.getId() != null && baseMapper.selectById(course.getId()) != null){
            baseMapper.updateById(course);
        } else {
            insert = baseMapper.insert(course);
        }

        String courseID = course.getId();
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(courseID);
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        if (eduCourseDescriptionService.getById(courseID) != null) {
            eduCourseDescriptionService.updateById(eduCourseDescription);
        } else {
            eduCourseDescriptionService.save(eduCourseDescription);
        }

        return courseID;
    }
}
