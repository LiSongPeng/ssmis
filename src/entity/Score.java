package entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by lihuibo on 17-4-4.
 */
@Entity(name = "score")
public class Score {
    public static final int appeal_denied = 0;
    public static final int appeal_approved = 1;
    public static final int appeal_processing = 2;
    public static final int appeal_noAppeal = 3;
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String stu_id;
    @Column(nullable = false)
    private String cou_id;
    private int score = 0;
    private int appealStatus = appeal_noAppeal;
    @Type(type = "text")
    private String appealMessage = "无";

    public Score() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getCou_id() {
        return cou_id;
    }

    public void setCou_id(String cou_id) {
        this.cou_id = cou_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAppealStatus() {
        return appealStatus;
    }

    public void setAppealStatus(int appealStatus) {
        this.appealStatus = appealStatus;
    }

    public String getAppealMessage() {
        return appealMessage;
    }

    public void setAppealMessage(String appealMessage) {
        this.appealMessage = appealMessage;
    }
}
