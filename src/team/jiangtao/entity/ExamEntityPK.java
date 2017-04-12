package team.jiangtao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tose on 2017/4/12.
 */
public class ExamEntityPK implements Serializable {
    private String dmp;
    private String crs;

    @Column(name = "dmp", nullable = false, length = 8)
    @Id
    public String getDmp() {
        return dmp;
    }

    public void setDmp(String dmp) {
        this.dmp = dmp;
    }

    @Column(name = "crs", nullable = false, length = 8)
    @Id
    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamEntityPK that = (ExamEntityPK) o;

        if (dmp != null ? !dmp.equals(that.dmp) : that.dmp != null) return false;
        if (crs != null ? !crs.equals(that.crs) : that.crs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dmp != null ? dmp.hashCode() : 0;
        result = 31 * result + (crs != null ? crs.hashCode() : 0);
        return result;
    }
}
