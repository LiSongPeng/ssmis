package service.i;

import team.jiangtao.entity.Teacher;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public interface TeacherServiceI {
    /*
    * 获取教师信息通过id
    * 返回教师对象
    *
    * */
    Teacher findTeacherbuid(String id);
/*
* 更新教师信息
* 返回教师对象
*
* */
    void updateTeacherInfo(Teacher teacher);
}
