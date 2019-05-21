package com.mybatis.test;
import com.mybatis.bean.Employee;
import com.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.*;
/**
 *测试类
 */
public class EmployeeTest02 {
    //静态方法
    public static SqlSessionFactory getSessionFactory() throws Exception{
        String resource = "mybatis-config.xml";
        //输入字符流
        Reader reader = Resources.getResourceAsReader(resource);

        SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(reader);
        return sqlSessionFactory;
    }
    public static void main(String args[]) throws Exception{
        SqlSession sqlSession=getSessionFactory().openSession(true); //自动提交事务
        EmployeeMapper emap=sqlSession.getMapper(EmployeeMapper.class);
        /*
        1.
        验证驼峰命名规则
           Employee e1=new Employee();
        e1.setId(1);
        Employee emp1=emap.getEmpById2(e1);
        System.out.println("emp1= "+emp1);
         */
       /*
        2.验证不同数据库之间的切换
        */
        Employee e1=new Employee();
        e1.setId(1);
        Employee emp1=emap.getEmpById(e1);
        System.out.println("emp1= "+emp1);
    }
}
