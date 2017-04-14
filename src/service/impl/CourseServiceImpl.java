package service.impl;

import dao.i.CourseDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.CourseServiceI;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CoursesTable;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lihuibo on 4/14/17.
 */
@Service(value = "courseService")
public class CourseServiceImpl implements CourseServiceI {
    private CourseDaoI courseDao;
    @Override
    @Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
    public Course getCourseInfoById(String courseId) {
        Map<String,Object> condition=new HashMap<>(1);
        condition.put("crsId",courseId);
        List<Course> list=courseDao.findCourseByConditions(condition);
        if(list.size()>0)
            return list.get(0);
        return null;
    }

    @Override
    public List<Course> getCoursesInfoByKeyName(String keyName) {
        Map<String,Object> condition=new HashMap<>(1);
        condition.put("crsName",keyName);
        return courseDao.findCourseByConditions(condition,false);
    }

    @Override
    public List<CoursesTable> getCourseTable(String crsId, String tchId, String dpmId) {
        return null;
    }

    @Resource(name = "courseDao")
    public void setCourseDao(CourseDaoI courseDao) {
        this.courseDao = courseDao;
    }
}
