package dao.impl;

import dao.i.CourseDaoI;
import entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lihuibo on 4/5/17.
 */
public class CourseDaoImpl implements CourseDaoI {
    private SessionFactory sessionFactory;
    private Session session;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
    }

    @Override
    public List<Course> findCourseByConditions(Map<String, Object> conditions, boolean... equalConditions) {
        StringBuilder hql = new StringBuilder("from course c where ");
        int i = 1;
        Set<Map.Entry<String, Object>> entries = conditions.entrySet();
        for (Map.Entry<String, Object> each : entries) {
            if(equalConditions.length==0||equalConditions[i-1])
                hql.append("c."+each.getKey()+"=:"+each.getKey()+" and ");
            else
                hql.append("c."+each.getKey()+" like :"+each.getKey()+" and ");
            i++;
        }
        Query<Course> query = session.createQuery(hql.substring(0, hql.length() - 5), Course.class);
        i = 1;
        for (Map.Entry<String, Object> each : entries) {
            if(equalConditions.length==0||equalConditions[i-1])
                query.setParameter(each.getKey(),each.getValue());
            else
                query.setParameter(each.getKey(),"%"+each.getValue()+"%");
            i++;
        }
        return query.list();
    }
}
