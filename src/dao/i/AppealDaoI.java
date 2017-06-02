package dao.i;

import team.jiangtao.entity.Appeal;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/4/13.
 */
public interface AppealDaoI {

    /**
     * @param conditions
     * @param equalCondition
     * @return Teacher List
     * @throws Exception
     * @conditions: teacher mod : equalCondition == true, student mod : equalCondition == false
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
    List<Appeal> getAppealsByCondition(Map<String, Object> conditions, boolean equalCondition) throws Exception;

    /**
     * @param appeal with no-null PKs
     * @return Appeal
     * @throws Exception
     */
    Appeal getAppealByPK(Appeal appeal) throws Exception;

    /**
     * @param appeals
     * @return flag signed success or failure
     * @throws Exception
     */
    boolean updateAppeals(List<Appeal> appeals);

    /**
     * @param appeals
     * @return adding is success or failure
     * @throws Exception
     */
    boolean addAppeals(List<Appeal> appeals);

    /**
     * @param appeals
     * @return detete is success or failure
     * @throws Exception
     */
    boolean deleteAppeals(List<Appeal> appeals);

    /**
     * 分页查询申诉信息
     *
     * @param stuId        学生学号
     * @param pageNumber   页码
     * @param appealStatus 要查询的申诉信息的申诉状态
     * @return 申诉信息
     */
    List<Appeal> getAppealsInPage(String stuId, int pageNumber, byte appealStatus);

    /**
     * 将Appeal表对应记录状态改成已关闭5状态
     *
     * @param stuId 学号
     * @param dpmId 学院编号
     * @param tchId 教师编号
     * @param crsId 课程编号
     * @return 影响的列
     */
    int closeAppeal(String stuId, String dpmId, String tchId, String crsId);

    boolean saveAppeal(Appeal appeal);
}
