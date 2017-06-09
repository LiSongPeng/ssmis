package action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.i.*;
import team.jiangtao.entity.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by tose on 2017/4/12.
 */
@Namespace("/teacher")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class TeacherAction extends ActionSupport implements SessionAware {
    private CommentServiceI commentServiceI;
    private AppealServiceI appealServiceI;
    private StudentServiceI studentServiceI;
    private Teacher teacher;
    private Appeal appeal;
    private Comment comment;
    private Integer operation;
    private String rsp;
    private TeacherServiceI teacherServiceI;
    private Map<String,Object> session;
    private String isRememberPsw;
    private long date;
    private String tid;
    private CourseScheduleServiceI courseScheduleServiceI;
    public long getDate() {
        return date;
    }
    private Map<String,Object> mapS = new HashMap<>();
    private String json2;

    public String getJson2() {
        return json2;
    }

    public void setJson2(String json2) {
        this.json2 = json2;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Resource(name = "commentService")
    public void setCommentServiceI(CommentServiceI commentServiceI) {
        this.commentServiceI = commentServiceI;
    }

    @Resource(name = "appealService")
    public void setAppealServiceI(AppealServiceI appealServiceI) {
        this.appealServiceI = appealServiceI;
    }

    @Resource(name="csService")
    public void setCourseScheduleServiceI(CourseScheduleServiceI courseScheduleServiceI) {
        this.courseScheduleServiceI = courseScheduleServiceI;
    }

    @Resource(name="studentService")
    public void setStudentServiceI(StudentServiceI studentServiceI) {
        this.studentServiceI = studentServiceI;
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

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    @Action(value = "pullCS", results = @Result(type = "json",params={"root","rsp"}))
    public String pullCrsSc() throws Exception {
        Teacher t = (Teacher) session.get("tch");
        List<StudentSchedule> studentScheduleList = studentServiceI.pullSSbyTch(t.getTchId());
        Map<String,List<Double>> stringDoubleMap = new HashMap<>();
        for(StudentSchedule studentSchedule:studentScheduleList){
            if(stringDoubleMap.get(studentSchedule.getCrs())==null){
                stringDoubleMap.put(studentSchedule.getCrs(),new ArrayList<>());
            }
            stringDoubleMap.get(studentSchedule.getCrs()).add(studentSchedule.getScore());
        }
        rsp = JSON.toJSONString(stringDoubleMap);
        System.out.println(rsp);
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
        Date dd = new Date(date);
        appeal.setDate(new java.sql.Date(dd.getTime()));
//        System.out.println(appeal.toString());
        List<Appeal> appeals = new ArrayList<>();
        appeals.add(appeal);
        boolean flag = appealServiceI.updateAppeals(appeals);
        rsp = "{\"result\" : \""+flag+"\"}";
        return SUCCESS;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    @Action(value = "pullTchCrs",results = @Result(type = "json", params = {"root","rsp"}))
    public String pullTchCrs(){
        Teacher t = (Teacher) session.get("tch");
        List<CourseSchedule> list = courseScheduleServiceI.findCSbytwo(t.getTchId());
        List<CrsInfo> crsInfos = new ArrayList<>();
        CrsInfo temp;
        for(CourseSchedule courseSchedule : list){
            temp = new CrsInfo();
            temp.setCrsName(courseSchedule.getCourseByCrsId().getCrsName());
            temp.setDpmName(courseSchedule.getDepartmentByDpmId().getDpmName());
            temp.setTchName(courseSchedule.getTeacherByTchId().getName());
            temp.setDpmId(courseSchedule.getDpmId());
            temp.setCrsId(courseSchedule.getCrsId());
            temp.setTchId(courseSchedule.getTchId());
            temp.setCredit(courseSchedule.getCredit());
            temp.setPreriods(courseSchedule.getPreriods());
            temp.setTerm(courseSchedule.getTerm());
            crsInfos.add(temp);
        }
        rsp = JSON.toJSONString(crsInfos);
        System.out.println(rsp);
        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS

     */
    @Action(value = "getAppeals",results = @Result(type = "json",params={"root","rsp"}))
    public String getAppealByType() throws Exception {
        //TO FINISH
        Map<String,Object> stringObjectMap = new HashMap<>();
        Teacher t = (Teacher) session.get("tch");
        System.out.println(t.toString());
        stringObjectMap.put("tch",t.getTchId());
        stringObjectMap.put("type",operation);
        List list = appealServiceI.getAppealsByCondition(stringObjectMap,true);
        List<Appeal> temp =(List<Appeal>) list;
        List<AppealInfo> appealInfos = new ArrayList<>();
        for(Appeal ap:temp){
            AppealInfo appealInfo = new AppealInfo();
            appealInfo.setDpmId(ap.getDpmId());
            appealInfo.setCrsId(ap.getCrsId());
            appealInfo.setTchId(ap.getTchId());
            appealInfo.setStuId(ap.getStuId());
            appealInfo.setDate(ap.getDate());
            appealInfo.setContent(ap.getContent());
            appealInfo.setResponse(ap.getResponse());
            appealInfo.setStatus(ap.getStatus());
            appealInfo.setDepartmentName(ap.getDepartmentByDpmId().getDpmName());
            appealInfo.setTeacherName("tchname");
            appealInfo.setStudentName(ap.getStudentByStuId().getName());
            appealInfo.setStuGender(ap.getStudentByStuId().getGender());
            appealInfo.setStuGrade(ap.getStudentByStuId().getGrade());
            appealInfo.setStuClassNo(ap.getStudentByStuId().getClassNo());

            appealInfos.add(appealInfo);
        }
        rsp = JSON.toJSONString(appealInfos);
//        System.out.println(rsp);
        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */

    @Action(value = "getComment",results = @Result(type = "json",params={"root","rsp"}))
    public String getComments() throws Exception {
        Map<String,Object> stringObjectMap = new HashMap<>();
        Teacher t = (Teacher) session.get("tch");
        stringObjectMap.put("tch_id",t.getTchId());
        List<Comment> list = commentServiceI.getCommentsByConditions(stringObjectMap);
        CommentInfo commentInfo;
        List<CommentInfo> commentInfos = new ArrayList<>();
        for(Comment tcom :list){
            commentInfo = new CommentInfo();
            commentInfo.setDpm(tcom.getDpm());
            commentInfo.setCrs(tcom.getCrs());
            commentInfo.setTch(tcom.getTch());
            commentInfo.setDate(tcom.getDate());
            commentInfo.setContent(tcom.getContent());
            commentInfo.setDpmName(tcom.getDepartmentByDpm().getDpmName());
            commentInfo.setCrsName(tcom.getCourseByCrs().getCrsName());
            commentInfos.add(commentInfo);
        }
        rsp = JSON.toJSONString(commentInfos);
        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    @Action(value = "addComment",results = @Result(type = "json",params={"root","rsp"}))
    public String addCommnets(){
        boolean flag;
        Comment commentTemp = comment;
        Date date = new Date();
        commentTemp.setDate(new java.sql.Date(date.getTime()));
        List<Comment> comments = new ArrayList<>();
        comments.add(commentTemp);
        flag = commentServiceI.addComments(comments);
        Map<String,Boolean> f = new HashMap<>();
        f.put("result",flag);
        rsp = JSON.toJSONString(f);
        return SUCCESS;
    }

    /**
     * @author Jiang Tao
     * @return SUCCESS
     */
    @Action(value = "updateComment",results = @Result(type = "json",params={"root","rsp"}))
    public String updateComments(){
        Date d = new Date(date);
        Comment queryCommnet = new Comment();
        queryCommnet.setCrs(comment.getCrs());
        queryCommnet.setDate(new java.sql.Date(d.getTime()));
        queryCommnet.setContent(comment.getContent());
        queryCommnet.setDpm(comment.getDpm());
        queryCommnet.setTch(comment.getTch());
        List<Comment> comments = new ArrayList<>();
        comments.add(queryCommnet);
        commentServiceI.updateComments(comments);
        return SUCCESS;
    }


    @Action(value = "addSession",results = @Result(type = "redirect",params={"root","rsp"}))
    public String addSession(){
        Teacher t = new Teacher();
        teacher.setTchId("1001");
        session.put("tch",t);
        return SUCCESS;
    }


    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public Map<String, Object> getMapS() {
        return mapS;
    }

    public void setMapS(Map<String, Object> mapS) {
        this.mapS = mapS;
    }


    @Action(value = "login",results = @Result(type = "json",params={"root","mapS"}))
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
            Teacher teacher3 = new Teacher();
            teacher3.setAddress(teacher2.getAddress());
            teacher3.setBiography(teacher2.getBiography());
            teacher3.setBirthday(teacher2.getBirthday());
            teacher3.setDpmId(teacher2.getDpmId());
            teacher3.setEmail(teacher2.getEmail());
            teacher3.setName(teacher2.getName());
            teacher3.setGender(teacher2.getGender());
            teacher3.setPhone(teacher2.getPhone());
            teacher3.setTchId(teacher2.getTchId());
            Department temp = new Department();
            temp.setDpmName(teacher2.getDepartmentByDpmId().getDpmName());
            teacher3.setDepartmentByDpmId(temp);
            mapS.put("tch", teacher3);
            rsp="1";
            mapS.put("rsp",rsp);
            session.put("tch",teacher3);
        }
        return SUCCESS;
    }

    /**
     * 获取教师信息
     * 返回教师信息Json串
     * */
    @Action(value = "selfInfo",results = @Result(type = "json",params={"root","teacher"}))
    public String  getSelfInfo(){
        teacher =  teacherServiceI.findTeacherbuid(tid);
        return SUCCESS;
    }



    /**
    * 更新教师信息
    *
    * */
    @Action(value = "updateInfo", results = @Result(type = "json",params={"root",""}))
    public String updateTeacherInfo(){
        teacherServiceI.updateTeacherInfo(teacher);
        return SUCCESS;
    }
}
