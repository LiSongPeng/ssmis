package team.jiangtao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by lihuibo on 4/20/17.
 */
public class AppealPK implements Serializable {
    private String dpmId;
    private String crsId;
    private String tchId;
    private String stuId;
    private Date date;

    @Column(name = "dpm_id")
    @Id
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Column(name = "crs_id")
    @Id
    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @Column(name = "tch_id")
    @Id
    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    @Column(name = "stu_id")
    @Id
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Column(name = "date")
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

        AppealPK appealPK = (AppealPK) o;

        if (dpmId != null ? !dpmId.equals(appealPK.dpmId) : appealPK.dpmId != null) return false;
        if (crsId != null ? !crsId.equals(appealPK.crsId) : appealPK.crsId != null) return false;
        if (tchId != null ? !tchId.equals(appealPK.tchId) : appealPK.tchId != null) return false;
        if (stuId != null ? !stuId.equals(appealPK.stuId) : appealPK.stuId != null) return false;
        if (date != null ? !date.equals(appealPK.date) : appealPK.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpmId != null ? dpmId.hashCode() : 0;
        result = 31 * result + (crsId != null ? crsId.hashCode() : 0);
        result = 31 * result + (tchId != null ? tchId.hashCode() : 0);
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
