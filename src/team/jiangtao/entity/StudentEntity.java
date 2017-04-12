package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "student", schema = "ssmis", catalog = "")
public class StudentEntity {
    private String stuId;
    private String name;
    private String password;
    private String email;
    private String address;
    private String phone;
    private Date birthday;
    private byte gender;
    private byte grade;
    private byte classNo;
    private Byte stuStatus;

    @Id
    @Column(name = "stu_id", nullable = false, length = 8)
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 13)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "grade", nullable = false)
    public byte getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "class_no", nullable = false)
    public byte getClassNo() {
        return classNo;
    }

    public void setClassNo(byte classNo) {
        this.classNo = classNo;
    }

    @Basic
    @Column(name = "stu_status", nullable = true)
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

        StudentEntity that = (StudentEntity) o;

        if (gender != that.gender) return false;
        if (grade != that.grade) return false;
        if (classNo != that.classNo) return false;
        if (stuId != null ? !stuId.equals(that.stuId) : that.stuId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (stuStatus != null ? !stuStatus.equals(that.stuStatus) : that.stuStatus != null) return false;

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
}
