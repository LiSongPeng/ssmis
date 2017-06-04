package service.i;

import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.ExamPK;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface ExamServiceI {
    List<Exam> findallExam();

    List<Exam> findExambyid(ExamPK examPK);

    void sermodExam(String dpm, String crs, String date, String location, byte status);

    void serfromCStoExam(String dpm, String crs, String date, String location, byte status);

    void serdelExam(String dpm, String crs);

    List<CourseSchedule> findbytwo(String tid);
}
