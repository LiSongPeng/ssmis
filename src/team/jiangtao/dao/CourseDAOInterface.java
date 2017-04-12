package team.jiangtao.dao;

import entity.Course;
import team.jiangtao.entity.CourseEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/4/12.
 */
public interface CourseDAOInterface {
    List<CourseEntity> findCourseByConditions(Map<String,Object> conditions, boolean... equalConditions);
}
