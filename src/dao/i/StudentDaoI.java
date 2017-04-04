package dao.i;

import entity.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by 14423 on 2017-03-23.
 */
public interface StudentDaoI {

    /**
     * 通过特定条件查找学生记录，并返回对应实体对象
     * @param conditions 条件。key-字段，value-对应值。
     *
     * @return 实体对象集合
     */
    List<Student> findStudentByConditions(Map<String,Object> conditions);
}