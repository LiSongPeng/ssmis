package team.jiangtao.entity;

import javax.persistence.*;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "department", schema = "ssmis", catalog = "")
public class DepartmentEntity {
    private String dpmId;
    private String dpmName;

    @Id
    @Column(name = "dpm_id", nullable = false, length = 8)
    public String getDpmId() {
        return dpmId;
    }

    public void setDpmId(String dpmId) {
        this.dpmId = dpmId;
    }

    @Basic
    @Column(name = "dpm_name", nullable = false, length = 32)
    public String getDpmName() {
        return dpmName;
    }

    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (dpmId != null ? !dpmId.equals(that.dpmId) : that.dpmId != null) return false;
        if (dpmName != null ? !dpmName.equals(that.dpmName) : that.dpmName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dpmId != null ? dpmId.hashCode() : 0;
        result = 31 * result + (dpmName != null ? dpmName.hashCode() : 0);
        return result;
    }
}
