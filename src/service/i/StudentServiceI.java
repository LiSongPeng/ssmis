package service.i;


import org.springframework.transaction.annotation.Transactional;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.Student;
import team.jiangtao.entity.StudentSchedule;

import java.util.List;

public interface StudentServiceI {
    /**
     * 通过学生id和密码进行操作
     *
     * @param stu_id   学生id
     * @param password 学生所设置的密码
     * @return 对应的学生实体否则返回null
     */
    Student loginByStuIdAndPass(String stu_id, String password);

    /**
     * 修改学生信息
     *
     * @param currStu 当前登录的学生实体
     */
    boolean changeStudentInfo(Student currStu);

    /**
     * 学生选课业务
     *
     * @param stuId 学生学号
     * @param tchId 教师编号
     * @param dpmId 学员编号
     * @param crsId 课程编号
     * @return 是否成功
     */
    boolean selectCourse(String stuId, String tchId, String dpmId, String crsId);

    /**
     * 取消已选课程
     *
     * @param stuId 学生学号
     * @param tchId 教师号
     * @param dpmId 学院号
     * @param crsId 课程号
     * @return 是否取消
     */
    boolean cancelCourse(String stuId, String tchId, String dpmId, String crsId);

    /**
     * 根据学号获得学生考试信息
     *
     * @param stuId 学号
     * @return 返回考试信息实体
     */
    List<Exam> getExamInfo(String stuId);

    /**
     * 根据学号查找已选课程信息
     *
     * @param stuId 学号
     * @return 已选课程实体集合
     */
    List<StudentSchedule> getSelectedCoursesInfo(String stuId);

    /**
     * 根据学号查询学生所有成绩信息
     *
     * @param stuId      学生学号
     * @param pageNumber 页码
     * @return 所有考试成绩信息
     */
    List<StudentSchedule> getAllScoreInfo(String stuId, int pageNumber);

    /**
     * 分页查找学生已选课程信息
     *
     * @param stuId      学号
     * @param pageNumber 页码
     * @return 已选课程实体集合
     */
    List<StudentSchedule> getSelectedCoursesInfo(String stuId, int pageNumber);

    /**
     * 查询申诉信息
     *
     * @param stuId        学生学号
     * @param pageNumber   页码
     * @param appealStatus 要查询的申诉的申诉状态
     * @return 申诉信息
     */
    String[][] getAppeal(String stuId, int pageNumber, byte appealStatus);

    /**
     * 关闭申诉
     *
     * @param stuId 学号
     * @param dpmId 院系编号
     * @param tchId 教师编号
     * @param crsId 课程编号
     * @return 是否关闭
     */
    boolean closeAppeal(String stuId, String dpmId, String tchId, String crsId);

    /**
     * 申诉
     *
     * @param stuId         学号
     * @param dpmId         院系编号
     * @param tchId         教师编号
     * @param crsId         课程编号
     * @param appealContent 申诉内容
     * @return 是否记录成功
     */
    boolean appeal(String stuId, String dpmId, String tchId, String crsId, String appealContent);

    List<Student> findStudentsByCrsAndDpm(String dpm, String crs);

    void enterScore(List<StudentSchedule> studentSchedules);
}
