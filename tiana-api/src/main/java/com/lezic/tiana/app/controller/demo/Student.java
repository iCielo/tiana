/**
 * lincl
 * 2016年8月26日 下午3:24:52
 * 
 */
package com.lezic.tiana.app.controller.demo;

import java.io.Serializable;

/**
 * 学生
 * 
 * @author lincl
 * 
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 姓名 */
    private String name;

    /** 性别 */
    private String sex;

    /** 年龄 */
    private Integer age;

    /** 年级 */
    private String grade;
    
    
    public Student() {
        super();
    }

    public Student(Long id, String name, String sex, int age, String grade) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;

    }

}
