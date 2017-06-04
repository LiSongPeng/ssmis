package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.ExamServiceI;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.ExamPK;

import javax.annotation.Resource;
import java.util.List;

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
    private List<CourseSchedule> courseScheduleList;
    private Exam exam;
    private String demid;
    private String tid;
    private String crs;
    private ExamPK examPK;
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
            @Result(type = "json", params = {"root", ""})})
    public String modExam() {

        examServiceI.sermodExam(exam.getDpm(),exam.getCrs(),exam.getDate(),exam.getLocation(),exam.getStatus());
        return SUCCESS;
    }

    @Action(value = "fromCStoExam", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "list"})})
    public String fromCStoExam() {

        examServiceI.serfromCStoExam(exam.getDpm(),exam.getCrs(),exam.getDate(),exam.getLocation(),exam.getStatus());

        return SUCCESS;
    }

    @Action(value = "delExam", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "list"})})
    public String delExam() {
        examServiceI.serdelExam(exam.getDpm(),exam.getCrs());
        return SUCCESS;
    }

    @Action(value = "findbyid", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "tid"})})
    public String findbyid() {
        list=examServiceI.findExambyid(examPK);
        if (list.size()==0){
            tid=null;
        }else{
            tid="1";
        }
        return SUCCESS;
    }

    @Action(value = "findbytwo", results = {
            @Result(name = "error", type = "json", params = {"root", "result"}),
            @Result(type = "json", params = {"root", "courseScheduleList"})})
    public String findbytwo() {
        courseScheduleList=examServiceI.findbytwo(tid);

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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public String getDemid() {
        return demid;
    }

    public void setDemid(String demid) {
        this.demid = demid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public List<CourseSchedule> getCourseScheduleList() {
        return courseScheduleList;
    }

    public void setCourseScheduleList(List<CourseSchedule> courseScheduleList) {
        this.courseScheduleList = courseScheduleList;
    }

    public ExamPK getExamPK() {
        return examPK;
    }

    public void setExamPK(ExamPK examPK) {
        this.examPK = examPK;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }
}
