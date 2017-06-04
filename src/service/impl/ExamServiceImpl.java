package service.impl;

import dao.i.CourseScheduleDaoI;
import dao.i.ExamDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.i.ExamServiceI;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.ExamPK;

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
}
