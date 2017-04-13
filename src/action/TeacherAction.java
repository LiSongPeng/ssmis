package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
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


    public String teacherLogin(){

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
