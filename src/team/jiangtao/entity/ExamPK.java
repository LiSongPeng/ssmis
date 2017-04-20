package team.jiangtao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lihuibo on 4/20/17.
 */
public class ExamPK implements Serializable {
    private String dmp;
    private String crs;

    @Column(name = "dmp")
    @Id
    public String getDmp() {
        return dmp;
    }

    public void setDmp(String dmp) {
        this.dmp = dmp;
    }

    @Column(name = "crs")
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

        ExamPK examPK = (ExamPK) o;

        if (dmp != null ? !dmp.equals(examPK.dmp) : examPK.dmp != null) return false;
        if (crs != null ? !crs.equals(examPK.crs) : examPK.crs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dmp != null ? dmp.hashCode() : 0;
        result = 31 * result + (crs != null ? crs.hashCode() : 0);
        return result;
    }
}
