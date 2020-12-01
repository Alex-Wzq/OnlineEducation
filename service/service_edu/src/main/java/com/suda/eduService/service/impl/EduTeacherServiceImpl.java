package com.suda.eduService.service.impl;

import com.suda.eduService.entity.EduTeacher;
import com.suda.eduService.mapper.EduTeacherMapper;
import com.suda.eduService.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.suda.eduService.entity.EduTeacher;
import java.util.*;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-30
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

}
