package dao.i;

import team.jiangtao.entity.Teacher;
import java.util.List;
import java.util.Map;

/**
 * Created by lihuibo on 4/5/17.
 */
public interface TeacherDaoI {

    /**
     *
     * @param conditions
     * @param equalCondition
     * @return teachers
     * @throw0s Exception
     */
    List<Teacher> findTeachersByConditions(Map<String,Object> conditions, boolean... equalCondition) throws Exception;

    /**
     *
     * @param tid with a not-null PK
     * @return teacher
     */
    Teacher findTeacherByPK(String tid);

    /**
     *
     * @param teacher
     * @return update successfully or fail
     * @throws Exception
     */
    boolean updateTeacher(Teacher teacher) throws Exception;


    /**
     *
     * @param teacher
     * @return addTeacher successfully or fail
     * @throws Exception
     */
    boolean addTeacher(Teacher teacher) throws Exception;

}
