package service.i;

import team.jiangtao.entity.Course;
import team.jiangtao.entity.CoursesTable;

import java.util.List;

/**
 * Created by lihuibo on 4/14/17.
 */
public interface CourseServiceI {
    /**
     * 通过课程号查找课程信息
     *
     * @param courseId 课程编号
     * @return 课程实体对象
     */
    public Course getCourseInfoById(String courseId);

    /**
     * 通过课程名称关键字进行模糊查询
     *
     * @param keyName 课程名称关键字
     * @return 查找到的课程实体集合
     */
    public List<Course> getCoursesInfoByKeyName(String keyName);

    /**
     * 通过开设课程课程号,教师号,院系号获得此课程的课程安排信息
     *
     * @param crsId 课程号
     * @param tchId 教师号
     * @param dpmId 院系号
     * @return 课程安排试题信息
     */
    public List<CoursesTable> getCourseTable(String crsId, String tchId, String dpmId);
}
