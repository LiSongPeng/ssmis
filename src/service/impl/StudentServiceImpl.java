package service.impl;


import dao.i.CourseScheduleDaoI;
import dao.i.StudentDaoI;
import dao.i.StudentScheduleDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.StudentServiceI;
import team.jiangtao.entity.CourseSchedule;
import team.jiangtao.entity.Student;
import team.jiangtao.entity.StudentSchedule;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentServiceI {
    private StudentDaoI studentDao;
    private CourseScheduleDaoI courseScheduleDao;
    private StudentScheduleDaoI studentScheduleDao;

    @Resource(name = "courseScheduleDao")
    public void setCourseScheduleDao(CourseScheduleDaoI courseScheduleDao) {
        this.courseScheduleDao = courseScheduleDao;
    }

    @Resource(name = "studentScheduleDao")
    public void setStudentScheduleDao(StudentScheduleDaoI studentScheduleDao) {
        this.studentScheduleDao = studentScheduleDao;
    }

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

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean changeStudentInfo(Student currStu) {
        boolean result = false;
        studentDao.updateStudent(currStu);
        result = true;
        return result;
    }

    @Override
    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
    public boolean selectCourse(String stuId, String tchId, String dpmId, String crsId) {
        boolean result = false;
        CourseSchedule courseSchedule = courseScheduleDao.findCourseSchedule(crsId, tchId, dpmId);
        StudentSchedule studentSchedule = new StudentSchedule();
        studentSchedule.setCrs(courseSchedule.getCrsId());
        studentSchedule.setDpm(courseSchedule.getDpmId());
        studentSchedule.setTch(courseSchedule.getTchId());
        studentSchedule.setTerm(courseSchedule.getTerm());
        studentScheduleDao.saveStudentSchedule(studentSchedule);
        result = true;
        return result;
    }
}
