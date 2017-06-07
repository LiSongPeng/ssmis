package team.jiangtao.entity;

/**
 * Created by tose on 2017/6/6.
 */
public class CommentInfo extends Comment {
    protected String dpmName;
    protected String crsName;

    public String getDpmName() {
        return dpmName;
    }

    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }

    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }
}
