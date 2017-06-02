package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.ExamServiceI;
import team.jiangtao.entity.Exam;

import javax.annotation.Resource;
import java.sql.Date;
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
}
