package service.impl;

import dao.i.CourseDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.CourseServiceI;
import team.jiangtao.entity.CourseSchedule;
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
    public CourseSchedule getCourseInfo(String crsId, String dpmId, String tchId) {
        Map<String,Object> condition=new HashMap<>(1);
        condition.put("crsId",crsId);
        condition.put("dpmId",dpmId);
        condition.put("tchId",tchId);
        List<CourseSchedule> list=courseDao.findCourseInfoByConditions(condition);
        if(list.size()>0)
            return list.get(0);
        return null;
    }

    @Override
    public List<CourseSchedule> getCoursesInfoByKeyName(String keyName) {
        Map<String,Object> condition=new HashMap<>(1);
        condition.put("crsName",keyName);
        return courseDao.findCourseInfoByConditions(condition,false);
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
