package team.jiangtao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lihuibo on 4/20/17.
 */
public class CourseSchedulePK implements Serializable {
    private String dpmId;
    private String crsId;
    private String tchId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSchedulePK that = (CourseSchedulePK) o;

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
        return result;
    }
}
