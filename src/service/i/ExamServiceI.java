package service.i;

import team.jiangtao.entity.Exam;

import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface ExamServiceI {
    List<Exam> findallExam();
    void sermodExam(String dpm, String crs, Date date, String location, byte status);
    void serfromCStoExam(String dpm,String crs,Date date,String location,byte status);
    void serdelExam(String dpm,String crs);

}
