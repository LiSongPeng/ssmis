package dao.impl;

import dao.i.AppealDaoI;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Appeal;
import team.jiangtao.entity.AppealPK;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */

/**
 * @author Jiang Tao
 */
@Repository(value = "appealDao")
public class AppealDaoImpl implements AppealDaoI {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Appeal> getAppealsByCondition(Map<String, Object> conditions, boolean equalCondition) throws Exception {
        //TO CHECK
        if (equalCondition) {
            //teacher mod
            Session session = sessionFactory.getCurrentSession();
            List list = null;
            Integer con = (Integer) conditions.get("type");
            String tch_id = (String) conditions.get("tch");
            switch (con) {
                case -1: {
                    String hql = "from Appeal appeal where appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }

                case 0: {
                    String hql = "from Appeal appeal where appeal.status = 0 and appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }

                case 1: {
                    String hql = "from Appeal appeal where appeal.status = 1 and appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }

                case 2: {
                    String hql = "from Appeal appeal where appeal.status = 2 and appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }

                case 3: {
                    String hql = "from Appeal appeal where appeal.status = 3 and appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }

                case 4: {
                    String hql = "from Appeal appeal where appeal.status = 4 and appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }

                case 5: {
                    String hql = "from Appeal appeal where appeal.status = 5 and appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }

                case 6: {
                    String hql = "from Appeal appeal where appeal.status = 6 and appeal.tchId=:tch";
                    Query query = session.createQuery(hql);
                    query.setParameter("tch", tch_id);
                    list = query.list();
                    break;
                }
            }
            return list;
        } else {
            //student mod
            //TODO
            return null;
        }

    }

    @Override
    public Appeal getAppealByPK(Appeal appeal) throws Exception {
        //TO CHECK
        Session session = sessionFactory.getCurrentSession();
        List list = null;
        String hql = "from Appeal appeal where appeal.stuId=:stuId and appeal.crsId=:crsId and appeal.tchId=:tchId and appeal.dpmId=:dpmId and appeal.date=date";
        Query query = session.createQuery(hql);
        query.setProperties(appeal);
        list = query.list();
        return (Appeal) list.get(0);
    }

    @Override
    public boolean addAppeals(List<Appeal> appeals) {
        boolean flag = true;
        //TO CHECK
        try {
            Session session = sessionFactory.getCurrentSession();
            for (Appeal appeal : appeals) {
                session.save(appeal);
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteAppeals(List<Appeal> appeals) {
        //TO CHECK
        boolean flag = true;
        try {
            String hql = "delete from Appeal appeal where appeal.stuId=:stuId and appeal.crsId=:crsId and appeal.tchId=:tchId and appeal.dpmId=:dpmId and appeal.date=date";
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(hql);
            for (Appeal appeal : appeals) {
                query.setProperties(appeal);
                query.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Appeal> getAppealsInPage(String stuId, int pageNumber, int appealStatus) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Appeal a where a.stuId=?1 and a.status=?2";
        if (appealStatus == 0)
            hql = "from Appeal a where a.stuId=?1 and a.status<?2";
        Query<Appeal> query = session.createQuery(hql, Appeal.class);
        query.setParameter(1, stuId);
        if (appealStatus == 0)
            query.setParameter(2, 4);
        else
            query.setParameter(2, appealStatus);
        query.setMaxResults(10);
        query.setFirstResult((pageNumber - 1) * 10);
        return query.list();
    }

    @Override
    public int closeAppeal(String stuId, String dpmId, String tchId, String crsId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Appeal a set a.status=?1 where a.id=?2");
        query.setParameter(1, 5);
        AppealPK id = new AppealPK();
        id.setCrsId(crsId);
        id.setDpmId(dpmId);
        id.setTchId(tchId);
        id.setStuId(stuId);
        query.setParameter(2, id);
        return query.executeUpdate();
    }

    @Override
    public boolean updateAppeals(List<Appeal> appeals) {
        //TO CHECK
        boolean flag = true;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (Appeal appeal : appeals) {
                session.update(appeal);
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
