package com.suda.eduService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.commonutils.excel.PoiExcelUtil;
import com.suda.eduService.entity.EduSubject;
import com.suda.eduService.mapper.EduSubjectMapper;
import com.suda.eduService.service.EduSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author ziqian.wang
 * @since 2021-02-28
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    public void saveSubject(MultipartFile file){
        try {
            List<List<String>> excelList = PoiExcelUtil.readXlsx(file.getInputStream(), 1, -1, 0);

            excelList.forEach(row -> {
                // One Title
                String oneTitle = row.get(0);
                if (!exitOneSubject(oneTitle)){
                    addTitle(oneTitle, "0", baseMapper.getMaxSort() + 1);
                }

                // Two Title
                String twoTitle = row.get(1);
                if(!exitTwoSubject(twoTitle)){
                    EduSubject oneSubject = baseMapper.getSubjectByTitle(oneTitle);
                    addTitle(twoTitle, oneSubject.getId(), oneSubject.getSort());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Boolean exitOneSubject(String title){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", title);
        wrapper.eq("parent_id", 0);

        return baseMapper.selectList(wrapper).size() > 0;
    }

    private Boolean exitTwoSubject(String title){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", title);

        return baseMapper.selectList(wrapper).size() > 0;
    }

    private void addTitle(String title, String parentID, int sort){
        EduSubject subject = new EduSubject();
        subject.setTitle(title);
        subject.setParentId(parentID);
        subject.setSort(sort);
        baseMapper.insert(subject);
    }

    @Override
    public EduSubject getOneSubjectByID(String id) {
        return baseMapper.getOneSubjectByID(id);
    }

    @Override
    public EduSubject getTwoSubjectByID(String id) {
        return baseMapper.getTwoSubjectByID(id);
    }
}
