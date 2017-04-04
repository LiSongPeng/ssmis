package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Student;
import org.apache.struts2.interceptor.SessionAware;
import service.i.StudentServiceI;

import java.util.Map;

public class StudentAction  extends ActionSupport implements SessionAware{
    private StudentServiceI studentService;
    private Student stu;
    private String result;
    private Map<String,Object> session;
    public String login(){
        Student student=studentService.loginByStuIdAndPass(stu.getStu_id(),stu.getPassword());
        if(student!=null){
            session.put("currStu",student);
            result="{\"result\":\"Success\"}";
        }else
            result="{\"result\":\"Error\"}";
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}