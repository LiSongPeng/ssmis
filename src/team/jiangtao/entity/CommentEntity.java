package team.jiangtao.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "comment", schema = "ssmis", catalog = "")
@IdClass(CommentEntityPK.class)
public class CommentEntity {
    private String dpm;
    private String crs;
    private String tch;
    private Date date;
    private String content;

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
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 128)
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

        CommentEntity that = (CommentEntity) o;

        if (dpm != null ? !dpm.equals(that.dpm) : that.dpm != null) return false;
        if (crs != null ? !crs.equals(that.crs) : that.crs != null) return false;
        if (tch != null ? !tch.equals(that.tch) : that.tch != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

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
}
