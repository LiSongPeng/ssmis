package dao.impl;

import dao.i.StudentScheduleDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.StudentSchedule;
import team.jiangtao.entity.StudentSchedulePK;

import javax.annotation.Resource;

/**
 * Created by lihuibo on 4/20/17.
 */
@Repository(value = "studentScheduleDao")
public class StudentScheduleDaoImpl implements StudentScheduleDaoI {
    private SessionFactory sessionFactory;
    @Override
    public void saveStudentSchedule(StudentSchedule studentSchedule) {
        Session session=sessionFactory.getCurrentSession();
        session.save(studentSchedule);
    }

    @Override
    public int deleteStudentSchedule(String stuId, String tchId, String dpmId, String crsId) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("delete from StudentSchedule ss where ss.id=?1");
        StudentSchedulePK pk=new StudentSchedulePK();
        pk.setCrs(crsId);
        pk.setDpm(dpmId);
        pk.setStu(stuId);
        pk.setTch(tchId);
        query.setParameter(1,pk);
        return query.executeUpdate();
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
}
