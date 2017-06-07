package dao.impl;

import dao.i.CourseScheduleDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.CourseSchedulePK;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CourseSchedule> findCourseScheduleByCourseIds(List<String> ids) {

        Session session = sessionFactory.getCurrentSession();
        Query<CourseSchedule> query = session.createQuery("from CourseSchedule cs where cs.crsId in ?1", CourseSchedule.class);
        return query.setParameter(1, ids).list();
    }

    @Override
    public Integer fromCoursetoCS(String dpm_id, String crs_id, String tch_id, byte type, byte preriods, byte credit, byte term) {
        Session session = sessionFactory.getCurrentSession();
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setCrsId(crs_id);
        courseSchedule.setDpmId(dpm_id);
        courseSchedule.setTchId(tch_id);
        courseSchedule.setType(type);
        courseSchedule.setPreriods(preriods);
        courseSchedule.setCredit(credit);
        courseSchedule.setCredit(credit);
        //   System.out.println(courseSchedule.getCredit());
        session.save(courseSchedule);
        return 1;
    }

    @Override
    public Integer modifyCS(String dpm_id, String crs_id, String tch_id, byte type, byte preriods, byte credit, byte term) {
        System.out.println("www"+dpm_id+crs_id+tch_id+type+preriods+credit+term);
        Session session = sessionFactory.getCurrentSession();
        CourseSchedulePK pk = new CourseSchedulePK();
        pk.setCrsId(crs_id);
        pk.setDpmId(dpm_id);
        pk.setTchId(tch_id);
        Query<CourseSchedule> queryupdate = session.createQuery("from CourseSchedule cs where cs.id in ?1", CourseSchedule.class);
        List<CourseSchedule> list = queryupdate.setParameter(1, pk).list();
        CourseSchedule courseSchedule = list.get(0);
        courseSchedule.setType(type);
        courseSchedule.setPreriods(preriods);
        courseSchedule.setCredit(credit);
        courseSchedule.setTerm(term);

        return 1;
    }

    @Override
    public Integer deleteCS(String dpm_id, String crs_id, String tch_id) {
        System.out.println("zzz"+dpm_id+crs_id+tch_id+"zzz");
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from CourseSchedule cs where cs.crsId=? and cs.dpmId=? and cs.tchId=?");
        query.setParameter(0,crs_id);
        query.setParameter(1,dpm_id);
        query.setParameter(2,tch_id);
        query.executeUpdate();
        int flag=1;

        return flag;
    }

    @Override
    public List<CourseSchedule> findallCS() {
        Session session = sessionFactory.getCurrentSession();
        List<CourseSchedule> list = new ArrayList<>();
        String hql="from CourseSchedule";
        Query<CourseSchedule> query=session.createQuery(hql,CourseSchedule.class);
        return query.list();
    }

    @Override
    public List<CourseSchedule> findCSByPageNumber(int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query<CourseSchedule> query = session.createQuery("from CourseSchedule cs", CourseSchedule.class);
        query.setMaxResults(5);
        query.setFirstResult((pageNumber - 1) * 5);
        return query.list();
    }

    @Override
    public List<CourseSchedule> findCSbytwo(String tid) {
        Session session = sessionFactory.getCurrentSession();
        Query<CourseSchedule> query = session.createQuery("from CourseSchedule cs where cs.tchId=?", CourseSchedule.class);
        query.setParameter(0,tid);
        return query.list();
    }


    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
