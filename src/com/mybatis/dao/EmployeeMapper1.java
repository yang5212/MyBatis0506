package com.mybatis.dao;

import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import java.util.*;
/**
 * @author yang
 * @create 2019/5/5 0005
 */
public interface EmployeeMapper1 {
    //返回Map集合
    @MapKey("id")
    public Map<Integer,List<Employee>> findAllEmpsListLike3(String lastName);
   //返回Map集合
    public Map<String,Object> findAllEmpsListLike2(int id);
    //返回的是集合类型
    public List<Employee> findAllEmpsListLike1(String lastName);

    //• #{key}：获取参数的值，预编译到SQL中。安全。
    //• ${key}：获取参数的值，拼接到SQL中。有SQL注入问
    public Employee findEmpByIdName2(int id,String lastName);

    //以Map集合作为参数来传递
    @MapKey("id")  //指定映射的主键
    public Employee findEmpByMap(Map<String,Object> map);

    //POJO作为参数传递：参数都是POJO类中的属性
    public Employee findEmpByIdName1(Employee employee);
    //命名参数
    public Employee findEmpByIdName(@Param("id") int id, @Param("lastName")String lastName);
    //多个参数传递
    //public Employee findEmpByIdName(int id,String lastName);

    //添加方法(主键自动生成: Oracle和MySQL)
    public void addEmp01(Employee employee);

}
