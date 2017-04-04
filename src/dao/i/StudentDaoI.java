package dao.i;

import entity.Student;

/**
 * Created by 14423 on 2017-03-23.
 */
public interface StudentDaoI {
    /**
     * 通过学生id和密码从数据库查找对应学生记录
     * @param stu_id 学生id
     * @param password 学生所设置的密码
     * @return 查找到返回对应学生实体，否则返回null
     */
    Student findStudentByStuIdAndPass(String stu_id, String password);
}
