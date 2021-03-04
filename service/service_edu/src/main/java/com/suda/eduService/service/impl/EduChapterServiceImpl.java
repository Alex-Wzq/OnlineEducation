package com.suda.eduService.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.eduService.entity.EduChapter;
import com.suda.eduService.entity.EduVideo;
import com.suda.eduService.entity.vo.ChapterVo;
import com.suda.eduService.entity.vo.VideoVo;
import com.suda.eduService.mapper.EduChapterMapper;
import com.suda.eduService.service.EduChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    EduVideoServiceImpl eduVideoService;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        List<EduChapter> chapterList = baseMapper.selectListByCourseID(courseId);
        List<EduVideo> videoList = eduVideoService.selectListByCourseID(courseId);

        Map<String, ChapterVo> chapterVoMap = new HashMap<>();
        chapterList.forEach( chapter -> {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter,chapterVo);
            chapterVoMap.put(chapter.getId(), chapterVo);
        });

        videoList.forEach( video -> {
            ChapterVo chapterVo = chapterVoMap.get(video.getChapterId());
            VideoVo videoVo = new VideoVo();
            BeanUtils.copyProperties(video,videoVo);
            if (chapterVo.getChildren() == null) {
                chapterVo.setChildren(new ArrayList<>());
            }

            chapterVo.getChildren().add(videoVo);
        });

        return chapterVoMap.values().stream().collect(Collectors.toList());
    }

}
