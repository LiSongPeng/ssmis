package dao.impl;

import dao.i.StudentScheduleDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Student;
import team.jiangtao.entity.StudentSchedule;
import team.jiangtao.entity.StudentSchedulePK;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lihuibo on 4/20/17.
 */
@Repository(value = "studentScheduleDao")
public class StudentScheduleDaoImpl implements StudentScheduleDaoI {
    private SessionFactory sessionFactory;

    @Override
    public void saveStudentSchedule(StudentSchedule studentSchedule) {
        Session session = sessionFactory.getCurrentSession();
        session.save(studentSchedule);
    }

    @Override
    public int deleteStudentSchedule(String stuId, String tchId, String dpmId, String crsId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from StudentSchedule ss where ss.id=?1");
        StudentSchedulePK pk = new StudentSchedulePK();
        pk.setCrs(crsId);
        pk.setDpm(dpmId);
        pk.setStu(stuId);
        pk.setTch(tchId);
        query.setParameter(1, pk);
        return query.executeUpdate();
    }

    @Override
    public List<StudentSchedule> findStudentScheduleByConditions(Map<String, Object> conditions, boolean... equalConditions) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("from StudentSchedule ss where ");
        int i = 1;
        Set<Map.Entry<String, Object>> entries = conditions.entrySet();
        for (Map.Entry<String, Object> each : entries) {
            if (equalConditions.length == 0 || equalConditions[i - 1])
                hql.append("ss." + each.getKey() + "=:" + each.getKey() + " and ");
            else
                hql.append("ss." + each.getKey() + " like :" + each.getKey() + " and ");
            i++;
        }
        Query<StudentSchedule> query = session.createQuery(hql.substring(0, hql.length() - 5), StudentSchedule.class);
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
    public List<StudentSchedule> findStudentSchedules(String stuId, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query<StudentSchedule> query = session.createQuery("from StudentSchedule ss where ss.stu=?1", StudentSchedule.class);
        query.setParameter(1, stuId);
        query.setMaxResults(5);
        query.setFirstResult((pageNumber - 1) * 5);
        return query.list();
    }

    @Override
    public List<Student> findStudentsByCrsAndDpm(String dpm, String crs) {
        String hql = "from StudentSchedule where dpm = ? and crs = ?";
        Session session = sessionFactory.getCurrentSession();
        Query<StudentSchedule> query = session.createQuery(hql, StudentSchedule.class);
        query.setParameter(0, dpm);
        query.setParameter(1, crs);
        List<StudentSchedule> list = query.list();
        List<Student> students = new ArrayList<>();
        for (StudentSchedule studentSchedule : list) {
            students.add(studentSchedule.getStudentByStu());
        }
        return students;
    }

    @Override
    public StudentSchedule findByStuAndCrsAndDpm(String stu, String crs, String dpm) {
        String hql = "from StudentSchedule where stu = ? and crs = ? and dpm =?";
        Session session = sessionFactory.getCurrentSession();
        Query<StudentSchedule> query = session.createQuery(hql, StudentSchedule.class);
        query.setParameter(0, stu);
        query.setParameter(1, crs);
        query.setParameter(2, dpm);
        return query.uniqueResult();
    }

    @Override
    public List<StudentSchedule> findTeacherCourses(String tid) {
        String hql = "from StudentSchedule where tch = ?";
        Session session = sessionFactory.getCurrentSession();
        Query<StudentSchedule> query = session.createQuery(hql, StudentSchedule.class);
        query.setParameter(0, tid);
        return query.list();
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
