package entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lihuibo on 17-4-4.
 */
@Entity(name = "timetable")
public class TimeTable {
    public static final int first_class=1;
    public static final int second_class=2;
    public static final int third_class=3;
    public static final int fourth_class=4;
    @Id
    @GeneratedValue
    private int id;
    private int monday=0;
    private int tuesday=0;
    private int wednesday=0;
    private int thursday=0;
    private int friday=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }
}
