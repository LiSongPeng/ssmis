package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by lihuibo on 4/25/17.
 */
@Entity
@IdClass(ExamPK.class)
public class Exam {
    private String dpm;
    private String crs;
    private String date;//06月01日13:30-15:00
    private String location;
    private byte status;//0 未编排,1 编排中,2未开始,3 已结束
    private Department departmentByDpm;
    private Course courseByCrs;

    @Id
    @Column(name = "dpm")
    public String getDpm() {
        return dpm;
    }

    public void setDpm(String dpm) {
        this.dpm = dpm;
    }

    @Id
    @Column(name = "crs")
    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "status")
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

        Exam exam = (Exam) o;

        if (status != exam.status) return false;
        if (dpm != null ? !dpm.equals(exam.dpm) : exam.dpm != null) return false;
        if (crs != null ? !crs.equals(exam.crs) : exam.crs != null) return false;
        if (date != null ? !date.equals(exam.date) : exam.date != null) return false;
        if (location != null ? !location.equals(exam.location) : exam.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpm != null ? dpm.hashCode() : 0;
        result = 31 * result + (crs != null ? crs.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (int) status;
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dpm", referencedColumnName = "dpm_id", nullable = false, updatable = false, insertable = false)
    public Department getDepartmentByDpm() {
        return departmentByDpm;
    }

    public void setDepartmentByDpm(Department departmentByDpm) {
        this.departmentByDpm = departmentByDpm;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crs", referencedColumnName = "crs_id", nullable = false, updatable = false, insertable = false)
    public Course getCourseByCrs() {
        return courseByCrs;
    }

    public void setCourseByCrs(Course courseByCrs) {
        this.courseByCrs = courseByCrs;
    }
}
