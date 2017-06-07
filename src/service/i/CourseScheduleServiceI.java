package service.i;

import team.jiangtao.entity.CourseSchedule;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface CourseScheduleServiceI {
    Integer ModifyCS(String dpm_id,String crs_id,String tch_id,byte type,byte preriods,byte credit,byte term);
    Integer deleCS(String dpm_id,String crs_id,String tch_id);
    List<CourseSchedule> serfindAllCS();
    CourseSchedule serfindbyid(String crsId, String tchId, String dpmId);
    List<CourseSchedule> findCSbytwo(String tid);
}
