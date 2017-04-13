package team.jiangtao.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tose on 2017/4/13.
 */
@Entity
public class Course {
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

        Course course = (Course) o;

        if (crsId != null ? !crsId.equals(course.crsId) : course.crsId != null) return false;
        if (crsName != null ? !crsName.equals(course.crsName) : course.crsName != null) return false;
        if (summarization != null ? !summarization.equals(course.summarization) : course.summarization != null)
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
