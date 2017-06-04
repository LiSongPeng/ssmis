package service.i;

import org.springframework.transaction.annotation.Transactional;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.Exam;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface ExamServiceI {
    List<Exam> findallExam();

    void sermodExam(String dpm, String crs, String date, String location, byte status);

    void serfromCStoExam(String dpm, String crs, String date, String location, byte status);

    void serdelExam(String dpm, String crs);

    /**
     * 查询所有考完试的课程
     * @return
     */
    List<Course> getExamed(String dpm, String teacherId);


}
