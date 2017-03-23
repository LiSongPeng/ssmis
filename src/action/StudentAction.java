package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Student;
import service.i.StudentServiceI;

public class StudentAction  extends ActionSupport{
    private StudentServiceI studentService;
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

    public void setStudentService(StudentServiceI studentService) {
        this.studentService = studentService;
    }
}
