package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.CourseServiceI;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.CoursesTable;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lihuibo on 4/14/17.
 */
@Namespace("/course")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class CourseAction extends ActionSupport {
    private CourseServiceI courseService;
    private CourseSchedule cs;
    private String courseKeyName;
    private String courseId;
    private List<CourseSchedule> courseSchedules;
    private String result;
    private String[][] courseTable;
    private Course course;

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

    @Action(value = "getCourseTableById", results = @Result(type = "json", params = {"root", "courseTable"}))
    public String getCourseTableById() {

        return SUCCESS;
    }

    @Action(value = "getPersonalCourseTable", results = @Result(type = "json", params = {"root", "courseTable"}))
    public String ggetPersonalCourseTable() {

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
}
