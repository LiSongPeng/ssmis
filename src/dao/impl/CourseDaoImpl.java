package dao.impl;

import dao.i.CourseDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.CourseSchedule;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lihuibo on 4/5/17.
 */
@Repository(value = "courseDao")
public class CourseDaoImpl implements CourseDaoI {
    private SessionFactory sessionFactory;
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CourseSchedule> findCourseInfoByConditions(Map<String, Object> conditions, boolean... equalConditions) {
        Session session=sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("from course_schedule cs where ");
        int i = 1;
        Set<Map.Entry<String, Object>> entries = conditions.entrySet();
        for (Map.Entry<String, Object> each : entries) {
            if(equalConditions.length==0||equalConditions[i-1])
                hql.append("cs."+each.getKey()+"=:"+each.getKey()+" and ");
            else
                hql.append("cs."+each.getKey()+" like :"+each.getKey()+" and ");
            i++;
        }
        Query<CourseSchedule> query = session.createQuery(hql.substring(0, hql.length() - 5), CourseSchedule.class);
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
