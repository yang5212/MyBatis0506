package com.mybatis.test;

import com.mybatis.bean.Employee;
import com.mybatis.dao.EmployeeMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author yang
 * @create 2019/5/5 0005
 */
public class EmployeeTest06 {
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
        EmployeeMapper2 emap = sqlSession.getMapper(EmployeeMapper2.class);
        /*
          使用resultMap

        Employee emp1=emap.findEmpById01(1);
        System.out.println("结果: "+emp1);
         */
        /**
         * 2. 查询员工信息，并且把对应的部门信息查询出来

        Employee emp1=emap.findEmpByDept01(1);
        System.out.println("员工信息: "+emp1);
         */
        /*
        3. 分步查询员工的信息
         */
        Employee emp1=emap.findEmpByDept02(1);
        System.out.println("员工信息: "+emp1);
    }
}