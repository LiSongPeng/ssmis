package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "appeal", schema = "ssmis", catalog = "")
@IdClass(AppealEntityPK.class)
public class AppealEntity {
    private String dpmId;
    private String crsId;
    private String tchId;
    private String stuId;
    private Date date;
    private String content;
    private String response;
    private byte status;
    private DepartmentEntity departmentByDpmId;
    private TeacherEntity teacherByTchId;
    private StudentEntity studentByStuId;

    @Id
    @Column(name = "dpm_id", nullable = false, length = 8)
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Id
    @Column(name = "crs_id", nullable = false, length = 8)
    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @Id
    @Column(name = "tch_id", nullable = false, length = 8)
    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    @Id
    @Column(name = "stu_id", nullable = false, length = 8)
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Id
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 128)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "response", nullable = true, length = 128)
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppealEntity that = (AppealEntity) o;

        if (status != that.status) return false;
        if (dpmId != null ? !dpmId.equals(that.dpmId) : that.dpmId != null) return false;
        if (crsId != null ? !crsId.equals(that.crsId) : that.crsId != null) return false;
        if (tchId != null ? !tchId.equals(that.tchId) : that.tchId != null) return false;
        if (stuId != null ? !stuId.equals(that.stuId) : that.stuId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpmId != null ? dpmId.hashCode() : 0;
        result = 31 * result + (crsId != null ? crsId.hashCode() : 0);
        result = 31 * result + (tchId != null ? tchId.hashCode() : 0);
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (int) status;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dpm_id", referencedColumnName = "dpm_id", nullable = false)
    public DepartmentEntity getDepartmentByDpmId() {
        return departmentByDpmId;
    }

    public void setDepartmentByDpmId(DepartmentEntity departmentByDpmId) {
        this.departmentByDpmId = departmentByDpmId;
    }

    @ManyToOne
    @JoinColumn(name = "tch_id", referencedColumnName = "tch_id", nullable = false)
    public TeacherEntity getTeacherByTchId() {
        return teacherByTchId;
    }

    public void setTeacherByTchId(TeacherEntity teacherByTchId) {
        this.teacherByTchId = teacherByTchId;
    }

    @ManyToOne
    @JoinColumn(name = "stu_id", referencedColumnName = "stu_id", nullable = false)
    public StudentEntity getStudentByStuId() {
        return studentByStuId;
    }

    public void setStudentByStuId(StudentEntity studentByStuId) {
        this.studentByStuId = studentByStuId;
    }
}
