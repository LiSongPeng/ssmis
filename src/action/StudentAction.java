package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.StudentServiceI;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Student;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lihuibo on 4/14/17.
 */
@Namespace("/student")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class StudentAction extends ActionSupport implements SessionAware {
    private StudentServiceI studentService;
    private Student stu;
    private String result;
    private Map<String, Object> session;
    private CourseSchedule csche;

    @Action(value = "login", results = @Result(type = "json", params = {"root", "result"}))
    public String login() {
        Student student = studentService.loginByStuIdAndPass(stu.getStuId(), stu.getPassword());
        if (student != null) {
            session.put("currStu", student);
            result = "{\"result\":\"Success\"}";
        } else
            result = "{\"result\":\"Error\"}";
        return SUCCESS;
    }

    @Action(value = "logout", results = {@Result(location = "/student/login.jsp"), @Result(name = "error", location = "/student/index.jsp", type = "json", params = {"root", "result"})})
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

    @Action(value = "updateUser", results = @Result(type = "json", params = {"root", "result"}))
    public String updateUser() {
        Student currStu = (Student) session.get("currStu");
        currStu.setEmail(stu.getEmail() == null ? currStu.getEmail() : stu.getEmail());
        currStu.setPassword(stu.getPassword() == null ? currStu.getPassword() : stu.getPassword());
        currStu.setPhone(stu.getPhone() == null ? currStu.getPhone() : stu.getPhone());
        if (studentService.changeStudentInfo(currStu)) {
            result = "{\"result\":\"Success\"}";
        } else {
            result = "{\"result\":\"Error\"}";
        }
        return SUCCESS;
    }

    @Action(value = "selectCourse", results = @Result(type = "json", params = {"root", "result"}))
    public String selectCourse() {
        Student currStu = (Student) session.get("currStu");
        if (studentService.selectCourse(currStu.getStuId(), csche.getTchId(), csche.getDpmId(), csche.getCrsId())) {
            result = "{\"result\":\"Success\"}";
        } else {
            result = "{\"result\":\"Error\"}";
        }
        return SUCCESS;
    }

    @Action(value = "cancalCourse", results = @Result(type = "json", params = {"root", "result"}))
    public String cancelCourse() {
        Student currStu = (Student) session.get("currStu");
        if (studentService.cancelCourse(currStu.getStuId(), csche.getTchId(), csche.getDpmId(), csche.getCrsId())) {
            result = "{\"result\":\"Success\"}";
        } else {
            result = "{\"result\":\"Error\"}";
        }
        return SUCCESS;
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

    public CourseSchedule getCsche() {
        return csche;
    }

    public void setCsche(CourseSchedule csche) {
        this.csche = csche;
    }
}