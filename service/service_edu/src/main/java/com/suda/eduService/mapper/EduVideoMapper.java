package com.suda.eduService.mapper;

import com.suda.eduService.entity.EduVideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 课程视频 Mapper 接口
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
public interface EduVideoMapper extends BaseMapper<EduVideo> {

    public List<EduVideo> selectListByCourseID(String courseID);

}
