package com.bw.service;

import com.bw.dao.StuDao;
import com.bw.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StuService {
    @Autowired
    private StuDao stuDao;


    public Page<Stu> mohu(String name, String start, String end, int page, int size) {
        return stuDao.mohu("%"+name+"%",start,end, PageRequest.of(page-1,size));
    }

    public void add(Stu stu) {
        stuDao.save(stu);
    }

    public void del(String id) {
        stuDao.deleteById(id);
    }

    public Stu hui(String id) {
        return stuDao.findById(id).get();
    }

    public void xiu(Stu stu) {
        stuDao.saveAndFlush(stu);
    }
}
