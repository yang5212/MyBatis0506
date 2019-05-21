package com.mybatis.dao;

import com.mybatis.bean.Department;

/**
 * @author yang
 * @create 2019/5/6 0006
 */
public interface DepartMapper {
  //根据部门的编号来查询部门信息
    public Department findByDeptId(int d);
    //查询部门的信息，包括该部门的员工信息
    public Department findByDeptEmpId(int id);
}
