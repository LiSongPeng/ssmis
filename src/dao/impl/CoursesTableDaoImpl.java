package dao.impl;

import dao.i.CoursesTableDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.CoursesTable;

import javax.annotation.Resource;
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
    public List<CoursesTable> findCoursesTable(String crsId, String tchId, String dpmId) {
        Session session = sessionFactory.getCurrentSession();
        Query<CoursesTable> query = session.createQuery("from CoursesTable ct where ct.crsId=?1 and ct.tchId=?2 and ct.dpmId=?3", CoursesTable.class);
        query.setParameter(1, crsId);
        query.setParameter(2, tchId);
        query.setParameter(3, dpmId);
        return query.list();
    }
}
