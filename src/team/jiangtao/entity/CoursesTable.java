package team.jiangtao.entity;

import javax.persistence.*;

/**
 * Created by lihuibo on 4/25/17.
 */
@Entity
@Table(name = "courses_table", schema = "ssmis", catalog = "")
@IdClass(CoursesTablePK.class)
public class CoursesTable {
    private String dpmId;
    private String crsId;
    private String tchId;
    private String weeks;//1,2,3,5 代表第1,2,3,5周有课
    private String off;//一天11节课,一周55节,0,33 代表第1节,第34节有课
    private String site;//上课地点,1-7(单周):B208,8-16周(双周):C408代表对应的上课地点
    private Department departmentByDpmId;
    private Course courseByCrsId;
    private Teacher teacherByTchId;

    @Id
    @Column(name = "dpm_id")
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Id
    @Column(name = "crs_id")
    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @Id
    @Column(name = "tch_id")
    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    @Basic
    @Column(name = "weeks")
    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    @Basic
    @Column(name = "off")
    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

    @Basic
    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesTable that = (CoursesTable) o;

        if (dpmId != null ? !dpmId.equals(that.dpmId) : that.dpmId != null) return false;
        if (crsId != null ? !crsId.equals(that.crsId) : that.crsId != null) return false;
        if (tchId != null ? !tchId.equals(that.tchId) : that.tchId != null) return false;
        if (weeks != null ? !weeks.equals(that.weeks) : that.weeks != null) return false;
        if (off != null ? !off.equals(that.off) : that.off != null) return false;
        if (site != null ? !site.equals(that.site) : that.site != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = dpmId != null ? dpmId.hashCode() : 0;
        result = 31 * result + (crsId != null ? crsId.hashCode() : 0);
        result = 31 * result + (tchId != null ? tchId.hashCode() : 0);
        result = 31 * result + (weeks != null ? weeks.hashCode() : 0);
        result = 31 * result + (off != null ? off.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dpm_id", referencedColumnName = "dpm_id", nullable = false, updatable = false, insertable = false)
    public Department getDepartmentByDpmId() {
        return departmentByDpmId;
    }

    public void setDepartmentByDpmId(Department departmentByDpmId) {
        this.departmentByDpmId = departmentByDpmId;
    }

    @ManyToOne
    @JoinColumn(name = "crs_id", referencedColumnName = "crs_id", nullable = false, updatable = false, insertable = false)
    public Course getCourseByCrsId() {
        return courseByCrsId;
    }

    public void setCourseByCrsId(Course courseByCrsId) {
        this.courseByCrsId = courseByCrsId;
    }

    @ManyToOne
    @JoinColumn(name = "tch_id", referencedColumnName = "tch_id", nullable = false, updatable = false, insertable = false)
    public Teacher getTeacherByTchId() {
        return teacherByTchId;
    }

    public void setTeacherByTchId(Teacher teacherByTchId) {
        this.teacherByTchId = teacherByTchId;
    }
}
