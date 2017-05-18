package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.CourseScheduleServiceI;
import service.i.CourseServiceI;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CourseSchedule;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7 0007.
 */
@Namespace("/teacher")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class SCAction extends ActionSupport{
    private CourseServiceI courseServiceI;
    private List<Course> course1;
    private List<CourseSchedule> courseSchedules;
    private CourseScheduleServiceI courseScheduleServiceI;
    @Action(value = "getAllclass", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "course1"})})
    public String getAllclass() {
      course1=courseServiceI.getallCourse();
//        System.out.println(course1.get(0).getAppealsByCrsId());
        return SUCCESS;
    }
    @Action(value = "fromctocs", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "courseSchedule"})})
    public String fromctocs() {
        byte b=0;
       courseServiceI.sercoursetocs("1","1","1",b,b,b,b);
        return SUCCESS;
    }
    @Action(value = "modcs", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "courseSchedule"})})
    public String modcs() {
        byte b=1;
       courseScheduleServiceI.ModifyCS("1","1","1",b,b,b,b);
        return SUCCESS;
    }
    @Action(value = "delcs", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "courseSchedule"})})
    public String delcs() {

        courseScheduleServiceI.deleCS("1","1","1");
        return SUCCESS;
    }
    @Action(value = "allCS", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "courseSchedules"})})
    public String allCS() {

       courseSchedules=courseScheduleServiceI.serfindAllCS();
        return SUCCESS;
    }

    @Resource(name = "courseService")
    public void setCourseServiceI(CourseServiceI courseServiceI) {
        this.courseServiceI = courseServiceI;
    }
    public void setCourse1(List<Course> course1) {
        this.course1 = course1;
    }
    public List<Course> getCourse1() {
        return course1;
    }

    @Resource(name="csService")
    public void setCourseScheduleServiceI(CourseScheduleServiceI courseScheduleServiceI) {
        this.courseScheduleServiceI = courseScheduleServiceI;
    }

    public List<CourseSchedule> getCourseSchedules() {
        return courseSchedules;
    }

    public void setCourseSchedules(List<CourseSchedule> courseSchedules) {
        this.courseSchedules = courseSchedules;
    }
}
