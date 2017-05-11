package service.i;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface CourseScheduleServiceI {
    Integer ModifyCS(String dpm_id,String crs_id,String tch_id,byte type,byte preriods,byte credit,byte term);
    Integer deleCS(String dpm_id,String crs_id,String tch_id);
}
