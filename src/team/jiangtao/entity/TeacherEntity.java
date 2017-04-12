package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "teacher", schema = "ssmis", catalog = "")
public class TeacherEntity {
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
    private DepartmentEntity departmentByDpmId;

    @Id
    @Column(name = "tch_id", nullable = false, length = 8)
    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
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
    @Column(name = "biography", nullable = true, length = 128)
    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Basic
    @Column(name = "tch_status", nullable = false)
    public byte getTchStatus() {
        return tchStatus;
    }

    public void setTchStatus(byte tchStatus) {
        this.tchStatus = tchStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity that = (TeacherEntity) o;

        if (gender != that.gender) return false;
        if (tchStatus != that.tchStatus) return false;
        if (tchId != null ? !tchId.equals(that.tchId) : that.tchId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (biography != null ? !biography.equals(that.biography) : that.biography != null) return false;

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
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dpm_id", referencedColumnName = "dpm_id", nullable = false)
    public DepartmentEntity getDepartmentByDpmId() {
        return departmentByDpmId;
    }

    public void setDepartmentByDpmId(DepartmentEntity departmentByDpmId) {
        this.departmentByDpmId = departmentByDpmId;
    }
}
