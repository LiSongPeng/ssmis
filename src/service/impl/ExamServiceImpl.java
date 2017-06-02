package service.impl;

import dao.i.ExamDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.i.ExamServiceI;
import team.jiangtao.entity.Exam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
@Service("examService")
public class ExamServiceImpl implements ExamServiceI {
    private ExamDaoI examDaoI;
    @Override
    @Transactional
    public List<Exam> findallExam() {
        examDaoI.findAllExams();
        return examDaoI.findAllExams();
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

    @Resource(name = "examDao")
    public void setExamDaoI(ExamDaoI examDaoI) {
        this.examDaoI = examDaoI;
    }
}
