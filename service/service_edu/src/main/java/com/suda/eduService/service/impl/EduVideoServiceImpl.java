package com.suda.eduService.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.eduService.entity.EduVideo;
import com.suda.eduService.mapper.EduVideoMapper;
import com.suda.eduService.service.EduVideoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Override
    public List<EduVideo> selectListByCourseID(String courseID) {
        return baseMapper.selectListByCourseID(courseID);
    }

}
