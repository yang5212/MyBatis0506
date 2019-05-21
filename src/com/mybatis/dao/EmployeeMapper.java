package com.mybatis.dao;

import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//接口
public interface EmployeeMapper {
    //--------------------非注解方式实现----------------
    //根据ID来查询员工
    public Employee  getEmpById(Employee employee);
    //验证驼峰命名规则
    public Employee  getEmpById2(Employee employee);
    //添加操作
    public boolean addEmp(Employee employee);
    //修改操作
    public boolean modifyEmp(Employee employee);
    //删除操作
    public boolean deleteEmp(int id);
    //查询所有的元素
    public List<Employee> findAllEmps();


    //-----------------------使用注解来实现操作
    // 一般：实现一些简单的SQL操作的时候，用注解实现更简单；复杂的操作建议用映射文件来实现。
    // ---------------------
    //查询操作
    @Select("select id,last_Name lastName,gender,email from employee where id=#{id}")
    public Employee  getEmpById1(int id);
    //添加操作
    @Insert("insert into employee values(#{id},#{lastName},#{gender},#{email})")
    public boolean addEmp1(Employee emp);
    //修改
    @Update("update employee set last_name=#{lastName} where id=#{id}")
    public int update1(Employee emp);
    //删除
    @Delete("delete from employee where id=#{id}")
    public int delete1(int id);

}
