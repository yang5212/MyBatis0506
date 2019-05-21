package com.mybatis.test;

import com.mybatis.bean.Department;
import com.mybatis.dao.DepartMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author yang
 * @create 2019/5/5 0005
 */
public class DepartTest01 {
    //静态方法
    public static SqlSessionFactory getSessionFactory() throws Exception {
        String resource = "mybatis-config.xml";
        //输入字符流
        Reader reader = Resources.getResourceAsReader(resource);
        return new SqlSessionFactoryBuilder().build(reader);
    }

    //采用非注解的方式实现CRUD操作
    public static void main(String args[]) throws Exception {
        SqlSession sqlSession = getSessionFactory().openSession(true); //自动提交事务
        DepartMapper dmap=sqlSession.getMapper(DepartMapper.class);
        Department department=dmap.findByDeptEmpId(1);
        System.out.println(department.getDeptName());
        System.out.println(department.getEmps());

    }
}