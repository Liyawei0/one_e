package com.bw.dao;

import com.bw.pojo.Stu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StuDao extends JpaRepository<Stu,String > {
    @Query(value = "select * from stu where name like ?1 and ctime>=?2 and ctime<=?3",nativeQuery = true,
    countQuery = "select count(*) from stu")
    Page<Stu> mohu(String s, String start, String end, Pageable of);
}
