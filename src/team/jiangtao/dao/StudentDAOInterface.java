package team.jiangtao.dao;

import entity.Student;
import team.jiangtao.entity.StudentEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/4/12.
 */
public interface StudentDAOInterface {

    List<StudentEntity> findStudentByConditions(Map<String,Object> conditions, boolean... equalConditions);

    void updateStudentPropertiesByStu_id(Map<String,Object> newValues,String stu_id);

    void deleteStudentByConditions(Map<String,Object> conditions,boolean... equalConditions);

    void addStudents(List<Student> students);

    void updateStudent(Student student);

    void addStudent(Student student);
}
