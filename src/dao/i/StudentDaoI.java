package dao.i;


import team.jiangtao.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by 14423 on 2017-03-23.
 */
public interface StudentDaoI {

    /**
     * 通过特定条件查找学生记录，并返回对应实体对象
     * @param conditions 条件。key-字段，value-对应值。
     *@param equalConditions 对应于每个键值对，是采用=匹配，还是采用like模糊匹配的标志,不传值默认为=
     * @return 实体对象集合
     */
    List<Student> findStudentByConditions(Map<String,Object> conditions, boolean... equalConditions);

    /**
     * 通过学号查找学生，并修改对应学生的多项属性值
     * @param newValues key-value对,key对应学生属性字段名，value对应新的值
     * @param stu_id 指定学生学号
     */
    void updateStudentPropertiesByStu_id(Map<String,Object> newValues,String stu_id);

    /**
     * 通过特定条件删除学生记录
     * @param conditions 条件。key-字段，value-对应值。
     * @param equalConditions 对应于每个键值对，是采用=匹配，还是采用like模糊匹配的标志,不传值默认为=
     */
    void deleteStudentByConditions(Map<String,Object> conditions,boolean... equalConditions);

    /**
     * 添加学生记录
     * @param students 要添加的学生记录实体
     */
    void addStudents(List<Student> students);

    /**
     * 更新student
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 添加student
     * @param student
     */
    void addStudent(Student student);
}