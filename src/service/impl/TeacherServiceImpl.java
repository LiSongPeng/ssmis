package service.impl;

import dao.i.TeacherDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.i.TeacherServiceI;
import team.jiangtao.entity.Teacher;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherServiceI {
    private TeacherDaoI teacherDaoI;
/*
* 获取教师信息通过id
* 返回教师对象
*
*
* */
    @Override
    @Transactional
    public Teacher findTeacherbuid(String id) {
        return teacherDaoI.findTeacherByPK(id);
    }
/*
* 更新教师信息
*
* */
    @Override
    @Transactional
    public void updateTeacherInfo(Teacher teacher) {
        Teacher t = teacherDaoI.findTeacherByPK(teacher.getTchId());
        t.setAddress(teacher.getAddress());
        t.setBirthday(teacher.getBirthday());
        t.setEmail(teacher.getEmail());
        t.setName(teacher.getName());
        t.setPhone(teacher.getPhone());
        t.setBiography(teacher.getBiography());
    }

    @Resource(name = "TeacherDao")
    public void setTeacherDaoI(TeacherDaoI teacherDaoI) {
        this.teacherDaoI = teacherDaoI;
    }
}
