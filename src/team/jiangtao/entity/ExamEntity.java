package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "exam", schema = "ssmis", catalog = "")
@IdClass(ExamEntityPK.class)
public class ExamEntity {
    private String dmp;
    private String crs;
    private Date date;
    private String location;
    private byte status;
    private DepartmentEntity departmentByDmp;
    private CourseEntity courseByCrs;

    @Id
    @Column(name = "dmp", nullable = false, length = 8)
    public String getDmp() {
        return dmp;
    }

    public void setDmp(String dmp) {
        this.dmp = dmp;
    }

    @Id
    @Column(name = "crs", nullable = false, length = 8)
    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "location", nullable = false, length = 64)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

        ExamEntity that = (ExamEntity) o;

        if (status != that.status) return false;
        if (dmp != null ? !dmp.equals(that.dmp) : that.dmp != null) return false;
        if (crs != null ? !crs.equals(that.crs) : that.crs != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

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
    public DepartmentEntity getDepartmentByDmp() {
        return departmentByDmp;
    }

    public void setDepartmentByDmp(DepartmentEntity departmentByDmp) {
        this.departmentByDmp = departmentByDmp;
    }

    @ManyToOne
    @JoinColumn(name = "crs", referencedColumnName = "crs_id", nullable = false)
    public CourseEntity getCourseByCrs() {
        return courseByCrs;
    }

    public void setCourseByCrs(CourseEntity courseByCrs) {
        this.courseByCrs = courseByCrs;
    }
}
