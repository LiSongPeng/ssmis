package dao.i;

import team.jiangtao.entity.CoursesTable;

import java.util.List;

/**
 * Created by lihuibo on 4/24/17.
 */
public interface CoursesTableDaoI {
    /**
     * 通过给定条件查找课表
     *
     * @param crsId 课程号
     * @param tchId 教师号
     * @param dpmId 学院号
     * @return 课表实体集合
     */
    public CoursesTable findCoursesTable(String crsId, String tchId, String dpmId);

    /**
     * 查找个人课表
     *
     * @param stuId 学生学号
     * @return 各个课程时间安排集合
     */
    List<CoursesTable> findPersonalCourseTable(String stuId);
}
