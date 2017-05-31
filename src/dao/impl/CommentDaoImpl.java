package dao.impl;

import dao.i.CommentDaoI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
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
        return null;
    }

    @Override
    public Comment getCommentByPK(Comment comment) throws Exception {
        return null;
    }

    @Override
    public boolean addComments(List<Comment> comments) {
        return false;
    }

    @Override
    public boolean updateComments(List<Comment> comments) {
        return false;
    }

    @Override
    public boolean deleteComments(List<Comment> comments) {
        return false;
    }
}
