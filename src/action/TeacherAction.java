package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.AppealServiceI;
import service.i.CommentServiceI;
import team.jiangtao.entity.Appeal;
import team.jiangtao.entity.Comment;
import team.jiangtao.entity.Teacher;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by tose on 2017/4/12.
 */
@Namespace("/teacher")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class TeacherAction extends ActionSupport {
    private CommentServiceI commentServiceI;
    private AppealServiceI appealServiceI;
    private Teacher teacher;
    private Appeal appeal;
    private Comment comment;
    private String operation;
    private String rsp;
    private Map<String,Object> session;
    private String isRememberPsw;

    @Resource(name = "commentService")
    public void setCommentServiceI(CommentServiceI commentServiceI) {
        this.commentServiceI = commentServiceI;
    }

    @Resource(name = "appealService")
    public void setAppealServiceI(AppealServiceI appealServiceI) {
        this.appealServiceI = appealServiceI;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getRsp() {
        return rsp;
    }

    public void setRsp(String rsp) {
        this.rsp = rsp;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getIsRememberPsw() {
        return isRememberPsw;
    }

    public void setIsRememberPsw(String isRememberPsw) {
        this.isRememberPsw = isRememberPsw;
    }

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
    @Action(value = "addAppeals",results = @Result(type = "json",params={"root","rsp"}))
    public String addAppeal(){
        //TODO

        return  SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    @Action(value = "updateAppeals",results = @Result(type = "json",params={"root","rsp"}))
    public String updateAppeal(){
        //TODO

        return SUCCESS;
    }
    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    @Action(value = "getAppeals",results = @Result(type = "json",params={"root","rsp"}))
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
