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
        session=sessionFactory.openSession();
    }

    @Override
    public List<Student> findStudentByConditions(Map<String, Object> conditions) {
        StringBuilder hql=new StringBuilder("select stu from student stu where ");
        int i=1;
        Set<Map.Entry<String,Object>> entries=conditions.entrySet();
        for(Map.Entry<String,Object> each:entries){
            hql.append("stu."+each.getKey()+"=?"+i+" and ");
            i++;
        }
        Query<Student> query=session.createQuery(hql.substring(0,hql.length()-5).toString(),Student.class);
        i=1;
        for(Map.Entry<String,Object> each:entries){
            query.setParameter(i,each.getValue());
            i++;
        }
        return query.list();
    }
}
