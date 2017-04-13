package team.jiangtao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by tose on 2017/4/13.
 */
public class CommentPK implements Serializable {
    private String dpm;
    private String crs;
    private String tch;
    private Date date;

    @Column(name = "dpm", nullable = false, length = 8)
    @Id
    public String getDpm() {
        return dpm;
    }

    public void setDpm(String dpm) {
        this.dpm = dpm;
    }

    @Column(name = "crs", nullable = false, length = 8)
    @Id
    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @Column(name = "tch", nullable = false, length = 8)
    @Id
    public String getTch() {
        return tch;
    }

    public void setTch(String tch) {
        this.tch = tch;
    }

    @Column(name = "date", nullable = false)
    @Id
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentPK commentPK = (CommentPK) o;

        if (dpm != null ? !dpm.equals(commentPK.dpm) : commentPK.dpm != null) return false;
        if (crs != null ? !crs.equals(commentPK.crs) : commentPK.crs != null) return false;
        if (tch != null ? !tch.equals(commentPK.tch) : commentPK.tch != null) return false;
        if (date != null ? !date.equals(commentPK.date) : commentPK.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpm != null ? dpm.hashCode() : 0;
        result = 31 * result + (crs != null ? crs.hashCode() : 0);
        result = 31 * result + (tch != null ? tch.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
