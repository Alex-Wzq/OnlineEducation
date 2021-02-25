package com.suda.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suda.commonutils.R;
import com.suda.eduService.entity.EduTeacher;
import com.suda.eduService.entity.vo.TeacherQuery;
import com.suda.eduService.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-30
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin(origins = "*", allowCredentials = "true") // 解决跨域
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "查询所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("item",list);
    }

    /**
     * PathVariable : 获取url的值
     * @param id
     * @return
     */
    @ApiOperation(value = "删除ID讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        boolean flag = teacherService.removeById(id);

        return flag ? R.ok() : R.error();
    }

    /**
     *
     * @param current
     * @param limit
     * @return
     */
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable long current,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable long limit){

        Page<EduTeacher> pageTeacher = new Page<EduTeacher>(current, limit);
        teacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }

    /**
     *
     * @param current
     * @param limit
     * @param teacherQuery
     * @return
     */
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    @ApiOperation(value = "带条件分页查询讲师")
    public R pageTeacherCondition(
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable long current,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable long limit,
            @RequestBody(required = false) TeacherQuery teacherQuery){

        Page<EduTeacher> pageTeacher = new Page<EduTeacher>(current, limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if(!StringUtils.isEmpty(name)){
            wrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level", level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create", begin); // 用数据库的列名
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create", end);
        }

        teacherService.page(pageTeacher, wrapper);

        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows", records);

    }

    /**
     *
     * @param eduTeacher
     * @return
     */
    @ApiOperation(value = "增加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        Boolean flag = teacherService.save(eduTeacher);

        return flag ? R.ok():R.error();
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id查询讲师")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(
            @ApiParam(name = "id", value = "讲师Id", required = true)
            @PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher", eduTeacher);
    }

    @PostMapping("updateTeacher")
    @ApiOperation(value = "更新讲师")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        Boolean flag = teacherService.updateById(eduTeacher);

        return flag ? R.ok():R.error();
    }

}

