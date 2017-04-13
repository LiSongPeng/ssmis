package service.impl;


import dao.i.StudentDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.StudentServiceI;
import team.jiangtao.entity.Student;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentServiceI {
    private StudentDaoI studentDao;

    @Resource(name = "studentDao")
    public void setStudentDao(StudentDaoI studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Student loginByStuIdAndPass(String stu_id, String password) {
        Map<String, Object> conditions = new HashMap<>(2);
        conditions.put("stuId", stu_id);
        conditions.put("password", password);
        List<Student> list = studentDao.findStudentByConditions(conditions);
        if (list.size() > 0)
            return list.get(0);
        return null;
    }
}
