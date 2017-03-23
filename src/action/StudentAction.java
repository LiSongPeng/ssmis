package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Student;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@Namespace("/student")
@ParentPackage("json-default")
public class StudentAction  extends ActionSupport{
    private Student stu;

    public String login(){
        return SUCCESS;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
}
