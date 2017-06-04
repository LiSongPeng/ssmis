package dao.i;

import team.jiangtao.entity.Student;
import team.jiangtao.entity.StudentSchedule;

import java.util.List;
import java.util.Map;

/**
 * Created by lihuibo on 4/20/17.
 */
public interface StudentScheduleDaoI {
    /**
     * 保存学生选课记录
     *
     * @param studentSchedule 选课记录
     */
    void saveStudentSchedule(StudentSchedule studentSchedule);

    /**
     * 删除学生选课记录
     *
     * @param stuId 学号
     * @param tchId 教师号
     * @param dpmId 学院号
     * @param crsId 课程号
     * @return 返回删除条数
     */
    int deleteStudentSchedule(String stuId, String tchId, String dpmId, String crsId);

    /**
     * 通过特定条件查找学生选课记录，并返回对应实体对象
     *
     * @param conditions      条件。key-字段，value-对应值。
     * @param equalConditions 对应于每个键值对，是采用=匹配，还是采用like模糊匹配的标志,不传值默认为=
     * @return 实体对象集合
     */
    List<StudentSchedule> findStudentScheduleByConditions(Map<String, Object> conditions, boolean... equalConditions);

    /**
     * 分页查找学生已选课程
     * @param stuId 学号
     * @param pageNumber 页码
     * @return 学生选课实体
     */
    List<StudentSchedule> findStudentSchedules(String stuId, int pageNumber);

    List<Student> findStudentsByCrsAndDpm(String dpm, String crs);

    StudentSchedule findByStuAndCrsAndDpm(String stu, String crs, String dpm);

    List<StudentSchedule> findTeacherCourses(String tid);
}
