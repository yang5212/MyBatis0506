package com.mybatis.test;

import com.mybatis.bean.Employee;
import com.mybatis.dao.EmployeeMapper1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author yang
 * @create 2019/5/5 0005
 */
public class EmployeeTest04 {
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
        /*
         1. 验证mySQL中的主键自动生成

        //emap.addEmp01(new Employee("yangding",1,"adyadf@qq.com"));  //测试mysql环境\
        //Oracle环境

        Employee emp=new Employee();
        emp.setEmail("xiaofei@126.com");
        emp.setLastName("xiaofei");
        emp.setGender(0);
        emap.addEmp01(emp);
         */
        /*
        2. 多个参数:

        Employee emp=emap.findEmpByIdName(1,"wangping");
        System.out.println("结果为: "+emp);
        */
        /*
        3. POJO作为方法的参数

        Employee emp1=new Employee();
        emp1.setId(1);
        emp1.setLastName("wangping");
        Employee emp=emap.findEmpByIdName1(emp1);
        System.out.println("结果为: "+emp);
        */
        /*
        4. 以Map集合作为方法的参数

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",1);
        map.put("lastName","wangping");
        Employee emp1=emap.findEmpByMap(map);
        System.out.println("结果: "+emp1);
       */
        /*
        5. #{}和${}两者的比较
         */
        Employee emp1=emap.findEmpByIdName2(1,"wangping");
        System.out.println("结果: "+emp1);
    }
}
