package dao.impl;

import dao.i.TeacherDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Teacher;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
@Repository(value = "TeacherDao")
public class TeacherDaoImpl implements TeacherDaoI {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Teacher> findTeachersByConditions(Map<String, Object> conditions, boolean... equalCondition) throws Exception {
        return null;
    }

    @Override
    public Teacher findTeacherByPK(String tid) {
        Session session=sessionFactory.getCurrentSession();
        Query<Teacher> query = session.createQuery("from Teacher t where t.id in ?1", Teacher.class);
        query.setParameter(1,tid);
        return query.list().get(0);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws Exception {
        return false;
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws Exception {
        return false;
    }
}
