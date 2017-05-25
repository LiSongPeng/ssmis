package dao.i;

import team.jiangtao.entity.Appeal;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/4/13.
 */
public interface AppealDaoI {

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
     * @param appeal with no-null PKs
     * @return Appeal
     * @throws Exception
     */
    Appeal getAppealByPK(Appeal appeal) throws Exception;

    /**
     *
     * @param appeal
     * @return flag signed success or failure
     * @throws Exception
     */
    boolean updateAppeal(Appeal appeal) throws Exception;

    /**
     *
     * @param appeal
     * @return adding is success or failure
     * @throws Exception
     */
    boolean addAppeal(Appeal appeal)throws Exception;

    /**
     *
     * @param appeal
     * @return detete is success or failure
     * @throws Exception
     */
    boolean deleteAppeal(Appeal appeal)throws Exception;

}
