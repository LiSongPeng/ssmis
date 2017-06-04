package dao.impl;

import dao.i.ExamDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Exam;
import team.jiangtao.entity.ExamPK;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuibo on 4/27/17.
 */
@Repository(value = "examDao")
public class ExamDaoImpl implements ExamDaoI {
    private static final String Examed_HQL = "from Exam e where e.status = 3 and dpm = ?";


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
        final String sql = "select * from exam";
        List<Exam> list = new ArrayList<>();
        Exam exam = new Exam();
        try {
            session.doWork(
                    new Work() {
                        @Override
                        public void execute(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement(sql);
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) {
                                exam.setDpm(rs.getString("dpm"));
                                exam.setCrs(rs.getString("crs"));
                                exam.setDate(rs.getString("date"));
                                exam.setLocation(rs.getString("location"));
                                exam.setStatus(rs.getByte("status"));
                                list.add(exam);
                            }

                        }
                    }
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.doClose(session, null, null);
        }

        return list;
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

    protected void doClose(Session session, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (Exception ex) {
                rs = null;
                ex.printStackTrace();
            }
        }
        // Statement对象关闭时,会自动释放其管理的一个ResultSet对象
        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (Exception ex) {
                stmt = null;
                ex.printStackTrace();
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Exam> getExamed(String dpmId){
        Session session = sessionFactory.getCurrentSession();
        Query<Exam> query = session.createQuery(Examed_HQL, Exam.class);
        query.setParameter(0, dpmId);
        return query.list();
    }
}
