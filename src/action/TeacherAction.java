package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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

        return SUCCESS;

    }

    public String getTeacher(){

        return SUCCESS;

    }

    public String modifyTeacher(){

        return SUCCESS;

    }

    public String addCourses(){

        return SUCCESS;

    }

    public String addCourse(){

        return SUCCESS;

    }

    public String modifyCourses(){

        return SUCCESS;

    }

    public String modifyCourse(){

        return SUCCESS;

    }

    public String deleteCourses(){

        return SUCCESS;

    }

    public String deleteCourse(){

        return SUCCESS;
    }

    public String addExams(){

        return SUCCESS;
    }

    public String addExam(){

        return SUCCESS;
    }

    public String modifyExams(){

        return SUCCESS;
    }

    public String modifyExam(){

        return SUCCESS;
    }

}
