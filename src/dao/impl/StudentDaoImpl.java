package dao.impl;

import dao.i.StudentDaoI;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class StudentDaoImpl implements StudentDaoI {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student findStudentByIdAndPass(int id, String password) {
        Session session=sessionFactory.getCurrentSession();
        Query<Student> query=session.createNamedQuery("queryStudentByIdAndPass",Student.class);
        return query.getSingleResult();
    }
}
