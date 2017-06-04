package action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.ExamServiceI;
import service.i.StudentServiceI;
import team.jiangtao.entity.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
    @Namespace("/teacher")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class ExamAction extends ActionSupport {
    private ExamServiceI examServiceI;
    private List<Exam> list;
    private String dpm;
    private String crs;
    private String tid;
    private StudentServiceI studentServiceI;
    private List<Student> students;
    private String studentSchedules;
    private List<Course> courses;



    @Action(value = "getAllexam", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "list"})})
    public String getAllexam() {
        list=examServiceI.findallExam();
//        System.out.println(course1.get(0).getAppealsByCrsId());
        return SUCCESS;
    }

    @Action(value = "modExam", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "list"})})
    public String modExam() {
        return SUCCESS;
    }

    @Action(value = "fromCStoExam", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "list"})})
    public String fromCStoExam() {
        return SUCCESS;
    }

    @Action(value = "delExam", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "list"})})
    public String delExam() {
        examServiceI.serdelExam("1","1");
        return SUCCESS;
    }


    @Action(value = "getExamed", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "courses"})})
    public String getExamed() {
        courses=examServiceI.getExamed(dpm, tid);
        System.out.println(courses);
        return SUCCESS;
    }


    @Action(value = "getChooseCourseStudents", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "students"})})
    public String getChooseCourseStudents() {
        students = studentServiceI.findStudentsByCrsAndDpm(dpm, crs);
        System.out.println(students);
        return SUCCESS;
    }

    /**
     * 录入成绩
     * @return
     */
    @Action(value = "enterScore", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "list"})})
    public String enterScore(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentSchedule> studentScheduleList = new ArrayList<>();
        try {
            List<LinkedHashMap<String, Object>> list = objectMapper.readValue(studentSchedules, List.class);
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);

                StudentSchedule schedule = new StudentSchedule();
                schedule.setStu((String)map.get("stu"));
                schedule.setCrs((String)map.get("crs"));
                schedule.setDpm((String)map.get("dpm"));
                schedule.setScore(Double.parseDouble((String)map.get("score")));
                studentScheduleList.add(schedule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentServiceI.enterScore(studentScheduleList);
        return SUCCESS;
    }


    @Resource(name = "examService")
    public void setExamServiceI(ExamServiceI examServiceI) {
        this.examServiceI = examServiceI;
    }
    public List<Exam> getList() {
        return list;
    }
    public void setList(List<Exam> list) {
        this.list = list;
    }

    public String getDpm() {
        return dpm;
    }

    public void setDpm(String dpm) {
        this.dpm = dpm;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getStudentSchedules() {
        return studentSchedules;
    }

    public void setStudentSchedules(String studentSchedules) {
        this.studentSchedules = studentSchedules;
    }

    @Autowired
    public void setStudentServiceI(StudentServiceI studentServiceI) {
        this.studentServiceI = studentServiceI;
    }
}
