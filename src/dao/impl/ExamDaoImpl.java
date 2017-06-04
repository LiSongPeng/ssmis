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
        Session session = sessionFactory.getCurrentSession();
        String hql="from Exam";
        Query<Exam> query=session.createQuery(hql,Exam.class);
        return query.list();
    }

    @Override
    public void modifyExam(String dpm, String crs, String date, String location, byte status) {
        Session session = sessionFactory.getCurrentSession();
        ExamPK examPK = new ExamPK();
        examPK.setCrs(crs);
        examPK.setDpm(dpm);
        Query<Exam> updatequery = session.createQuery("from Exam e where e.id in ?1", Exam.class);
        List<Exam> list = updatequery.setParameter(1, examPK).list();
        Exam exam = list.get(0);
        exam.setDate(date);
        exam.setLocation(location);
        exam.setStatus(status);
    }

    @Override
    public void fromCStoExam(String dpm, String crs, String date, String location, byte status) {
        System.out.println(dpm+crs+date+location+status);
        Session session = sessionFactory.getCurrentSession();
        Exam exam = new Exam();
        exam.setDpm(dpm);
        exam.setCrs(crs);
        exam.setLocation(location);
        exam.setDate(date);
        exam.setLocation(location);
        session.save(exam);

    }

    @Override
    public void delExam(String dpm, String crs) {
        Session session = sessionFactory.getCurrentSession();
        ExamPK examPK = new ExamPK();
        examPK.setDpm(dpm);
        examPK.setCrs(crs);
        Query<Exam> query = session.createQuery("delete from Exam e where e.id in ?1");
        query.setParameter(1, examPK);
        query.executeUpdate();

    }

    @Override
    public List<Exam> findebyid(ExamPK id) {
        Session session = sessionFactory.getCurrentSession();
        String dp=id.getDpm();
        String cr=id.getCrs();
        Query<Exam> query = session.createQuery("from Exam e where e.dpm = ? and e.crs= ?", Exam.class);
        query.setParameter(0,dp);
        query.setParameter(1,cr);
        return query.list();
    }


}
