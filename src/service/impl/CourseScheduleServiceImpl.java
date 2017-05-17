package service.impl;

import dao.i.CourseScheduleDaoI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.i.CourseScheduleServiceI;
import team.jiangtao.entity.CourseSchedule;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
@Service(value = "csService")
public class CourseScheduleServiceImpl implements CourseScheduleServiceI {

    private CourseScheduleDaoI courseScheduleDaoI;

    @Override
    @Transactional
    public Integer ModifyCS(String dpm_id, String crs_id, String tch_id, byte type, byte preriods, byte credit, byte term) {

        return courseScheduleDaoI.modifyCS(dpm_id, crs_id, tch_id, type, preriods, credit, term);
    }

    @Override
    @Transactional
    public Integer deleCS(String dpm_id, String crs_id, String tch_id) {
        courseScheduleDaoI.deleteCS(dpm_id, crs_id, tch_id);
        return 1;
    }

    @Override
    @Transactional
    public List<CourseSchedule> serfindAllCS() {
        return courseScheduleDaoI.findallCS();
    }

    @Resource(name = "courseScheduleDao")
    public void setCourseScheduleDao(CourseScheduleDaoI courseScheduleDao) {
        this.courseScheduleDaoI = courseScheduleDao;
    }
}
