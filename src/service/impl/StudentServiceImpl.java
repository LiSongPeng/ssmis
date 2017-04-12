package service.impl;


import dao.i.StudentDaoI;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.i.StudentServiceI;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service(value = "studentService")
public class StudentServiceImpl implements StudentServiceI{
    private StudentDaoI studentDao;
    @Resource(name = "studentDao")
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
