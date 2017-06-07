package service.impl;

import dao.i.CourseScheduleDaoI;
import dao.i.ExamDaoI;
import dao.i.StudentScheduleDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.i.ExamServiceI;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.ExamPK;
import team.jiangtao.entity.StudentSchedule;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
@Service("examService")
public class ExamServiceImpl implements ExamServiceI {
    private ExamDaoI examDaoI;
    private CourseScheduleDaoI courseScheduleDaoI;
    private List<ExamPK> list1=new ArrayList<>();
    private StudentScheduleDaoI studentScheduleDaoI;
    @Override
    @Transactional
    public List<Exam> findallExam() {
        examDaoI.findAllExams();
        return examDaoI.findAllExams();
    }

    @Override
    @Transactional
    public List<Exam> findExambyid(ExamPK examPK) {


        return examDaoI.findebyid(examPK);
    }

    @Override
    @Transactional
    public void sermodExam(String dpm, String crs, String date, String location, byte status) {
        examDaoI.modifyExam(dpm, crs, date, location, status);
    }

    @Override
    @Transactional
    public void serfromCStoExam(String dpm, String crs, String date, String location, byte status) {
           examDaoI.fromCStoExam(dpm, crs, date, location, status);
    }

    @Override
    @Transactional
    public void serdelExam(String dpm, String crs) {
          examDaoI.delExam(dpm, crs);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getExamed(String dpmId, String teacherId){
        //先查考试完成的所有课程
        List<Exam> examed = examDaoI.getExamed(dpmId);
        //拿到老师教的所有课程
        List<Object[]> teacherCourses = studentScheduleDaoI.findTeacherCoursess(teacherId);

        //拿到老师教的考完的课程
        List<Course> courses = new ArrayList<>();
        teacherCourses.forEach(teacherCourse ->{
            examed.forEach(exam -> {
                if(teacherCourse[0].equals(exam.getCrs())){
                    Course c = new Course();
                    c.setCrsId((String) teacherCourse[0]);
                    c.setCrsName((String) teacherCourse[1]);
                    courses.add(c);
                }
            });
        });
        return courses;
    }



    @Override
    @Transactional
    public List<CourseSchedule> findbytwo(String tid) {
        return courseScheduleDaoI.findCSbytwo(tid);
    }


    @Resource(name = "courseScheduleDao")
    public void setCourseScheduleDaoI(CourseScheduleDaoI courseScheduleDaoI) {
        this.courseScheduleDaoI = courseScheduleDaoI;
    }


    @Resource(name = "examDao")
    public void setExamDaoI(ExamDaoI examDaoI) {
        this.examDaoI = examDaoI;
    }

    @Autowired
    public void setStudentScheduleDaoI(StudentScheduleDaoI studentScheduleDaoI) {
        this.studentScheduleDaoI = studentScheduleDaoI;
    }
}
