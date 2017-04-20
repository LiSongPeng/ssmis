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
}
