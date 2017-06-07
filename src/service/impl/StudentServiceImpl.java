package service.impl;


import dao.i.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.StudentServiceI;
import team.jiangtao.entity.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentServiceI {
    private StudentDaoI studentDao;
    private CourseScheduleDaoI courseScheduleDao;
    private StudentScheduleDaoI studentScheduleDao;
    private ExamDaoI examDao;
    private CoursesTableDaoI courseTableDao;
    private AppealDaoI appealDao;

    @Resource(name = "examDao")
    public void setExamDao(ExamDaoI examDao) {
        this.examDao = examDao;
    }

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


    @Resource(name = "coursesTableDao")
    public void setCourseTableDao(CoursesTableDaoI courseTableDao) {
        this.courseTableDao = courseTableDao;
    }

    @Resource(name = "appealDao")
    public void setAppealDao(AppealDaoI appealDao) {
        this.appealDao = appealDao;
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
        return studentDao.updateStudent(currStu);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean selectCourse(String stuId, String tchId, String dpmId, String crsId) {
        boolean conflict = false;
        Map<String, Object> condtions = new HashMap<>(4);
        condtions.put("stu", stuId);
        condtions.put("dpm", dpmId);
        condtions.put("tch", tchId);
        condtions.put("crs", crsId);
        List<StudentSchedule> studentSchedules = studentScheduleDao.findStudentScheduleByConditions(condtions);
        if (studentSchedules.size() > 0)
            return false;
        CourseSchedule courseSchedule = courseScheduleDao.findCourseSchedule(crsId, tchId, dpmId);
        CoursesTable coursesTable = courseTableDao.findCoursesTable(crsId, tchId, dpmId);
        List<CoursesTable> list = courseTableDao.findPersonalCourseTable(stuId);
        if (list != null) {
            String[] weeks = coursesTable.getWeeks().split(",");
            String eachWeek;
            String[] offs = coursesTable.getOff().split(",");
            String eachOff;
            int i, j;
            for (CoursesTable each : list) {
                eachWeek = each.getWeeks();
                eachOff = each.getOff();
                for (i = 0; i < weeks.length; i++) {
                    if (eachWeek.contains(weeks[i]) && (eachWeek.indexOf(weeks[i]) == 0 || eachWeek.charAt(eachWeek.indexOf(weeks[i]) - 1) == ',') && (eachWeek.indexOf(weeks[i]) == eachWeek.length() - 1 || eachWeek.charAt(eachWeek.indexOf(weeks[i]) + 1) == ',')) {
                        for (j = 0; j < offs.length; j++) {
                            if (eachOff.contains(offs[i]) && (eachOff.indexOf(offs[i]) == 0 || eachOff.charAt(eachOff.indexOf(offs[i]) - 1) == ',') && (eachOff.indexOf(offs[i]) == eachOff.length() - 1 || eachOff.charAt(eachOff.indexOf(offs[i]) + 1) == ',')) {
                                conflict = true;
                            }
                        }
                    }
                }
            }
        }
        if (conflict)
            return false;
        StudentSchedule studentSchedule = new StudentSchedule();
        studentSchedule.setCrs(courseSchedule.getCrsId());
        studentSchedule.setDpm(courseSchedule.getDpmId());
        studentSchedule.setTch(courseSchedule.getTchId());
        studentSchedule.setTerm(courseSchedule.getTerm());
        studentSchedule.setTerm(courseSchedule.getTerm());
        studentSchedule.setStu(stuId);
        studentScheduleDao.saveStudentSchedule(studentSchedule);
        return true;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean cancelCourse(String stuId, String tchId, String dpmId, String crsId) {
        return studentScheduleDao.deleteStudentSchedule(stuId, tchId, dpmId, crsId) > 0 ? true : false;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<Exam> getExamInfo(String stuId) {
        Map<String, Object> conditons = new HashMap<>(1);
        conditons.put("stu", stuId);
        List<StudentSchedule> schedules = studentScheduleDao.findStudentScheduleByConditions(conditons);
        List<ExamPK> examPKList = new ArrayList<>(schedules.size());
        ExamPK examPK;
        for (StudentSchedule each : schedules) {
            examPK = new ExamPK();
            examPK.setCrs(each.getCrs());
            examPK.setDpm(each.getDpm());
            examPKList.add(examPK);
        }
        return examDao.findExamsByIds(examPKList);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<StudentSchedule> getSelectedCoursesInfo(String stuId) {
        Map<String, Object> condition = new HashMap<>(1);
        condition.put("stu", stuId);
        return studentScheduleDao.findStudentScheduleByConditions(condition);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<StudentSchedule> getAllScoreInfo(String stuId, int pageNumber) {
        return studentScheduleDao.findStudentSchedules(stuId, pageNumber);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<StudentSchedule> getSelectedCoursesInfo(String stuId, int pageNumber) {
        return studentScheduleDao.findStudentSchedules(stuId, pageNumber);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public String[][] getAppeal(String stuId, int pageNumber, byte appealStatus) {
        List<Appeal> list = appealDao.getAppealsInPage(stuId, pageNumber, appealStatus);
        String[][] appeals = null;
        if (list.size() > 0) {
            String status = null;
            java.sql.Date date;
            appeals = new String[list.size()][9];
            for (int i = 0; i < appeals.length; i++) {
                appeals[i][0] = list.get(i).getCrsId();
                appeals[i][1] = list.get(i).getDpmId();
                appeals[i][2] = list.get(i).getTchId();
                appeals[i][3] = list.get(i).getCourseByCrsId().getCrsName();
                appeals[i][4] = list.get(i).getDepartmentByDpmId().getDpmName();
                date = list.get(i).getDate();
                appeals[i][5] = date.toLocaleString();
                appeals[i][6] = list.get(i).getContent();
                switch (list.get(i).getStatus()) {
                    case 0:
                        status = "新建";
                        break;
                    case 1:
                        status = "已读";
                        break;
                    case 2:
                        status = "已标记";
                        break;
                    case 3:
                        status = "已更新";
                        break;
                    case 4:
                        status = "已回执";
                        break;
                    case 5:
                        status = "已关闭";
                        break;
                }
                appeals[i][7] = status;
                appeals[i][8] = list.get(i).getResponse();
            }
        }
        return appeals;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean closeAppeal(String stuId, String dpmId, String tchId, String crsId) {
        if (appealDao.closeAppeal(stuId, dpmId, tchId, crsId) > 0)
            return true;
        return false;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean appeal(String stuId, String dpmId, String tchId, String crsId, String appealContent) {
        Appeal appeal = new Appeal();
        appeal.setContent(appealContent);
        appeal.setCrsId(crsId);
        appeal.setTchId(tchId);
        appeal.setDpmId(dpmId);
        appeal.setDate(new java.sql.Date(new java.util.Date().getTime()));
        appeal.setStuId(stuId);
        return appealDao.saveAppeal(appeal);
    }

    @Override
    @Transactional
    public List<Student> findStudentsByCrsAndDpm(String dpm, String crs) {
        return studentScheduleDao.findStudentsByCrsAndDpm(dpm, crs);
    }

    @Override
    @Transactional
    public void enterScore(List<StudentSchedule> studentSchedules) {
        studentSchedules.forEach(studentSchedule -> {
            StudentSchedule schedule = studentScheduleDao.findByStuAndCrsAndDpm(studentSchedule.getStu(), studentSchedule.getCrs(), studentSchedule.getDpm());
            schedule.setScore(studentSchedule.getScore());
            schedule.setExamStatus(studentSchedule.getExamStatus());
        });
    }

    @Override
    @Transactional
    public List<StudentSchedule> pullSSbyTch(String tchId)throws Exception{
        return studentScheduleDao.findTeacherCourses(tchId);
   }
}
