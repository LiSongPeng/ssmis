package service.impl;

import dao.i.CourseDaoI;
import dao.i.CourseScheduleDaoI;
import dao.i.CoursesTableDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.CourseServiceI;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.CoursesTable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lihuibo on 4/14/17.
 */
@Service(value = "courseService")
public class CourseServiceImpl implements CourseServiceI {
    private CourseDaoI courseDao;
    private CourseScheduleDaoI courseScheduleDao;
    private CoursesTableDaoI coursesTableDao;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public CourseSchedule getCourseInfo(String crsId, String dpmId, String tchId) {
        return courseScheduleDao.findCourseSchedule(crsId, tchId, dpmId);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<CourseSchedule> getCoursesInfoByKeyName(String keyName) {
        Map<String, Object> condition = new HashMap<>(1);
        condition.put("crsName", keyName);
        List<Course> courses = courseDao.findCourseByConditions(condition, false);
        List<String> ids = new ArrayList<>(courses.size());
        for (Course each : courses) {
            ids.add(each.getCrsId());
        }
        return courseScheduleDao.findCourseScheduleByCourseIds(ids);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public String[][] getCourseTable(String crsId, String tchId, String dpmId) {
        List<CoursesTable> table = coursesTableDao.findCoursesTable(crsId, tchId, dpmId);
        String[][] tables = new String[5][5];
        for (int i = 0; i < tables.length; i++) {
            for (int j = 0; j < tables[i].length; j++) {
                tables[i][j] = "";
            }
        }
        String courseName = table.get(0).getCourseByCrsId().getCrsName();
        int offset = 0;
        for (CoursesTable each : table) {

        }
        return null;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<CourseSchedule> getCourseInfoById(String courseId) {
        List<String> ids = new ArrayList<>(1);
        ids.add(courseId);
        return courseScheduleDao.findCourseScheduleByCourseIds(ids);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<Course> getallCourse(){
        return courseDao.findallCourse();
    }

    @Override
    @Transactional
    public Integer sercoursetocs(String dpm_id, String crs_id, String tch_id, byte type, byte preriods, byte credit, byte term) {
        courseScheduleDao.fromCoursetoCS(dpm_id,crs_id,tch_id,type,preriods,credit,term);
        return 1;
    }

    @Resource(name = "courseDao")
    public void setCourseDao(CourseDaoI courseDao) {
        this.courseDao = courseDao;
    }

    @Resource(name = "courseScheduleDao")
    public void setCourseScheduleDao(CourseScheduleDaoI courseScheduleDao) {
        this.courseScheduleDao = courseScheduleDao;
    }

    @Resource(name = "coursesTableDao")
    public void setCoursesTableDao(CoursesTableDaoI coursesTableDao) {
        this.coursesTableDao = coursesTableDao;
    }
}
