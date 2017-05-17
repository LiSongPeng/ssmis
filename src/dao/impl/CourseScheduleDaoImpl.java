package dao.impl;

import dao.i.CourseScheduleDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.CourseSchedulePK;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuibo on 4/20/17.
 */
@Repository(value = "courseScheduleDao")
public class CourseScheduleDaoImpl implements CourseScheduleDaoI {
    private SessionFactory sessionFactory;

    @Override
    public CourseSchedule findCourseSchedule(String crsId, String tchId, String dpmId) {
        Session session = sessionFactory.getCurrentSession();
        CourseSchedulePK pk = new CourseSchedulePK();
        pk.setCrsId(crsId);
        pk.setDpmId(dpmId);
        pk.setTchId(tchId);
        Query<CourseSchedule> query = session.createQuery("from CourseSchedule cs where cs.id=?1", CourseSchedule.class);
        query.setParameter(1, pk);
        return query.uniqueResult();
    }

    @Override
    public List<CourseSchedule> findCourseScheduleByCourseIds(List<String> ids) {
        Session session = sessionFactory.getCurrentSession();
        Query<CourseSchedule> query = session.createQuery("from CourseSchedule cs where cs.crsId in ?1", CourseSchedule.class);
        return query.setParameter(1,ids).list();
    }

    @Override
    public Integer fromCoursetoCS(String dpm_id, String crs_id, String tch_id, byte type, byte preriods, byte credit, byte term) {
        Session session=sessionFactory.getCurrentSession();
            CourseSchedule courseSchedule = new CourseSchedule();
            courseSchedule.setCrsId(crs_id);
            courseSchedule.setDpmId(dpm_id);
            courseSchedule.setTchId(tch_id);
            courseSchedule.setType(type);
            courseSchedule.setPreriods(preriods);
            courseSchedule.setCredit(credit);
            courseSchedule.setCredit(credit);
         //   System.out.println(courseSchedule.getCredit());
            session.save(courseSchedule);
        return 1;
    }

    @Override
    public Integer modifyCS(String dpm_id, String crs_id, String tch_id, byte type, byte preriods, byte credit, byte term) {
        Session session = sessionFactory.getCurrentSession();
        CourseSchedulePK pk = new CourseSchedulePK();
        pk.setCrsId(crs_id);
        pk.setDpmId(dpm_id);
        pk.setTchId(tch_id);
        Query<CourseSchedule> queryupdate = session.createQuery("from CourseSchedule cs where cs.id in ?1" , CourseSchedule.class);

        List<CourseSchedule> list=queryupdate.setParameter(1, pk).list();
        CourseSchedule courseSchedule=list.get(0);
        courseSchedule.setType(type);
        courseSchedule.setPreriods(preriods);
        courseSchedule.setCredit(credit);
        courseSchedule.setTerm(term);
        return  1;
    }

    @Override
    public Integer deleteCS(String dpm_id, String crs_id, String tch_id) {
        Session session=sessionFactory.getCurrentSession();
        CourseSchedulePK pk = new CourseSchedulePK();
        pk.setCrsId(crs_id);
        pk.setDpmId(dpm_id);
        pk.setTchId(tch_id);
        Query query=session.createQuery("delete from CourseSchedule cs where cs.id=?1");
        query.setParameter(1,pk);
        int flag=query.executeUpdate();

        return flag;
    }

    @Override
    public List<CourseSchedule> findallCS() {
        Session session=sessionFactory.getCurrentSession();
        List<CourseSchedule> list=new ArrayList<>();
        final String sql="select * from course_schedule";
        CourseSchedule courseSchedule=new CourseSchedule();
        try{
        session.doWork(
                new Work() {
                    @Override
                    public void execute(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement( sql );
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            courseSchedule.setCrsId(rs.getString("crs_id"));
                            courseSchedule.setDpmId(rs.getString("dpm_id"));
                            courseSchedule.setTchId(rs.getString("tch_id"));
                            courseSchedule.setType(rs.getByte("type"));
                            courseSchedule.setPreriods(rs.getByte("preriods"));
                            courseSchedule.setCredit(rs.getByte("credit"));
                            courseSchedule.setTerm(rs.getByte("term"));
                            list.add(courseSchedule);
                        }



                    }
                }
        );}catch(Exception ex){
                ex.printStackTrace();
            }
        finally{
                this.doClose(session, null, null);
            }
        return list;
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
        }}


    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
