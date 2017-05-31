package dao.impl;

import dao.i.AppealDaoI;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Appeal;

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
public class AppealDaoImpl implements AppealDaoI{
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Appeal> getAppealsByCondition(Map<String,Object> conditions, boolean equalCondition) throws Exception {
        //TO CHECK
        if(equalCondition){
            //teacher mod
            Session session = sessionFactory.getCurrentSession();
            List list = null;
            Integer con = (Integer) conditions.get("type");
            switch (con){
                case -1:{
                    String hql = "from Appeal";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }

                case 0:{
                    String hql = "from Appeal appeal where appeal.status = 0";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }

                case 1:{
                    String hql = "from Appeal appeal where appeal.status = 1";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }

                case 2:{
                    String hql = "from Appeal appeal where appeal.status = 2";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }

                case 3:{
                    String hql = "from Appeal appeal where appeal.status = 3";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }

                case 4:{
                    String hql = "from Appeal appeal where appeal.status = 4";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }

                case 5:{
                    String hql = "from Appeal appeal where appeal.status = 5";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }

                case 6:{
                    String hql = "from Appeal appeal where appeal.status = 6";
                    Query query = session.createQuery(hql);
                    list = query.list();
                    break;
                }
            }
            return list;
        }else{
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
        String hql = "from Appeal appeal where appeal.crsId=:crsId and appeal.dpmId=:dpmId and appeal.stuId=:stuId and appeal.date=:date";
        Query query = session.createQuery(hql);
        query.setProperties(appeal);
        list = query.list();
        return (Appeal) list.get(0);
    }

    @Override
    public boolean addAppeal(List<Appeal> appeals) {
        //TO CHECK
        try{
            Session session = sessionFactory.getCurrentSession();
            for(Appeal appeal : appeals){
                session.save(appeal);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAppeal(List<Appeal> appeals) {
        return false;
    }

    @Override
    public boolean updateAppeal(List<Appeal> appeals) {
        //TO CHECK
        try{
            Session session = sessionFactory.getCurrentSession();
            for(Appeal appeal : appeals){
                session.update(appeal);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
