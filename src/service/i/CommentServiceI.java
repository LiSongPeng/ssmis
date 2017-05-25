package service.i;

import team.jiangtao.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */
public interface CommentServiceI {
    /**
     *
     * @param statType
     * @return Key-Value list.
     * @throws Exception
     */
    List<Map<String,Double>> getScoreByType(Integer statType) throws Exception;

    /**
     *
     * @param tchId
     * @return List of Comments.
     * @throws Exception
     */
    List<Comment> getAllComment(String tchId) throws Exception;

    /**
     *
     * @param comment
     * @return flag of operation.
     * @throws Exception
     */
    boolean addComment(Comment comment) throws Exception;

    /**
     *
     * @param comment
     * @return flag of operation.
     * @throws Exception
     */
    boolean updateComent(Comment comment) throws Exception;

}
