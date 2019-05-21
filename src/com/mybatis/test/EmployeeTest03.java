package com.mybatis.test;
import com.mybatis.bean.Employee;
import com.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 *测试类
 */
public class EmployeeTest03 {
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
        EmployeeMapper emap = sqlSession.getMapper(EmployeeMapper.class);
       /*
         1. 添加操作

        Employee e1=new Employee();
        e1.setLastName("gaoding");
        e1.setGender(0);
        e1.setEmail("gaoding@126.com");
        System.out.println(emap.addEmp(e1));
        */
       /*
       2. 查询所有员工信息

        List<Employee> alls=emap.findAllEmps();
        System.out.println(alls);
        */
       /*
       3. 切换不同的数据库进行操作(Oracle)
        */
       Employee e=new Employee();
       e.setId(2);
        Employee emp1=emap.getEmpById(e);
        System.out.println(emp1);
    }
}