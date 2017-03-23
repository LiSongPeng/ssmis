package entity;



import javax.persistence.*;

@Entity(name = "student")
@NamedQueries({
        @NamedQuery(name = "queryStudentByIdAndPass",query = "from student stu where stu.id=?1 and stu.password=?2")
})
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String password;
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
