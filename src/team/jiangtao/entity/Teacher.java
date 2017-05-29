package team.jiangtao.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by lihuibo on 4/25/17.
 */
@Entity
public class Teacher {
    private String tchId;
    private String name;
    private String password;
    private String email;
    private String address;
    private String phone;
    private Date birthday;
    private byte gender;
    private String biography;
    private byte tchStatus;
    private String dpmId;
    private Department departmentByDpmId;
    private Collection<CourseSchedule> courseSchedulesByTchId;
    private Collection<CoursesTable> coursesTablesByTchId;
    private Collection<StudentSchedule> studentSchedulesByTchId;

    @Id
    @Column(name = "tch_id")
    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "gender")
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "biography")
    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Basic
    @Column(name = "tch_status")
    public byte getTchStatus() {
        return tchStatus;
    }

    public void setTchStatus(byte tchStatus) {
        this.tchStatus = tchStatus;
    }

    @Basic
    @Column(name = "dpm_id")
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (gender != teacher.gender) return false;
        if (tchStatus != teacher.tchStatus) return false;
        if (tchId != null ? !tchId.equals(teacher.tchId) : teacher.tchId != null) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (password != null ? !password.equals(teacher.password) : teacher.password != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        if (address != null ? !address.equals(teacher.address) : teacher.address != null) return false;
        if (phone != null ? !phone.equals(teacher.phone) : teacher.phone != null) return false;
        if (birthday != null ? !birthday.equals(teacher.birthday) : teacher.birthday != null) return false;
        if (biography != null ? !biography.equals(teacher.biography) : teacher.biography != null) return false;
        if (dpmId != null ? !dpmId.equals(teacher.dpmId) : teacher.dpmId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tchId != null ? tchId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (int) gender;
        result = 31 * result + (biography != null ? biography.hashCode() : 0);
        result = 31 * result + (int) tchStatus;
        result = 31 * result + (dpmId != null ? dpmId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dpm_id", referencedColumnName = "dpm_id", nullable = false,updatable = false,insertable = false)
    public Department getDepartmentByDpmId() {
        return departmentByDpmId;
    }

    public void setDepartmentByDpmId(Department departmentByDpmId) {
        this.departmentByDpmId = departmentByDpmId;
    }

    @OneToMany(mappedBy = "teacherByTchId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<CourseSchedule> getCourseSchedulesByTchId() {
        return courseSchedulesByTchId;
    }

    public void setCourseSchedulesByTchId(Collection<CourseSchedule> courseSchedulesByTchId) {
        this.courseSchedulesByTchId = courseSchedulesByTchId;
    }

    @OneToMany(mappedBy = "teacherByTchId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<CoursesTable> getCoursesTablesByTchId() {
        return coursesTablesByTchId;
    }

    public void setCoursesTablesByTchId(Collection<CoursesTable> coursesTablesByTchId) {
        this.coursesTablesByTchId = coursesTablesByTchId;
    }

    @OneToMany(mappedBy = "teacherByTch")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<StudentSchedule> getStudentSchedulesByTchId() {
        return studentSchedulesByTchId;
    }

    public void setStudentSchedulesByTchId(Collection<StudentSchedule> studentSchedulesByTchId) {
        this.studentSchedulesByTchId = studentSchedulesByTchId;
    }
}
