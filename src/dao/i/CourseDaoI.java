package dao.i;



import team.jiangtao.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by lihuibo on 4/5/17.
 */
public interface CourseDaoI {
    /**
     * 通过特定条件查找课程记录，并返回对应实体对象
     * @param conditions 条件。key-字段，value-对应值。
     * @param equalConditions 对应于每个键值对，是采用=匹配，还是采用like模糊匹配的标志,不传值默认为=
     * @return 实体对象集合
     */
    List<Course> findCourseByConditions(Map<String,Object> conditions, boolean... equalConditions);
}
