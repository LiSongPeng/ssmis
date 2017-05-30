package dao.i;

import team.jiangtao.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/4/13.
 */
public interface CommentDaoI {
    /**
     *
     * @param condition
     * @param equalCondition
     * @return comment
     * @throws Exception
     */
    List<Comment> getCommentsByConditions(Map<String,Object> condition, boolean... equalCondition) throws Exception;

    /**
     *
     * @param comment
     * @return
     * @throws Exception
     */
    Comment getCommentByPK(Comment comment)throws Exception;

    /**
     *
     * @param comments
     * @return comment
     * @throws Exception
     */
    boolean addComments(List<Comment> comments)throws Exception;

    /**
     *
     * @param comment
     * @return flag of result
     * @throws Exception
     */
    boolean addComment(Comment comment)throws Exception;

    /**
     *
     * @param comments
     * @return flag
     * @throws Exception
     */
    boolean updateComments(List<Comment> comments)throws Exception;

    /**
     *
     * @param comment
     * @return flag
     * @throws Exception
     */
    boolean updateComment(Comment comment)throws Exception;

    /**
     *
     * @param comments
     * @return flag
     * @throws Exception
     */
    boolean deleteComments(List<Comment> comments)throws Exception;

    /**
     *
     * @param comment
     * @return flag
     * @throws Exception
     */
    boolean deleteComent(Comment comment)throws Exception;
}
