package com.mybatis.bean;

import org.apache.ibatis.type.Alias;

/**
 * 建立对应的实体类
 */
//若指定了默认的别名后，自己要修改别名，则可以使用注解来完成
    @Alias("ep")//使用该注解配置新的别名主要是为了区分不同包中 存在相同的类的情况
public class Employee {
      private int id;
      private String lastName;
      private int gender; //1表示male, 0表示female
      private String email;
      private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(int id, String lastName, int gender, String email, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.department = department;
    }

    public Employee(int id, String lastName, int gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }
    public Employee( String lastName, int gender, String email) {
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }
    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
