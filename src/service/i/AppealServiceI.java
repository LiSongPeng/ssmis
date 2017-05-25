package service.i;

import team.jiangtao.entity.Appeal;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */
public interface AppealServiceI {

    /**
     *
     * @param appeals
     * @return flag of operation.
     * @throws Exception
     */
    boolean addAppeals(List<Appeal> appeals) throws Exception;


    /**
     *
     * @param conditions
     * @param equalCondition
     * @return Teacher List
     * @throws Exception
     * @conditions:
     * teacher mod : equalCondition == true, student mod : equalCondition == false
     * teacher mod :
     * tch_id,-1==> gets all appeals
     * tch_id,0 ==> gets all new appeals
     * tch_id,1 ==> gets all having read appeals
     * tch_id,2 ==> gets all marked appeals
     * tch_id,3 ==> gets all updated appeals
     * tch_id,4 ==> gets all responded appeals
     * tch_id,5 ==> gets all closed appeals
     * tch_id,6 ==> gets all drafts.
     * key = {tch_id(String), type(Integer)}
     */
    List<Appeal> getAppealsByCondition(Map<String,Object> conditions, boolean equalCondition) throws Exception;


    /**
     *
     * @param appeal
     * @return a flag signaling success or not.
     * @throws Exception
     *
     * status:
     *  0 a new appeal,
     *  1 a read appeal,
     *  2 a marked appeal,
     *  3 a updated appeal,
     *  4 a responded appeal,
     *  5 a closed appeal;
     *
     *  0, 3 are available for students;
     *  1,2,3,4,5, are available for teachers;
     */
    boolean updateAppeal(Appeal appeal) throws Exception;
}
