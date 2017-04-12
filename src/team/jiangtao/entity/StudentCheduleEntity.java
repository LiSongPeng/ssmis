package team.jiangtao.entity;

import javax.persistence.*;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "student_chedule", schema = "ssmis", catalog = "")
@IdClass(StudentCheduleEntityPK.class)
public class StudentCheduleEntity {
    private String dpm;
    private String crs;
    private String tch;
    private String stu;
    private byte term;
    private double score;
    private DepartmentEntity departmentByDpm;
    private CourseEntity courseByCrs;
    private StudentEntity studentByStu;

    @Id
    @Column(name = "dpm", nullable = false, length = 8)
    public String getDpm() {
        return dpm;
    }

    public void setDpm(String dpm) {
        this.dpm = dpm;
    }

    @Id
    @Column(name = "crs", nullable = false, length = 8)
    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @Id
    @Column(name = "tch", nullable = false, length = 8)
    public String getTch() {
        return tch;
    }

    public void setTch(String tch) {
        this.tch = tch;
    }

    @Id
    @Column(name = "stu", nullable = false, length = 8)
    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    @Basic
    @Column(name = "term", nullable = false)
    public byte getTerm() {
        return term;
    }

    public void setTerm(byte term) {
        this.term = term;
    }

    @Basic
    @Column(name = "score", nullable = false, precision = 0)
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCheduleEntity that = (StudentCheduleEntity) o;

        if (term != that.term) return false;
        if (Double.compare(that.score, score) != 0) return false;
        if (dpm != null ? !dpm.equals(that.dpm) : that.dpm != null) return false;
        if (crs != null ? !crs.equals(that.crs) : that.crs != null) return false;
        if (tch != null ? !tch.equals(that.tch) : that.tch != null) return false;
        if (stu != null ? !stu.equals(that.stu) : that.stu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dpm != null ? dpm.hashCode() : 0;
        result = 31 * result + (crs != null ? crs.hashCode() : 0);
        result = 31 * result + (tch != null ? tch.hashCode() : 0);
        result = 31 * result + (stu != null ? stu.hashCode() : 0);
        result = 31 * result + (int) term;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dpm", referencedColumnName = "dpm_id", nullable = false)
    public DepartmentEntity getDepartmentByDpm() {
        return departmentByDpm;
    }

    public void setDepartmentByDpm(DepartmentEntity departmentByDpm) {
        this.departmentByDpm = departmentByDpm;
    }

    @ManyToOne
    @JoinColumn(name = "crs", referencedColumnName = "crs_id", nullable = false)
    public CourseEntity getCourseByCrs() {
        return courseByCrs;
    }

    public void setCourseByCrs(CourseEntity courseByCrs) {
        this.courseByCrs = courseByCrs;
    }

    @ManyToOne
    @JoinColumn(name = "stu", referencedColumnName = "stu_id", nullable = false)
    public StudentEntity getStudentByStu() {
        return studentByStu;
    }

    public void setStudentByStu(StudentEntity studentByStu) {
        this.studentByStu = studentByStu;
    }
}
