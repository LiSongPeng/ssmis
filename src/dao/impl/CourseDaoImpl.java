package dao.impl;

import page.Page;
import dao.i.CourseDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Course;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
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
    public List<Course> findCourseByConditions(Map<String, Object> conditions, boolean... equalConditions) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("from Course c where ");
        int i = 1;
        Set<Map.Entry<String, Object>> entries = conditions.entrySet();
        for (Map.Entry<String, Object> each : entries) {
            if (equalConditions.length == 0 || equalConditions[i - 1])
                hql.append("c." + each.getKey() + "=:" + each.getKey() + " and ");
            else
                hql.append("c." + each.getKey() + " like :" + each.getKey() + " and ");
            i++;
        }
        Query<Course> query = session.createQuery(hql.substring(0, hql.length() - 5), Course.class);
        i = 1;
        for (Map.Entry<String, Object> each : entries) {
            if (equalConditions.length == 0 || equalConditions[i - 1])
                query.setParameter(each.getKey(), each.getValue());
            else
                query.setParameter(each.getKey(), "%" + each.getValue() + "%");
            i++;
        }
        return query.list();
    }

    @Override
    public Page findallCourse(int cpage) {
        Session session = sessionFactory.getCurrentSession();
        String countHql = "select count(*) from Course";
        Query<Long> query = session.createQuery(countHql, Long.class);
        Long count = query.uniqueResult();
        Page page = new Page();
        page.setCurrentPage(cpage);
        page.setTotalCount(count);

        List<Course> list = new ArrayList<>();
        int startindex = (cpage - 1) * 6;
        try {
            session.doWork(
                    new Work() {
                        @Override
                        public void execute(Connection connection) throws SQLException {
                            String sql = "select * from course limit " + startindex + ", 6";
                            PreparedStatement ps = connection.prepareStatement(sql);
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                Course course = new Course();
                                course.setCrsId(rs.getString("crs_id"));
                                course.setCrsName(rs.getString("crs_name"));
                                course.setSummarization(rs.getString("summarization"));
                                list.add(course);
                            }

                        }
                    }
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.doClose(session, null, null);
        }
        page.setData(list);
        return page;
    }

    @Override
    public List<Course> findbyname(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Course c where c.crsName like '%" + name + "%'";
        Query<Course> query = session.createQuery(hql, Course.class);
        return query.list();
    }


    protected void doClose(Session session, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (Exception ex) {
                rs = null;
                ex.printStackTrace();
            }
        }
        // Statement对象关闭时,会自动释放其管理的一个ResultSet对象
        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (Exception ex) {
                stmt = null;
                ex.printStackTrace();
            }
        }
    }
}
