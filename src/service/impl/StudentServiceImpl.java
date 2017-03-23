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
    public Student loginByIdAndPass(int id, String password) {
        return studentDao.findStudentByIdAndPass(id,password);
    }
}
