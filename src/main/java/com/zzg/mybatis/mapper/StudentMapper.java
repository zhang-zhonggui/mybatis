package com.zzg.mybatis.mapper;

import com.zzg.mybatis.entity.Student;

import java.util.List;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public interface StudentMapper {
    int delete(int id);

    int update(Student student);

    int add(Student student);

    Student get(int id);

    List<Student> list();

}
