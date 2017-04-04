package service.impl;


import dao.i.StudentDaoI;
import entity.Student;
import service.i.StudentServiceI;

import java.util.HashMap;
import java.util.Map;

public class StudentServiceImpl implements StudentServiceI{
    private StudentDaoI studentDao;

    public void setStudentDao(StudentDaoI studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student loginByStuIdAndPass(String stu_id, String password) {
        Map<String,Object> conditions=new HashMap<>(2);
        conditions.put("stu_id",stu_id);
        conditions.put("password",password);
        return studentDao.findStudentByConditions(conditions).get(0);
    }
}
