package com.mybatis.bean;

import java.util.List;

/**
 * @author yang
 * @create 2019/5/6 0006
 */
public class Department {
    private int id;
    private String deptName;  //部门名称
    private List<Employee> emps; //员工

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Department() {
    }

    public Department(int id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Department(int id, String deptName, List<Employee> emps) {
        this.id = id;
        this.deptName = deptName;
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
