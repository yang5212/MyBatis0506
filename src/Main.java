/**
 * HelloWorld简单版
 * – 创建一张测试表: employee表
 * Employee类：
 * ---Integer id 编号
 * ---String lastName  名字
 * ---int gender  性别(0,1)
 * ---String email 邮箱
 * <p>
 * 在MySQL中创建对应的数据库表：数据库mybatis
 * create table employee(
 * id int not null primary key auto_increment,
 * last_Name  varchar(20),
 * gender int(1),
 * email varchar(20));
 * <p>
 * – 创建对应的JavaBean
 * – 创建mybatis配置文件，sql映射文件
 * – 测试
 */


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }
}
