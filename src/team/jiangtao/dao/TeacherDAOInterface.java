package team.jiangtao.dao;

import entity.Student;
import team.jiangtao.entity.TeacherEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/4/12.
 */
public interface TeacherDAOInterface {
    List<TeacherEntity> findTeacherEntitesByConditions(Map<String,Object> conditions, boolean... equalConditions);

    void updateTeacherPropertiesByTch_id(Map<String,Object> newValues,String tch_id);

    void deleteTeachersByConditions(Map<String,Object> conditions,boolean... equalConditions);

    void addTeachers(List<Student> teacher);

    void updateTeacher(TeacherEntity teacherEntity);

    void addTeacher(TeacherEntity teacherEntity);
}
