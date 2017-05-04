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
    public List<CoursesTable> findCoursesTable(String crsId, String tchId, String dpmId);
}
