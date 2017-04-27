package dao.i;

import team.jiangtao.entity.Exam;
import team.jiangtao.entity.ExamPK;

import java.util.List;

/**
 * Created by lihuibo on 4/27/17.
 */
public interface ExamDaoI {
    /**
     * 通过Exam实体主键查找Exam实体
     *
     * @param ids 主键值
     * @return Exam实体集合
     */
    public List<Exam> findExamsByIds(List<ExamPK> ids);
}
