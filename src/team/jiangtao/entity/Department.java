package team.jiangtao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by lihuibo on 4/25/17.
 */
@Entity
@Table(name = "department")
public class Department {
    private String dpmId;
    private String dpmName;
    private Collection<Exam> examsByDpmId;
    private Collection<Teacher> teachersByDpmId;
    private Collection<Appeal> appealsByDpmId;
    private Collection<Comment> commentsByDpmId;
    private Collection<CourseSchedule> courseSchedulesByDpmId;
    private Collection<CoursesTable> coursesTablesByDpmId;
    private Collection<StudentSchedule> studentSchedulesByDpmId;

    @Id
    @Column(name = "dpm_id")
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Basic
    @Column(name = "dpm_name")
    public String getDpmName() {
        return dpmName;
    }

    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (dpmId != null ? !dpmId.equals(that.dpmId) : that.dpmId != null) return false;
        if (dpmName != null ? !dpmName.equals(that.dpmName) : that.dpmName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpmId != null ? dpmId.hashCode() : 0;
        result = 31 * result + (dpmName != null ? dpmName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "departmentByDpm")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<Exam> getExamsByDpmId() {
        return examsByDpmId;
    }

    public void setExamsByDpmId(Collection<Exam> examsByDpmId) {
        this.examsByDpmId = examsByDpmId;
    }

    @OneToMany(mappedBy = "departmentByDpmId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<Teacher> getTeachersByDpmId() {
        return teachersByDpmId;
    }

    public void setTeachersByDpmId(Collection<Teacher> teachersByDpmId) {
        this.teachersByDpmId = teachersByDpmId;
    }

    @OneToMany(mappedBy = "departmentByDpmId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<Appeal> getAppealsByDpmId() {
        return appealsByDpmId;
    }

    public void setAppealsByDpmId(Collection<Appeal> appealsByDpmId) {
        this.appealsByDpmId = appealsByDpmId;
    }

    @OneToMany(mappedBy = "departmentByDpm")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<Comment> getCommentsByDpmId() {
        return commentsByDpmId;
    }

    public void setCommentsByDpmId(Collection<Comment> commentsByDpmId) {
        this.commentsByDpmId = commentsByDpmId;
    }

    @OneToMany(mappedBy = "departmentByDpmId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<CourseSchedule> getCourseSchedulesByDpmId() {
        return courseSchedulesByDpmId;
    }

    public void setCourseSchedulesByDpmId(Collection<CourseSchedule> courseSchedulesByDpmId) {
        this.courseSchedulesByDpmId = courseSchedulesByDpmId;
    }

    @OneToMany(mappedBy = "departmentByDpmId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<CoursesTable> getCoursesTablesByDpmId() {
        return coursesTablesByDpmId;
    }

    public void setCoursesTablesByDpmId(Collection<CoursesTable> coursesTablesByDpmId) {
        this.coursesTablesByDpmId = coursesTablesByDpmId;
    }

    @OneToMany(mappedBy = "departmentByDpm")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<StudentSchedule> getStudentSchedulesByDpmId() {
        return studentSchedulesByDpmId;
    }

    public void setStudentSchedulesByDpmId(Collection<StudentSchedule> studentSchedulesByDpmId) {
        this.studentSchedulesByDpmId = studentSchedulesByDpmId;
    }
}
