package com.suda.eduService.mapper;

import com.suda.eduService.entity.EduSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
public interface EduSubjectMapper extends BaseMapper<EduSubject> {

    public int getMaxSort();

    public String getID(String title);

    public EduSubject getSubjectByTitle(String title);
}
