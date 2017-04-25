package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by lihuibo on 4/25/17.
 */
@Entity
@IdClass(ExamPK.class)
public class Exam {
    private String dmp;
    private String crs;
    private Date date;
    private String location;
    private byte status;
    private Department departmentByDmp;
    private Course courseByCrs;

    @Id
    @Column(name = "dmp")
    public String getDmp() {
        return dmp;
    }

    public void setDmp(String dmp) {
        this.dmp = dmp;
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
        if (dmp != null ? !dmp.equals(exam.dmp) : exam.dmp != null) return false;
        if (crs != null ? !crs.equals(exam.crs) : exam.crs != null) return false;
        if (date != null ? !date.equals(exam.date) : exam.date != null) return false;
        if (location != null ? !location.equals(exam.location) : exam.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dmp != null ? dmp.hashCode() : 0;
        result = 31 * result + (crs != null ? crs.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (int) status;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dmp", referencedColumnName = "dpm_id", nullable = false)
    public Department getDepartmentByDmp() {
        return departmentByDmp;
    }

    public void setDepartmentByDmp(Department departmentByDmp) {
        this.departmentByDmp = departmentByDmp;
    }

    @ManyToOne
    @JoinColumn(name = "crs", referencedColumnName = "crs_id", nullable = false)
    public Course getCourseByCrs() {
        return courseByCrs;
    }

    public void setCourseByCrs(Course courseByCrs) {
        this.courseByCrs = courseByCrs;
    }
}
