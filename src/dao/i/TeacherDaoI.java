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
     * @throws Exception
     */
    List<Teacher> findTeachersByConditions(Map<String,Object> conditions, boolean... equalCondition) throws Exception;

    /**
     *
     * @param teacher with a not-null PK
     * @return teacher
     */
    Teacher findTeacherByPK(Teacher teacher);

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
