package team.jiangtao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tose on 2017/4/12.
 */
public class CoursesTableEntityPK implements Serializable {
    private String dpmId;
    private String crsId;
    private String tchId;
    private byte weeks;
    private byte off;

    @Column(name = "dpm_id", nullable = false, length = 8)
    @Id
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Column(name = "crs_id", nullable = false, length = 8)
    @Id
    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @Column(name = "tch_id", nullable = false, length = 8)
    @Id
    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    @Column(name = "weeks", nullable = false)
    @Id
    public byte getWeeks() {
        return weeks;
    }

    public void setWeeks(byte weeks) {
        this.weeks = weeks;
    }

    @Column(name = "off", nullable = false)
    @Id
    public byte getOff() {
        return off;
    }

    public void setOff(byte off) {
        this.off = off;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesTableEntityPK that = (CoursesTableEntityPK) o;

        if (weeks != that.weeks) return false;
        if (off != that.off) return false;
        if (dpmId != null ? !dpmId.equals(that.dpmId) : that.dpmId != null) return false;
        if (crsId != null ? !crsId.equals(that.crsId) : that.crsId != null) return false;
        if (tchId != null ? !tchId.equals(that.tchId) : that.tchId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpmId != null ? dpmId.hashCode() : 0;
        result = 31 * result + (crsId != null ? crsId.hashCode() : 0);
        result = 31 * result + (tchId != null ? tchId.hashCode() : 0);
        result = 31 * result + (int) weeks;
        result = 31 * result + (int) off;
        return result;
    }
}
