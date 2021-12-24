package com.zzg.mybatis.test;

import com.zzg.mybatis.entity.Student;
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
    public void test1() throws Exception {
        int insert = sqlSession.insert("add",new Student(null,"张三",18,"北京",2));
        System.out.println(insert);
    }
    @Test
    public void test2() throws Exception {
        int delete = sqlSession.delete("delete",123);
        System.out.println(delete);
    }
    @Test
    public void test3() throws Exception{
        int update = sqlSession.update("update", new Student(160, "aa", 20, "南京", 2));
        System.out.println(update);
    }
    @Test
    public void list() throws Exception{
        List<Object> list = sqlSession.selectList("list", Student.class);
        System.out.println(list);
    }
    @Test
    public void get()throws Exception {
        Student get = sqlSession.selectOne("get", 165);
        System.out.println(get);
    }

}
