package com.suda.eduService.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suda.eduService.entity.EduChapter;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
public interface EduChapterMapper extends BaseMapper<EduChapter> {

    public List<EduChapter> selectListByCourseID(String courseID);

}
