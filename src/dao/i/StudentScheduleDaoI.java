package dao.i;

import team.jiangtao.entity.StudentSchedule;

/**
 * Created by lihuibo on 4/20/17.
 */
public interface StudentScheduleDaoI {
    /**
     * 保存学生选课记录
     * @param studentSchedule 选课记录
     */
    void saveStudentSchedule(StudentSchedule studentSchedule);

    /**
     * 删除学生选课记录
     * @param stuId 学号
     * @param tchId 教师号
     * @param dpmId  学院号
     * @param crsId 课程号
     * @return 返回删除条数
     */
    int deleteStudentSchedule(String stuId, String tchId, String dpmId, String crsId);
}
