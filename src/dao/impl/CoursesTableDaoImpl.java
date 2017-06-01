package dao.impl;

import dao.i.CoursesTableDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.CoursesTable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuibo on 4/24/17.
 */
@Repository(value = "coursesTableDao")
public class CoursesTableDaoImpl implements CoursesTableDaoI {
    private SessionFactory sessionFactory;


    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CoursesTable findCoursesTable(String crsId, String tchId, String dpmId) {
        Session session = sessionFactory.getCurrentSession();
        Query<CoursesTable> query = session.createQuery("from CoursesTable ct where ct.crsId=?1 and ct.tchId=?2 and ct.dpmId=?3", CoursesTable.class);
        query.setParameter(1, crsId);
        query.setParameter(2, tchId);
        query.setParameter(3, dpmId);
        return query.getSingleResult();
    }

    @Override
    public List<CoursesTable> findPersonalCourseTable(String stuId) {
        Session session = sessionFactory.getCurrentSession();
        Query<CoursesTable> query = session.createNativeQuery("SELECT courses_table.* FROM courses_table LEFT JOIN course_schedule ON courses_table.crs_id=course_schedule.crs_id AND  courses_table.dpm_id=course_schedule.dpm_id AND courses_table.tch_id=course_schedule.tch_id LEFT JOIN student_schedule ON course_schedule.tch_id=student_schedule.tch and course_schedule.dpm_id=student_schedule.dpm AND course_schedule.crs_id=student_schedule.crs WHERE student_schedule.stu=?1", CoursesTable.class);
        query.setParameter(1, stuId);
        return query.list();
    }
}
