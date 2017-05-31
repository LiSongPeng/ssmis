package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import team.jiangtao.entity.Appeal;
import team.jiangtao.entity.Comment;
import team.jiangtao.entity.Teacher;

import java.util.Map;

/**
 * Created by tose on 2017/4/12.
 */
@Namespace("/teacher")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class TeacherAction extends ActionSupport {
    private Teacher teacher;
    //
    private Appeal appeal;
    private Comment comment;
    private String appealType;
    private String staticType;
    //
    private String rsp;
    private Map<String,Object> session;
    private String isRememberPsw;
    @Action(value = "login",results = @Result(type = "json",params={"root","rsp"}))
    public String teacherLogin(){
        //write to test.
        isRememberPsw="0";
        rsp="0";
        if(teacher.getTchId().equals(teacher.getPassword())){
            session.put("tch_id", teacher);
            rsp="1";
        }
        rsp = "{"+rsp+","+isRememberPsw+"}";
        return SUCCESS;
    }

    public String teahcerLogout(){
        //TODO
        return SUCCESS;

    }

    public String getTeacher(){
        //TODO
        return SUCCESS;

    }

    public String modifyTeacher(){
        //TODO
        return SUCCESS;

    }

    public String addCourses(){
        //TODO
        return SUCCESS;

    }

    public String addCourse(){
        //TODO
        return SUCCESS;

    }

    public String modifyCourses(){
        //TODO
        return SUCCESS;

    }

    public String modifyCourse(){
        //TODO
        return SUCCESS;

    }

    public String deleteCourses(){
        //TODO
        return SUCCESS;

    }

    public String deleteCourse(){
        //TODO
        return SUCCESS;
    }

    public String addExams(){
        //TODO
        return SUCCESS;
    }

    public String addExam(){
        //TODO
        return SUCCESS;
    }

    public String modifyExams(){
        //TODO
        return SUCCESS;
    }

    public String modifyExam(){
        //TODO
        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    @Action(value = "login",results = @Result(type = "json",params={"root","rsp"}))
    public String addAppeal(){
        //TODO

        return  SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    public String updateAppeal(){
        //TODO

        return SUCCESS;
    }
    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    public String getAppeal(){
        //TODO

        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    public String getComments(){
       //TODO

        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    public String addCommnets(){
        //TODO

        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    public String updateComments(){
        //TODO
        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    public String deleteCommnets(){
        //TODO

        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    public String getStatic(){
        //TODO
        return SUCCESS;
    }
}
