package com.bw.controller;

import com.bw.pojo.Stu;
import com.bw.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import util.PageUtil;

@RestController
@RequestMapping("/stu")
@CrossOrigin
public class StuController {
    @Autowired
    private StuService stuService;

    //查询
    @GetMapping("/list")
    public PageUtil<Stu> mohu(
            @RequestParam(value = "name",defaultValue = "",required = false) String name,
            @RequestParam(value = "start",defaultValue = "2000-01-01") String start,
            @RequestParam(value = "end",defaultValue = "2222-01-01") String end,
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "3") int size
    ){
        Page<Stu> mohu = stuService.mohu(name,start,end,page,size);
        return new PageUtil<Stu>(page,mohu.getTotalElements(),mohu.getContent(),size);
    }

    //添加
    @PostMapping("/add")
    public void add(@RequestBody Stu stu){
        stuService.add(stu);
    }

    //删除
    @DeleteMapping("/del")
    public void del(String id){
        stuService.del(id);
    }

    //回显
    @GetMapping("/hui")
    public Stu hui(String id){
        return stuService.hui(id);
    }

    //修改
    @PutMapping("/xiu")
    public void xiu(@RequestBody Stu stu){
        stuService.xiu(stu);
    }


}
