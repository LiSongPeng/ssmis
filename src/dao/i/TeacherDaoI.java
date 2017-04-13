package dao.i;

import team.jiangtao.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by lihuibo on 4/5/17.
 */
public interface TeacherDaoI {
    List<Teacher> findTeachersByConditions(Map<String,Object> conditions, boolean... equalCondition) throws Exception;

    boolean updateTeacher(Teacher teacher) throws Exception;

    boolean addTeacher(Teacher teacher) throws Exception;

}
