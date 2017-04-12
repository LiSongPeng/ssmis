package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Student;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;
import service.i.StudentServiceI;

import javax.annotation.Resource;
import java.util.Map;

@Namespace("/student")
@ParentPackage("ssmis-default")
@Controller
@RequestScope
public class StudentAction extends ActionSupport implements SessionAware {
    private StudentServiceI studentService;
    private Student stu;
    private String result;
    private Map<String, Object> session;

    @Action(value = "login", results = @Result(type = "json", params = {"root", "result"}) )
    public String login() {
        Student student = studentService.loginByStuIdAndPass(stu.getStu_id(), stu.getPassword());
        if (student != null) {
            session.put("currStu", student);
            result = "{\"result\":\"Success\"}";
        } else
            result = "{\"result\":\"Error\"}";
        return SUCCESS;
    }

    @Action(value = "logout", results = {@Result(location = "/student/login.jsp"), @Result(name = "error", location = "/student/index.jsp",type= "json", params = {"root", "result"})})
    public String logout() {
        if (session.remove("currStu") != null) {
            session.clear();
            return SUCCESS;
        }
        return ERROR;
    }

    @Action(value = "getStuInfo", results = {@Result(type = "json", params = {"root", "stu"}), @Result(name = "error", type = "json", params = {"root", "result"})})
    public String getStuInfo() {
        if (stu != null)
            return SUCCESS;
        String result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
    @Resource(name = "studentService")
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
        this.session = map;
    }
}