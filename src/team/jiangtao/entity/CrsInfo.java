package team.jiangtao.entity;

/**
 * Created by tose on 2017/6/6.
 */
public class CrsInfo extends CourseSchedule{
    protected String dpmName;
    protected String tchName;
    protected String crsName;

    public String getDpmName() {
        return dpmName;
    }

    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }
}
