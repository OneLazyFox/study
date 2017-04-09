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
public class College {
    /**
     * 学院名称
     */
    private String name;
    /**
     * 学院建立时间
     */
    private Date establishTime;
    /**
     * 院长
     */
    private String dean;
    /**
     * 教职工人数
     */
    private int teacherNumber;
    /**
     * 学生人数
     */
    private int studentNumber;
    /**
     * 班级
     */
    private List<Clazz> clazz;
    /**
     * 学年制
     */
    private int studyYears;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
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

    public List<Clazz> getClazz() {
        return clazz;
    }

    public void setClazz(List<Clazz> clazz) {
        this.clazz = clazz;
    }

    public int getStudyYears() {
        return studyYears;
    }

    public void setStudyYears(int studyYears) {
        this.studyYears = studyYears;
    }
}
