package service.impl;


import dao.i.StudentDaoI;
import entity.Student;
import service.i.StudentServiceI;

public class StudentServiceImpl implements StudentServiceI{
    private StudentDaoI studentDao;

    public void setStudentDao(StudentDaoI studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student loginByStuIdAndPass(String stu_id, String password) {
        return studentDao.findStudentByStuIdAndPass(stu_id,password);
    }
}
