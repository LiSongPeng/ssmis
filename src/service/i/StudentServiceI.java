package service.i;

import entity.Student;

public interface StudentServiceI {
    /**
     * 通过学生id和密码进行操作
     * @param id 学生id
     * @param password 学生所设置的密码
     * @return 对应的学生实体否则返回null
     */
    Student loginByIdAndPass(int id, String password);
}
