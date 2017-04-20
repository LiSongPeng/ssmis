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

    /**
     * 修改学生信息
     * @param currStu 当前登录的学生实体
     */
    boolean changeStudentInfo(Student currStu);

    /**
     * 学生选课业务
     * @param stuId 学生学号
     * @param tchId 教师编号
     * @param dpmId 学员编号
     * @param crsId 课程编号
     * @return 是否成功
     */
    boolean selectCourse(String stuId, String tchId, String dpmId, String crsId);

    /**
     * 取消已选课程
     * @param stuId 学生学号
     * @param tchId 教师号
     * @param dpmId 学院号
     * @param crsId 课程号
     * @return 是否取消
     */
    boolean cancelCourse(String stuId, String tchId, String dpmId, String crsId);
}
