package action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.AppealServiceI;
import service.i.CommentServiceI;
import service.i.TeacherServiceI;
import team.jiangtao.entity.Appeal;
import team.jiangtao.entity.Comment;
import team.jiangtao.entity.Teacher;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
    private TeacherServiceI teacherServiceI;
    private Map<String,Object> session=new HashMap<>();
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

    public Teacher getTeacher() {
        return teacher;
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

    @Resource(name = "TeacherService")
    public void setTeacherServiceI(TeacherServiceI teacherServiceI) {
        this.teacherServiceI = teacherServiceI;
    }

    @Action(value = "login",results = @Result(type = "json",params={"root","session"}))
    public String teacherLogin(){
        //write to test.
        isRememberPsw="0";
        rsp="0";
        String tid=teacher.getTchId();
        String tpw=teacher.getPassword();
        Teacher teacher2=new Teacher();
        teacher=teacherServiceI.findTeacherbuid(tid);
        teacher2.setTchId(teacher.getTchId());
        teacher2.setDpmId(teacher.getDpmId());
        teacher2.setPassword(teacher.getPassword());
        teacher2.setName(teacher.getName());
        teacher2.setDepartmentByDpmId(teacher.getDepartmentByDpmId());
        if(tpw.equals(teacher2.getPassword())){
            session.put("tch", teacher2);
            rsp="1";
            session.put("rsp",rsp);
        };
        return SUCCESS;
    }


    public String teahcerLogout(){
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
        System.out.println(appeal.toString());
        return SUCCESS;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS

     */
    @Action(value = "getAppeals",results = @Result(type = "json",params={"root","rsp"}))
    public String getAppealByType() throws Exception {
        //TO FINISH
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("tch","00001");//Instead of Session
        stringObjectMap.put("type",operation);
        List list = appealServiceI.getAppealsByCondition(stringObjectMap,true);
        rsp = JSON.toJSONString(list);
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
