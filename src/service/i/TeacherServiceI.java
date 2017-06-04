package service.i;

import team.jiangtao.entity.Teacher;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public interface TeacherServiceI {
    Teacher findTeacherbuid(String id);

    void updateTeacherInfo(Teacher teacher);
}
