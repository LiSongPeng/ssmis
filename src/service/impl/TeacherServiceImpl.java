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

    @Override
    @Transactional
    public Teacher findTeacherbuid(String id) {
        return teacherDaoI.findTeacherByPK(id);
    }


    @Resource(name = "TeacherDao")
    public void setTeacherDaoI(TeacherDaoI teacherDaoI) {
        this.teacherDaoI = teacherDaoI;
    }
}
