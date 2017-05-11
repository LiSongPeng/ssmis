package dao.impl;

import dao.i.ExamDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.ExamPK;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lihuibo on 4/27/17.
 */
@Repository(value = "examDao")
public class ExamDaoImpl implements ExamDaoI {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Exam> findExamsByIds(List<ExamPK> ids) {
        Session session = sessionFactory.getCurrentSession();
        Query<Exam> query = session.createQuery("from Exam e where e.id in ?1", Exam.class);
        query.setParameter(1, ids);
        return query.list();
    }

    @Override
    public List<Exam> findAllExams() {
        Session session=sessionFactory.getCurrentSession();
        Query<Exam> query=session.createQuery("from Exam");
        return query.list();
    }
}
