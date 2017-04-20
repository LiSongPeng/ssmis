package team.jiangtao.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by lihuibo on 4/20/17.
 */
@Entity
public class Course {
    private String crsId;
    private String crsName;
    private String summarization;
    private Collection<Exam> examsByCrsId;
    private Collection<Appeal> appealsByCrsId;
    private Collection<Comment> commentsByCrsId;
    private Collection<CourseSchedule> courseSchedulesByCrsId;
    private Collection<CoursesTable> coursesTablesByCrsId;
    private Collection<StudentSchedule> studentSchedulesByCrsId;

    @Id
    @Column(name = "crs_id")
    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @Basic
    @Column(name = "crs_name")
    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }

    @Basic
    @Column(name = "summarization")
    public String getSummarization() {
        return summarization;
    }

    public void setSummarization(String summarization) {
        this.summarization = summarization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (crsId != null ? !crsId.equals(course.crsId) : course.crsId != null) return false;
        if (crsName != null ? !crsName.equals(course.crsName) : course.crsName != null) return false;
        if (summarization != null ? !summarization.equals(course.summarization) : course.summarization != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = crsId != null ? crsId.hashCode() : 0;
        result = 31 * result + (crsName != null ? crsName.hashCode() : 0);
        result = 31 * result + (summarization != null ? summarization.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "courseByCrs")
    public Collection<Exam> getExamsByCrsId() {
        return examsByCrsId;
    }

    public void setExamsByCrsId(Collection<Exam> examsByCrsId) {
        this.examsByCrsId = examsByCrsId;
    }

    @OneToMany(mappedBy = "courseByCrsId")
    public Collection<Appeal> getAppealsByCrsId() {
        return appealsByCrsId;
    }

    public void setAppealsByCrsId(Collection<Appeal> appealsByCrsId) {
        this.appealsByCrsId = appealsByCrsId;
    }

    @OneToMany(mappedBy = "courseByCrs")
    public Collection<Comment> getCommentsByCrsId() {
        return commentsByCrsId;
    }

    public void setCommentsByCrsId(Collection<Comment> commentsByCrsId) {
        this.commentsByCrsId = commentsByCrsId;
    }

    @OneToMany(mappedBy = "courseByCrsId")
    public Collection<CourseSchedule> getCourseSchedulesByCrsId() {
        return courseSchedulesByCrsId;
    }

    public void setCourseSchedulesByCrsId(Collection<CourseSchedule> courseSchedulesByCrsId) {
        this.courseSchedulesByCrsId = courseSchedulesByCrsId;
    }

    @OneToMany(mappedBy = "courseByCrsId")
    public Collection<CoursesTable> getCoursesTablesByCrsId() {
        return coursesTablesByCrsId;
    }

    public void setCoursesTablesByCrsId(Collection<CoursesTable> coursesTablesByCrsId) {
        this.coursesTablesByCrsId = coursesTablesByCrsId;
    }

    @OneToMany(mappedBy = "courseByCrs")
    public Collection<StudentSchedule> getStudentSchedulesByCrsId() {
        return studentSchedulesByCrsId;
    }

    public void setStudentSchedulesByCrsId(Collection<StudentSchedule> studentSchedulesByCrsId) {
        this.studentSchedulesByCrsId = studentSchedulesByCrsId;
    }
}
