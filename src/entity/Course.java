package entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by lihuibo on 17-4-4.
 */
@Entity(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20,nullable = false)
    private String name;
    @Column(unique = true,nullable = false,length = 16)
    private String cou_id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private TimeTable timeTable;
    @Type(type = "text")
    private String description="无";

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCou_id() {
        return cou_id;
    }

    public void setCou_id(String cou_id) {
        this.cou_id = cou_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
