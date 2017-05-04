package dao.i;

import team.jiangtao.entity.CourseSchedule;

import java.util.List;

/**
 * Created by lihuibo on 4/20/17.
 */
public interface CourseScheduleDaoI {
    /**
     * 查找课程计划
     *
     * @param crsId 课程编号
     * @param tchId 课程编号
     * @param dpmId 课程开设学院编号
     * @return 课程计划实体
     */
    CourseSchedule findCourseSchedule(String crsId, String tchId, String dpmId);

    /**
     * 根据课程编号查找课程开设信息
     *
     * @param ids 课程编号
     * @return 课程开设信息集合
     */
    List<CourseSchedule> findCourseScheduleByCourseIds(List<String> ids);
}
