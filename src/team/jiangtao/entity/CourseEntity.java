package team.jiangtao.entity;

import javax.persistence.*;

/**
 * Created by tose on 2017/4/12.
 */
@Entity
@Table(name = "course", schema = "ssmis", catalog = "")
public class CourseEntity {
    private String crsId;
    private String crsName;
    private String summarization;

    @Id
    @Column(name = "crs_id", nullable = false, length = 8)
    public String getCrsId() {
        return crsId;
    }

    public void setCrsId(String crsId) {
        this.crsId = crsId;
    }

    @Basic
    @Column(name = "crs_name", nullable = false, length = 64)
    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }

    @Basic
    @Column(name = "summarization", nullable = true, length = 128)
    public String getSummarization() {
        return summarization;
    }

    public void setSummarization(String summarization) {
        this.summarization = summarization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (crsId != null ? !crsId.equals(that.crsId) : that.crsId != null) return false;
        if (crsName != null ? !crsName.equals(that.crsName) : that.crsName != null) return false;
        if (summarization != null ? !summarization.equals(that.summarization) : that.summarization != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = crsId != null ? crsId.hashCode() : 0;
        result = 31 * result + (crsName != null ? crsName.hashCode() : 0);
        result = 31 * result + (summarization != null ? summarization.hashCode() : 0);
        return result;
    }
}
