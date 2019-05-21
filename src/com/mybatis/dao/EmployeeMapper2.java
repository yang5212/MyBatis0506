package com.mybatis.dao;

import com.mybatis.bean.Employee;

/**
 * @author yang
 * @create 2019/5/6 0006
 */
public interface EmployeeMapper2 {
   //使用select元素
    public Employee findEmpById01(int id);
    /*
     查询员工的信息，包含他所在的部门信息
     */
    public Employee findEmpByDept01(int id);
    //分步查询员工信息，包括部门信息
    public Employee findEmpByDept02(int id);
}
