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
     * @param equalConditions
     * @return Teacher List
     * @throws Exception
     */
    List<Appeal> getAppealsByCondition(Map<String,Object> conditions, boolean... equalConditions) throws Exception;

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

    /**
     *
     * @param appeal
     * @return update is success or failure
     * @throws Exception
     */
    boolean updateAppeal(Appeal appeal)throws Exception;
}
