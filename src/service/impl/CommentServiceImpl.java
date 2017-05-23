package service.impl;

import service.i.CommentServiceI;
import team.jiangtao.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */
public class CommentServiceImpl implements CommentServiceI{
    @Override
    public List<Map<String, Double>> getScoreByType(Integer statType) throws Exception {
        return null;
    }

    @Override
    public List<Comment> getAllComment(String tchId) throws Exception {
        return null;
    }

    @Override
    public boolean addComment(Comment comment) throws Exception {
        return false;
    }

    @Override
    public boolean updateComent(Comment comment) throws Exception {
        return false;
    }
}
