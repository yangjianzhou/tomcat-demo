package com.iwill;


import org.apache.commons.digester.Digester;

import java.io.File;

public class DigesterDemo {

    public static void main(String[] args) {
        Digester digester = new Digester();
        digester.setValidating(false);
        /**
         * 如果遇见标签：department，则创建对象：Department
         */
        digester.addObjectCreate("department", Department.class);
        /**
         * 设置对象department的属性:
         * 对于标签：<department name="deptname001" code ="deptcode001">
         * 会将name和code的值设置到department对象中
         */
        digester.addSetProperties("department");

        /**
         * 如果遇见标签department/user，创建对象User
         */
        digester.addObjectCreate("department/user", User.class);
        digester.addSetProperties("department/user");
        /**
         * 通过调用department对象的addUser方法，将刚才创建的user对象设置到department中
         * 即：将栈顶元素作为参数，调用栈顶后面的元素的方法addUser。
         */
        digester.addSetNext("department/user", "addUser");
        /**
         * 调用栈顶元素的putExtension的有两个参数的方法
         */
        digester.addCallMethod("department/extension", "putExtension", 2);
        digester.addCallParam("department/extension/property-name", 0);
        digester.addCallParam("department/extension/property-value", 1);
        try {
            Department department = (Department) digester.parse(new File("/Users/jiyang12/Github/tomcat-demo/src/main/resources/test.xml"));
            System.out.println(department);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
