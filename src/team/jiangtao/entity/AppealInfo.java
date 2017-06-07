package team.jiangtao.entity;

import java.sql.Date;

/**
 * Created by tose on 2017/6/5.
 */
public class AppealInfo {
    protected String dpmId;
    protected String crsId;
    protected String tchId;
    protected String stuId;
    protected Date date;
    protected String content;
    protected String response;
    protected byte status;//0 新的复查 1已读  3 更新的 4 已回执的 5 关闭的 6 草稿
    protected String departmentName;
    protected String teacherName;
    protected String studentName;
    private byte stuGender;
    private short stuGrade;
    private byte stuClassNo;

    public AppealInfo(String dpmId, String crsId, String tchId, String stuId, Date date, String content, String response, byte status, String departmentName, String teacherName, String studentName, byte stuGender, short stuGrade, byte stuClassNo) {
        this.dpmId = dpmId;
        this.crsId = crsId;
        this.tchId = tchId;
        this.stuId = stuId;
        this.date = date;
        this.content = content;
        this.response = response;
        this.status = status;
        this.departmentName = departmentName;
        this.teacherName = teacherName;
        this.studentName = studentName;
        this.stuGender = stuGender;
        this.stuGrade = stuGrade;
        this.stuClassNo = stuClassNo;
    }

    public AppealInfo() {
    }

    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public byte getStuGender() {
        return stuGender;
    }

    public void setStuGender(byte stuGender) {
        this.stuGender = stuGender;
    }

    public short getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(short stuGrade) {
        this.stuGrade = stuGrade;
    }

    public byte getStuClassNo() {
        return stuClassNo;
    }

    public void setStuClassNo(byte stuClassNo) {
        this.stuClassNo = stuClassNo;
    }
}
