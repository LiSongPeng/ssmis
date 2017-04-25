package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by lihuibo on 4/25/17.
 */
@Entity
public class Student {
    private String stuId;
    private String name;
    private String password;
    private String email;
    private String address;
    private String phone;
    private Date birthday;
    private byte gender;
    private short grade;
    private byte classNo;
    private Byte stuStatus;
    private Collection<Appeal> appealsByStuId;
    private Collection<StudentSchedule> studentSchedulesByStuId;

    @Id
    @Column(name = "stu_id")
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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
    @Column(name = "grade")
    public short getGrade() {
        return grade;
    }

    public void setGrade(short grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "class_no")
    public byte getClassNo() {
        return classNo;
    }

    public void setClassNo(byte classNo) {
        this.classNo = classNo;
    }

    @Basic
    @Column(name = "stu_status")
    public Byte getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(Byte stuStatus) {
        this.stuStatus = stuStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (gender != student.gender) return false;
        if (grade != student.grade) return false;
        if (classNo != student.classNo) return false;
        if (stuId != null ? !stuId.equals(student.stuId) : student.stuId != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (password != null ? !password.equals(student.password) : student.password != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        if (stuStatus != null ? !stuStatus.equals(student.stuStatus) : student.stuStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuId != null ? stuId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (int) gender;
        result = 31 * result + (int) grade;
        result = 31 * result + (int) classNo;
        result = 31 * result + (stuStatus != null ? stuStatus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentByStuId")
    public Collection<Appeal> getAppealsByStuId() {
        return appealsByStuId;
    }

    public void setAppealsByStuId(Collection<Appeal> appealsByStuId) {
        this.appealsByStuId = appealsByStuId;
    }

    @OneToMany(mappedBy = "studentByStu")
    public Collection<StudentSchedule> getStudentSchedulesByStuId() {
        return studentSchedulesByStuId;
    }

    public void setStudentSchedulesByStuId(Collection<StudentSchedule> studentSchedulesByStuId) {
        this.studentSchedulesByStuId = studentSchedulesByStuId;
    }
}
