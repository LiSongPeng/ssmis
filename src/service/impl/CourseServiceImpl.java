package service.impl;

import dao.i.CourseDaoI;
import dao.i.CourseScheduleDaoI;
import dao.i.CoursesTableDaoI;
import dao.i.StudentScheduleDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.CourseServiceI;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.CoursesTable;
import team.jiangtao.entity.StudentSchedule;

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
    private StudentScheduleDaoI studentScheduleDao;

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
        CoursesTable coursesTable = coursesTableDao.findCoursesTable(crsId, tchId, dpmId);
        String[][] table = new String[5][11];
        String site, off, name, teacher;
        String[] offs;
        String content;
        int offValue;
        site = coursesTable.getSite();
        teacher = coursesTable.getTeacherByTchId().getName();
        name = coursesTable.getCourseByCrsId().getCrsName();
        off = coursesTable.getOff();
        offs = off.split(",");
        String[] sites = site.split(",");
        for (int i = 0; i < offs.length; i++) {
            content = "";
            offValue = Integer.valueOf(offs[i]);
            content += name + "<br/>" + teacher + "<br/>" + sites[i];
            table[offValue / 11][offValue % 11] = content;
        }
        return table;
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
    public List<Course> getallCourse() {
        return courseDao.findallCourse();
    }

    @Override
    @Transactional
    public Integer sercoursetocs(String dpm_id, String crs_id, String tch_id, byte type, byte preriods, byte credit, byte term) {
        courseScheduleDao.fromCoursetoCS(dpm_id, crs_id, tch_id, type, preriods, credit, term);
        return 1;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public String[][] getPersonalCourseTable(String stuId) {
        List<CoursesTable> tables = coursesTableDao.findPersonalCourseTable(stuId);
        String[][] table = new String[5][11];
        String site, off, name, teacher;
        String[] offs, sites;
        String content;
        int offValue;
        for (CoursesTable each : tables) {
            site = each.getSite();
            teacher = each.getTeacherByTchId().getName();
            name = each.getCourseByCrsId().getCrsName();
            off = each.getOff();
            offs = off.split(",");
            sites = site.split(",");
            for (int i = 0; i < offs.length; i++) {
                content = "";
                offValue = Integer.valueOf(offs[i]);
                content += name + "<br/>" + teacher + "<br/>" + sites[i];
                table[offValue / 11][offValue % 11] = content;
            }
        }
        return table;
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

    @Resource(name = "studentScheduleDao")
    public void setStudentScheduleDao(StudentScheduleDaoI studentScheduleDao) {
        this.studentScheduleDao = studentScheduleDao;
    }
}
