package service.i;

import team.jiangtao.entity.Appeal;

import java.util.List;

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
     * @param appealType
     * @return List of Appeals.
     * @throws Exception
     */
    List<Appeal> getAppeals(int appealType) throws Exception;

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
