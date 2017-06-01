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
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Student;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lihuibo on 4/14/17.
 */
@Namespace("/course")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class CourseAction extends ActionSupport implements SessionAware {
    private CourseServiceI courseService;
    private CourseSchedule cs;
    private String courseKeyName;
    private String courseId;
    private List<CourseSchedule> courseSchedules;
    private String result;
    private String[][] courseTable;
    private Course course;
    private Map<String, Object> session;
    private int pageNumber;
    private String[][] schedule;

    @Action(value = "getCoursesInfo", results = {@Result(name = "error", type = "json", params = {"root", "result"}), @Result(type = "json", params = {"root", "courseSchedules"})})
    public String getCoursesInfo() {
        if (courseId != null) {
            courseSchedules = courseService.getCourseInfoById(courseId);
            return SUCCESS;
        }
        if (courseKeyName != null) {
            courseSchedules = courseService.getCoursesInfoByKeyName(courseKeyName);
            return SUCCESS;
        }
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getCoursesSchedule", results = {@Result(name = "error", type = "json", params = {"root", "result"}), @Result(type = "json", params = {"root", "schedule"})})
    public String getCoursesSchedule() {
        if (pageNumber > 0) {
            courseSchedules = courseService.getCourseSchedules(pageNumber);
        }
        if (courseSchedules != null) {
            schedule = new String[courseSchedules.size()][8];
            for (int i = 0; i < schedule.length; i++) {
                schedule[i][0] = courseSchedules.get(i).getCrsId();
                schedule[i][1] = courseSchedules.get(i).getCourseByCrsId().getCrsName();
                schedule[i][2] = courseSchedules.get(i).getTeacherByTchId().getName();
                schedule[i][3] = courseSchedules.get(i).getCredit() + "学分";
                schedule[i][4] = courseSchedules.get(i).getPreriods() + "课时";
                schedule[i][5] = courseSchedules.get(i).getTerm() + "学期";
                schedule[i][6] = (courseSchedules.get(i).getType()) == 0 ? "选修课" : "必修课";
                schedule[i][7] = courseSchedules.get(i).getDepartmentByDpmId().getDpmName();
            }
            return SUCCESS;
        }
        result = "{\"result\":\"Error\"}";
        return ERROR;
    }

    @Action(value = "getCourseTableById", results = @Result(type = "json", params = {"root", "courseTable"}))
    public String getCourseTableById() {
        courseTable = courseService.getCourseTable(cs.getCrsId(), cs.getTchId(), cs.getDpmId());
        return SUCCESS;
    }

    @Action(value = "getPersonalCourseTable", results = @Result(type = "json", params = {"root", "courseTable"}))
    public String ggetPersonalCourseTable() {
        System.out.println("get personal course");
        String stuId = ((Student) session.get("currStu")).getStuId();
        courseTable = courseService.getPersonalCourseTable(stuId);
        return SUCCESS;
    }

    @Resource(name = "courseService")
    public void setCourseService(CourseServiceI courseService) {
        this.courseService = courseService;
    }

    public void setCs(CourseSchedule cs) {
        this.cs = cs;
    }

    public void setCourseKeyName(String courseKeyName) {
        this.courseKeyName = courseKeyName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<CourseSchedule> getCourseSchedules() {
        return courseSchedules;
    }

    public String getResult() {
        return result;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String[][] getCourseTable() {
        return courseTable;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String[][] getSchedule() {
        return schedule;
    }
}
