package dao.impl;

import dao.i.StudentDaoI;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class StudentDaoImpl implements StudentDaoI {
    private SessionFactory sessionFactory;
    private Session session;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session=sessionFactory.openSession();
    }

    @Override
    public Student findStudentByStuIdAndPass(String stu_id, String password) {
        Query<Student> query=session.createNamedQuery("queryStudentByStuIdAndPass",Student.class);
        query.setParameter(1,stu_id);
        query.setParameter(2,password);
        return query.uniqueResult();
    }
}
