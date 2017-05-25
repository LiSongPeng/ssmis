package dao.impl;

import dao.i.CommentDaoI;
import team.jiangtao.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */
public class CommentDaoImpl implements CommentDaoI {
    @Override
    public List<Comment> getCommentsByConditions(Map<String, Object> condition, boolean... equalCondition) throws Exception {
        //TODO
        return null;
    }

    @Override
    public Comment getCommentByPK(Comment comment) throws Exception {
        //TODO
        return null;
    }

    @Override
    public boolean addComments(List<Comment> comments) throws Exception {
        //TODO
        return false;
    }

    @Override
    public boolean addComment(Comment comment) throws Exception {
        //TODO
        return false;
    }

    @Override
    public boolean updateComments(List<Comment> comments) throws Exception {
        //TODO
        return false;
    }

    @Override
    public boolean updateComment(Comment comment) throws Exception {
        //TODO
        return false;
    }

    @Override
    public boolean deleteComments(List<Comment> comments) throws Exception {
        //TODO
        return false;
    }

    @Override
    public boolean deleteComent(Comment comment) throws Exception {
        //TODO
        return false;
    }
}
