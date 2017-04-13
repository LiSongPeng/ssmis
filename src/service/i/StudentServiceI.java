package service.i;


import team.jiangtao.entity.Student;

public interface StudentServiceI {
    /**
     * 通过学生id和密码进行操作
     * @param stu_id 学生id
     * @param password 学生所设置的密码
     * @return 对应的学生实体否则返回null
     */
    Student loginByStuIdAndPass(String stu_id, String password);
}
