package com.neco.pojo;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/2.
 *
 * @author 张小虎
 * @version 1.0
 */
public class School {
    /**
     * 主键
     */
    private String school_no;
    /**
     * 校名
     */
    private String name;
    /**
     * 位置
     */
    private String location;
    /**
     * 建校时间
     */
    private Date establishTime;
    /**
     * 校训
     */
    private String motto;
    /**
     * 学校类型
     */
    private String type;
    /**
     * 课程
     */
    private List<Course> courses;
    /**
     * 学院
     */
    private List<String> college;
    /**
     * 等级
     */
    private String grade;
    /**
     * 校长
     */
    private String principle;
    /**
     * 教职工人数
     */
    private int teacherNumber;
    /**
     * 学生人数
     */
    private int studentNumber;
    /**
     * 后勤人数
     */
    private int logisticsNumber;
    /**
     * 占地面积
     */
    private Double area;
    /**
     * 东西长度
     */
    private Double ewLong;
    /**
     * 南北长度
     */
    private Double nsLong;

    public String getSchool_no() {
        return school_no;
    }

    public void setSchool_no(String school_no) {
        this.school_no = school_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<String> getCollege() {
        return college;
    }

    public void setCollege(List<String> college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public int getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(int teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(int logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getEwLong() {
        return ewLong;
    }

    public void setEwLong(Double ewLong) {
        this.ewLong = ewLong;
    }

    public Double getNsLong() {
        return nsLong;
    }

    public void setNsLong(Double nsLong) {
        this.nsLong = nsLong;
    }
}
