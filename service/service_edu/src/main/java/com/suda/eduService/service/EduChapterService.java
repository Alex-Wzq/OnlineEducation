package com.suda.eduService.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suda.eduService.entity.EduChapter;
import com.suda.eduService.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
public interface EduChapterService extends IService<EduChapter> {

    public List<ChapterVo> getChapterVideoByCourseId(String courseId);

}
