package com.suda.eduService.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.eduService.entity.EduCourse;
import com.suda.eduService.entity.EduCourseDescription;
import com.suda.eduService.entity.EduSubject;
import com.suda.eduService.entity.vo.CourseInfoVo;
import com.suda.eduService.entity.vo.CoursePublishVo;
import com.suda.eduService.mapper.EduCourseMapper;
import com.suda.eduService.service.*;
import com.suda.servicebase.exceptionHandler.exception.MyException;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    EduCourseDescriptionService eduCourseDescriptionService;

    @Autowired
    EduSubjectService eduSubjectService;

    @Autowired
    EduTeacherService eduTeacherService;

    @Autowired
    EduVideoService eduVideoService;

    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, course);

        if (course.getSubjectParentId() == null){
            EduSubject subject = eduSubjectService.getById(course.getId());
            course.setSubjectParentId(subject.getId());
        }
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

    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        EduCourse course = baseMapper.selectById(courseId);
        EduCourseDescription courseDescription = eduCourseDescriptionService.getById(courseId);

        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(course, courseInfoVo);
        courseInfoVo.setDescription(courseDescription.getDescription());

        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, course);
        int update = baseMapper.updateById(course);
        if ( update == 0) {
            log.error("Error when updating course information!");
            throw new MyException(20001, "Error when updating course information!");
        }

        EduCourseDescription courseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo, courseDescription);
        eduCourseDescriptionService.updateById(courseDescription);
    }

    @Override
    public CoursePublishVo publishCourseInfo(String courseId) {
        return baseMapper.getPublishCourseInfo(courseId);

//        EduCourse course = baseMapper.selectById(id);
//        CoursePublishVo coursePublishVo = new CoursePublishVo();
//        BeanUtils.copyProperties(course, coursePublishVo);
//
//        coursePublishVo.setSubjectLevelOne(course.getSubjectId());
//        coursePublishVo.setSubjectLevelTwo(course.getSubjectParentId());
//        coursePublishVo.setPrice(course.getPrice().toString());
//
//        EduTeacher teacher = eduTeacherService.getById(course.getTeacherId());
//        coursePublishVo.setTeacherName(teacher.getName());
//
//        return coursePublishVo;
    }

    // 删除课程
    // TODO
    @Override
    public void removeCourse(String courseId) {
//        //1 根据课程id删除小节
//        eduVideoService.removeById()
//        eduVideoService.removeVideoByCourseId(courseId);
//
//        //2 根据课程id删除章节
//        chapterService.removeChapterByCourseId(courseId);
//
//        //3 根据课程id删除描述
//        courseDescriptionService.removeById(courseId);
//
//        //4 根据课程id删除课程本身
//        int result = baseMapper.deleteById(courseId);
//        if(result == 0) { //失败返回
//            throw new GuliException(20001,"删除失败");
//        }
    }
}
