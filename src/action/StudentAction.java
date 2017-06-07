package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.CourseServiceI;
import service.i.StudentServiceI;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.Student;
import team.jiangtao.entity.StudentSchedule;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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
    private CourseServiceI courseService;
    private Student stu;
    private String result;
    private Map<String, Object> session;
    private CourseSchedule csche;
    private List<StudentSchedule> schedules;
    private String[][] selected;
    private int pageNumber;
    private List<CourseSchedule> courseSchedules;
    private String[][] selectable;
    private String[][] exams;
    private String[][] scores;
    private String[][] appeal;
    private String appealContent;


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

    @Action(value = "logout", results = @Result(type = "json", params = {"root", "result"}))
    public String logout() {
        if (session.remove("currStu") != null) {
            session.clear();
            result = "{\"result\":\"Success\"}";
        } else
            result = "{\"result\":\"Error\"}";
        return SUCCESS;
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
        currStu.setAddress(stu.getAddress() == null ? currStu.getAddress() : stu.getAddress());
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

    @Action(value = "getExamInfo", results = {@Result(type = "json", params = {"root", "exams"}), @Result(name = "error", type = "json", params = {"root", "result"})})
    public String getExamInfo() {
        Student currStu = (Student) session.get("currStu");
        List<Exam> examList = studentService.getExamInfo(currStu.getStuId());
        if (examList.size() > 0) {
            exams = new String[examList.size()][7];
            Date date;
            int status;
            for (int i = 0; i < exams.length; i++) {
                exams[i][0] = examList.get(i).getCrs();
                exams[i][1] = examList.get(i).getDpm();
                exams[i][2] = examList.get(i).getCourseByCrs().getCrsName();
                exams[i][3] = examList.get(i).getDepartmentByDpm().getDpmName();
                exams[i][4] = examList.get(i).getLocation();
                exams[i][5] = examList.get(i).getDate();
                status = examList.get(i).getStatus();
                exams[i][6] = status == 0 ? "未编排" : status == 1 ? "编排中" : status == 2 ? "未开始" : "已结束";
            }
            return SUCCESS;
        }
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getSelectedCoursesInfo", results = {@Result(type = "json", params = {"root", "selected"}), @Result(name = "error", type = "json", params = {"root", "result"})})
    public String getSelectedCoursesInfo() {
        Student currStu = (Student) session.get("currStu");
        schedules = studentService.getSelectedCoursesInfo(currStu.getStuId(), pageNumber);
        if (schedules != null && schedules.size() > 0) {
            selected = new String[schedules.size()][7];
            for (int i = 0; i < selected.length; i++) {
                selected[i][0] = schedules.get(i).getCrs();
                selected[i][1] = schedules.get(i).getDpm();
                selected[i][2] = schedules.get(i).getTch();
                selected[i][3] = schedules.get(i).getCourseByCrs().getCrsName();
                selected[i][4] = schedules.get(i).getDepartmentByDpm().getDpmName();
                selected[i][5] = schedules.get(i).getTeacherByTch().getName();
                selected[i][6] = schedules.get(i).getTerm() + "学期";
            }
            return SUCCESS;
        }
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getSelectableCoursesInfo", results = {@Result(name = "error", type = "json", params = {"root", "result"}), @Result(type = "json", params = {"root", "selectable"})})
    public String getSelectableCoursesInfo() {
        if (pageNumber > 0) {
            courseSchedules = courseService.getCourseSchedules(pageNumber);
        }
        if (courseSchedules != null && courseSchedules.size() > 0) {
            selectable = new String[courseSchedules.size()][10];
            for (int i = 0; i < selectable.length; i++) {
                selectable[i][0] = courseSchedules.get(i).getCrsId();
                selectable[i][1] = courseSchedules.get(i).getDpmId();
                selectable[i][2] = courseSchedules.get(i).getTchId();
                selectable[i][3] = courseSchedules.get(i).getCourseByCrsId().getCrsName();
                selectable[i][4] = courseSchedules.get(i).getDepartmentByDpmId().getDpmName();
                selectable[i][5] = courseSchedules.get(i).getTeacherByTchId().getName();
                selectable[i][6] = courseSchedules.get(i).getTerm() + "学期";
                selectable[i][7] = (courseSchedules.get(i).getType()) == 0 ? "选修课" : "必修课";
                selectable[i][8] = courseSchedules.get(i).getPreriods() + "课时";
                selectable[i][9] = courseSchedules.get(i).getCredit() + "学分";
            }
            return SUCCESS;
        }
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getScoreInfo", results = {@Result(type = "json", params = {"root", "scores"}), @Result(name = "error", type = "json", params = {"root", "result"})})
    public String getScoreInfo() {
        Student currStu = (Student) session.get("currStu");
        schedules = studentService.getAllScoreInfo(currStu.getStuId(), pageNumber);
        if (schedules.size() > 0) {
            scores = new String[schedules.size()][9];
            byte examStatus;
            for (int i = 0; i < scores.length; i++) {
                scores[i][0] = schedules.get(i).getCrs();
                scores[i][1] = schedules.get(i).getDpm();
                scores[i][2] = schedules.get(i).getTch();
                scores[i][3] = schedules.get(i).getCourseByCrs().getCrsName();
                scores[i][4] = schedules.get(i).getDepartmentByDpm().getDpmName();
                scores[i][5] = schedules.get(i).getTeacherByTch().getName();
                scores[i][6] = schedules.get(i).getTerm() + "学期";
                scores[i][7] = schedules.get(i).getScore() < 0 ? "未录入" : schedules.get(i).getScore() + "";
                examStatus = schedules.get(i).getExamStatus();
                scores[i][8] = examStatus == 0 ? "正常" : (examStatus == 1 ? "缺考" : "禁止考试");
            }
            return SUCCESS;
        }
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getResponsedAppeal", results = {@Result(type = "json", params = {"root", "appeal"}), @Result(name = "error", type = "json", params = {"root", "result"})})
    public String getResponsedAppeal() {
        Student currStu = (Student) session.get("currStu");
        byte appealStatus = 4;//已回执
        appeal = studentService.getAppeal(currStu.getStuId(), pageNumber, appealStatus);
        if (appeal != null)
            return SUCCESS;
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getClosedAppeal", results = {@Result(type = "json", params = {"root", "appeal"}), @Result(name = "error", type = "json", params = {"root", "result"})})
    public String getClosedAppeal() {
        Student currStu = (Student) session.get("currStu");
        byte appealStatus = 5;//已关闭
        appeal = studentService.getAppeal(currStu.getStuId(), pageNumber, appealStatus);
        if (appeal != null)
            return SUCCESS;
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getProgressAppeal", results = {@Result(type = "json", params = {"root", "appeal"}), @Result(name = "error", type = "json", params = {"root", "result"})})
    public String getProgressAppeal() {
        Student currStu = (Student) session.get("currStu");
        byte appealStatus = 0;//审核中,包括新建的,已读的,已标记的,更新的
        appeal = studentService.getAppeal(currStu.getStuId(), pageNumber, appealStatus);
        if (appeal != null)
            return SUCCESS;
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "closeAppeal", results = @Result(type = "json", params = {"root", "result"}))
    public String closeAppeal() {
        Student currStu = (Student) session.get("currStu");
        result = "{\"result\":\"Success\"}";
        if (!studentService.closeAppeal(currStu.getStuId(), csche.getDpmId(), csche.getTchId(), csche.getCrsId()))
            result = "{\"result\":\"Error\"}";
        return SUCCESS;
    }

    @Action(value = "appeal", results = @Result(type = "json", params = {"root", "result"}))
    public String appeal() {
        Student currStu = (Student) session.get("currStu");
        result = "{\"result\":\"Success\"}";
        if (!studentService.appeal(currStu.getStuId(), csche.getDpmId(), csche.getTchId(), csche.getCrsId(), appealContent))
            result = "{\"result\":\"Error\"}";
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

    @Resource(name = "courseService")
    public void setCourseService(CourseServiceI courseService) {
        this.courseService = courseService;
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

    public List<StudentSchedule> getSchedules() {
        return schedules;
    }

    public String[][] getSelected() {
        return selected;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String[][] getSelectable() {
        return selectable;
    }

    public String[][] getScores() {
        return scores;
    }

    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent;
    }

    public String[][] getAppeal() {
        return appeal;
    }

    public String[][] getExams() {
        return exams;
    }




}