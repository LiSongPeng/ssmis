package dao.impl;

import dao.i.CommentDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.jiangtao.entity.Appeal;
import team.jiangtao.entity.Comment;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */
@Repository(value = "commentDao")
public class CommentDaoImpl implements CommentDaoI {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Comment> getCommentsByConditions(Map<String, Object> condition, boolean... equalCondition) throws Exception {
        String tchId = (String) condition.get("tch_id");
        List list = null;
        String hql = "from Comment comment where comment.tch=:tchId";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("tchId",tchId);
        list = query.list();
        return list;
    }

    @Override
    public Comment getCommentByPK(Comment comment) throws Exception {
        List list = null;
        String hql = "from Comment comment where comment.dpm=:dpm and comment.crs=:crs and comment.tch=:tch and comment.date=:date ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setProperties(comment);
        list = query.list();
        return list;
    }

    @Override
    public boolean addComments(List<Comment> comments) {
        boolean flag = true;
        try{
            Session session = sessionFactory.getCurrentSession();
            for(Comment comment:comments){
                session.save(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateComments(List<Comment> comments) {
        boolean flag = true;
        try{
            Session session = sessionFactory.getCurrentSession();
            for(Comment comment:comments){
                session.update(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteComments(List<Comment> comments) {
        boolean flag = true;
        try{
            String hql = "delete from Comment comment where comment.tch=:tch and comment.dpm=:dpm and comment.crs=:crs and comment.date";
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(hql);
            for(Comment comment:comments){
                query.setProperties(comment);
                query.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
