package team.jiangtao.entity;

import javax.persistence.*;

/**
 * Created by tose on 2017/4/13.
 */
@Entity
@Table(name = "course_schedule", schema = "ssmis", catalog = "")
@IdClass(CourseSchedulePK.class)
public class CourseSchedule {
    private String dpmId;
    private String crsId;
    private String tchId;
    private byte type;
    private byte preriods;
    private byte credit;
    private byte term;

    @Id
    @Column(name = "dpm_id", nullable = false, length = 8)
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Id
    @Column(name = "crs_id", nullable = false, length = 8)
    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @Id
    @Column(name = "tch_id", nullable = false, length = 8)
    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "preriods", nullable = false)
    public byte getPreriods() {
        return preriods;
    }

    public void setPreriods(byte preriods) {
        this.preriods = preriods;
    }

    @Basic
    @Column(name = "credit", nullable = false)
    public byte getCredit() {
        return credit;
    }

    public void setCredit(byte credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "term", nullable = false)
    public byte getTerm() {
        return term;
    }

    public void setTerm(byte term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSchedule that = (CourseSchedule) o;

        if (type != that.type) return false;
        if (preriods != that.preriods) return false;
        if (credit != that.credit) return false;
        if (term != that.term) return false;
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
        result = 31 * result + (int) type;
        result = 31 * result + (int) preriods;
        result = 31 * result + (int) credit;
        result = 31 * result + (int) term;
        return result;
    }
}
