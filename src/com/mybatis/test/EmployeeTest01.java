package com.mybatis.test;
import com.mybatis.bean.Employee;
import com.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.Reader;


public class EmployeeTest01 {
    /**
     * SqlSession对应的线程不安全，所有不建议把SqlSession或SqlSessionFactory放在
     * 类中作为成员变量
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception{
        String resource = "mybatis-config.xml";
        //输入字符流
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory ssFactory = new SqlSessionFactoryBuilder().build(reader);
        //使用openSession( )方法的时候，若参数不给，或参数为false,表示事务不自动提交
        //若openSession()参数为true的话，则表示事务会自动提交
        SqlSession session=ssFactory.openSession(true);
        /*
          selectOne()方法参数是Object类型，不安全
           下面的写法不建议使用
        Employee employee=(Employee)session.selectOne("com.mybatis.dao.EmployeeMapper.getEmpById",1);
        System.out.println("emp= "+employee);
         */
        /*
         接口编程

        EmployeeMapper emap=(EmployeeMapper)session.getMapper(com.mybatis.dao.EmployeeMapper.class);
        Employee emp=new Employee();
        emp.setId(1);
        Employee employee=emap.getEmpById(emp);
        System.out.println("结果为: "+employee);
         */

        /*
        注解实现:
        SqlSession和Connection非常相似，表示操作数据库的一个会话
        什么时候使用注解？什么时候使用XML映射文件来配置实现？
          --1. 当SQL语句比较简单的情况下，使用注解来实现更简单
          --2. 当SQL语句复杂的情况，使用XML映射文件来配置实现

        //-------------查询-------
        EmployeeMapper emap=(EmployeeMapper)session.getMapper(com.mybatis.dao.EmployeeMapper.class);
        Employee e1=emap.getEmpById1(1);
        System.out.println("结果为: "+e1);
        //-------------添加---------
        Employee emp1=new Employee();
        emp1.setEmail("lisid@126.com");
        emp1.setGender(1);
        emp1.setLastName("sfaflisi");
        boolean f=emap.addEmp1(emp1); //添加操作
        System.out.println("f= "+f);
       // session.commit();
       */
        /*
        修改操作:注解实现
         */
        EmployeeMapper emap=(EmployeeMapper)session.getMapper(com.mybatis.dao.EmployeeMapper.class);
        Employee e2=new Employee();
        e2.setLastName("wangping");
        e2.setId(1);
        int k=emap.update1(e2);
        System.out.println("k= "+k);
        //---------------删除操作
        int k1=emap.delete1(11);
        System.out.println("k1= "+k1);
        session.close();
    }
}

