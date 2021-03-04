package com.suda.eduService.service;

import com.suda.eduService.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
public interface EduVideoService extends IService<EduVideo> {

    public List<EduVideo> selectListByCourseID(String courseID);

}
