package com.mybatis.test;

import com.mybatis.bean.Employee;
import com.mybatis.dao.EmployeeMapper1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * @author yang
 * @create 2019/5/5 0005
 */
public class EmployeeTest05 {
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
        EmployeeMapper1 emap = sqlSession.getMapper(EmployeeMapper1.class);
    //--------------------------------2019.5.6操作的代码--------------------------------
        /*
        1. 返回的是一个List集合

        List<Employee>  alls=emap.findAllEmpsListLike1("%a%");
        System.out.println("结果: "+alls);
       */
        /*
        2. 返回的是一个Map集合

        Map<String,Object> maps=emap.findAllEmpsListLike2(1);
        System.out.println("集合1："+maps);
          */
        /*
        3. 返回Map集合
         */
        Map<Integer, List<Employee>> maps=emap.findAllEmpsListLike3("%a%");
        System.out.println("集合2："+maps.keySet());
        System.out.println("集合2："+maps.values());
    }
}