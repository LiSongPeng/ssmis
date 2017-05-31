package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.Student;
import team.jiangtao.entity.Teacher;

import java.util.Date;


/**
 * Created by tose on 2017/5/31.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            for(int i = 0;i<10;i++){
                Teacher teacher = new Teacher();
                teacher.setTchId("0000"+i);
                teacher.setDpmId("00"+i);
                teacher.setName("Name"+i);
                Date date = new Date();
                teacher.setBiography("bio"+i);
                teacher.setBirthday(new java.sql.Date(date.getTime()));
                teacher.setPassword("pwd"+i);
                teacher.setPhone("phone"+i);
                session.save(teacher);
            }
            transaction.commit();

        } finally {
            session.close();
            ourSessionFactory.close();
        }

    }
}
