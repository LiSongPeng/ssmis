package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by lihuibo on 4/25/17.
 */
@Entity
@IdClass(CommentPK.class)
@Table(name = "comment")
public class Comment {
    private String dpm;
    private String crs;
    private String tch;
    private Date date;
    private String content;
    private Department departmentByDpm;
    private Course courseByCrs;

    @Id
    @Column(name = "dpm")
    public String getDpm() {
        return dpm;
    }

    public void setDpm(String dpm) {
        this.dpm = dpm;
    }

    @Id
    @Column(name = "crs")
    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @Id
    @Column(name = "tch")
    public String getTch() {
        return tch;
    }

    public void setTch(String tch) {
        this.tch = tch;
    }

    @Id
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (dpm != null ? !dpm.equals(comment.dpm) : comment.dpm != null) return false;
        if (crs != null ? !crs.equals(comment.crs) : comment.crs != null) return false;
        if (tch != null ? !tch.equals(comment.tch) : comment.tch != null) return false;
        if (date != null ? !date.equals(comment.date) : comment.date != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpm != null ? dpm.hashCode() : 0;
        result = 31 * result + (crs != null ? crs.hashCode() : 0);
        result = 31 * result + (tch != null ? tch.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dpm", referencedColumnName = "dpm_id", nullable = false,updatable = false,insertable = false)
    public Department getDepartmentByDpm() {
        return departmentByDpm;
    }

    public void setDepartmentByDpm(Department departmentByDpm) {
        this.departmentByDpm = departmentByDpm;
    }

    @ManyToOne
    @JoinColumn(name = "crs", referencedColumnName = "crs_id", nullable = false,updatable = false,insertable = false)
    public Course getCourseByCrs() {
        return courseByCrs;
    }

    public void setCourseByCrs(Course courseByCrs) {
        this.courseByCrs = courseByCrs;
    }
}
