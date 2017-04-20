package dao.impl;

import dao.i.CourseScheduleDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.CourseSchedulePK;

import javax.annotation.Resource;

/**
 * Created by lihuibo on 4/20/17.
 */
@Repository(value = "courseScheduleDao")
public class CourseScheduleDaoImpl implements CourseScheduleDaoI {
    private SessionFactory sessionFactory;

    @Override
    public CourseSchedule findCourseSchedule(String crsId, String tchId, String dpmId) {
        Session session = sessionFactory.getCurrentSession();
        CourseSchedulePK pk = new CourseSchedulePK();
        pk.setCrsId(crsId);
        pk.setDpmId(dpmId);
        pk.setTchId(tchId);
        Query<CourseSchedule> query = session.createQuery("from CourseSchedule cs where cs.id=?1", CourseSchedule.class);
        query.setParameter(1, pk);
        return query.uniqueResult();
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
