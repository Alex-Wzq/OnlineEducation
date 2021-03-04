package com.suda.eduService.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suda.eduService.entity.EduSubject;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
public interface EduSubjectService extends IService<EduSubject> {

    public void saveSubject(MultipartFile file);

    public EduSubject getOneSubjectByID(String id);

    public EduSubject getTwoSubjectByID(String id);

}
