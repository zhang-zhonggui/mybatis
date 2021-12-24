package com.zzg.mybatis.test;

import com.zzg.mybatis.entity.Student;
import com.zzg.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: zzg
 * @Description: 测速mybatis
 * @DateTime: 2021/11/27 9:58
 */
public class JavaTest {
    private SqlSession sqlSession = null;

    @Before
    public void bigen() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void end() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test() throws Exception {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int delete = mapper.delete(168);
        System.out.println(delete);
    }

    @Test
    public void test1() {
        Student student = new Student(null, "张三", 18, "北京", 2);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int add = mapper.add(student);
        System.out.println(add);
    }

    @Test
    public void test2() {
        Student student = new Student(168, "张三", 18, "北京", 2);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.update(student);
        System.out.println(i);
    }

    @Test
    public void test3() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.get(169);
        System.out.println(student);
    }

    @Test
    public void test4() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.list();
        System.out.println(list);
    }


}
