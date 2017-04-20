package dao.impl;

import dao.i.StudentScheduleDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.StudentSchedule;

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
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
}
