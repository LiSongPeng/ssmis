package dao.impl;

import dao.i.StudentDaoI;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDaoImpl implements StudentDaoI {
    private SessionFactory sessionFactory;
    private Session session;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
    }

    @Override
    public List<Student> findStudentByConditions(Map<String, Object> conditions, boolean... equalConditions) {
        StringBuilder hql = new StringBuilder("from student stu where ");
        int i = 1;
        Set<Map.Entry<String, Object>> entries = conditions.entrySet();
        for (Map.Entry<String, Object> each : entries) {
            if (equalConditions.length == 0 || equalConditions[i - 1])
                hql.append("stu." + each.getKey() + "=:" + each.getKey() + " and ");
            else
                hql.append("stu." + each.getKey() + " like :" + each.getKey() + " and ");
            i++;
        }
        Query<Student> query = session.createQuery(hql.substring(0, hql.length() - 5), Student.class);
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
    public void updateStudentPropertiesByStu_id(Map<String, Object> newValues, String stu_id) {
        StringBuilder hql = new StringBuilder("update student stu set ");
        Set<Map.Entry<String, Object>> entries = newValues.entrySet();
        for (Map.Entry<String, Object> each : entries) {
            hql.append("stu." + each.getKey() + "=:" + each.getKey() + ",");
        }
        Query query = session.createQuery(hql.substring(0, hql.length() - 1) + " where stu.id=" + stu_id);
        for (Map.Entry<String, Object> each : entries) {
            query.setParameter(each.getKey(), each.getValue());
        }
        query.executeUpdate();
    }

    @Override
    public void deleteStudentByConditions(Map<String, Object> conditions, boolean... equalConditions) {
        StringBuilder hql = new StringBuilder("delete from student stu where ");
        int i = 1;
        Set<Map.Entry<String, Object>> entries = conditions.entrySet();
        for (Map.Entry<String, Object> each : entries) {
            if (equalConditions.length == 0 || equalConditions[i - 1])
                hql.append("stu." + each.getKey() + "=:" + each.getKey() + " and ");
            else
                hql.append("stu." + each.getKey() + " like :" + each.getKey() + " and ");
            i++;
        }
        Query query = session.createQuery(hql.substring(0, hql.length() - 5));
        i = 1;
        for (Map.Entry<String, Object> each : entries) {
            if (equalConditions.length == 0 || equalConditions[i - 1])
                query.setParameter(each.getKey(), each.getValue());
            else
                query.setParameter(each.getKey(), "%" + each.getValue() + "%");
            i++;
        }
        query.executeUpdate();
    }

    @Override
    public void addStudents(List<Student> students) {
        if (students.size() == 0)
            return;
        session.getTransaction().begin();
        for (Student each : students) {
            session.save(each);
        }
        session.getTransaction().commit();
    }

    @Override
    public void updateStudent(Student student) {
        session.update(student);
    }

    @Override
    public void addStudent(Student student) {
        session.save(student);
    }
}
