package service.impl;

import dao.i.AppealDaoI;
import org.hamcrest.core.Is;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.i.AppealServiceI;
import team.jiangtao.entity.Appeal;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */
@Service(value = "appealService")
public class AppealServicelmpl implements AppealServiceI {
    private AppealDaoI appealDaoI;

    @Resource(name = "appealDao")
    public void setAppealDaoI(AppealDaoI appealDaoI) {
        this.appealDaoI = appealDaoI;
    }

    public AppealDaoI getAppealDaoI() {
        return appealDaoI;
    }

    @Override
    @Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
    public List<Appeal> getAppealsByCondition(Map<String, Object> conditions, boolean equalCondition) throws Exception {
        return appealDaoI.getAppealsByCondition(conditions,equalCondition);
    }

    @Override
    @Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
    public Appeal getAppealByPK(Appeal appeal) throws Exception {
        return appealDaoI.getAppealByPK(appeal);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean updateAppeals(List<Appeal> appeals) {
        return appealDaoI.updateAppeals(appeals);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean addAppeals(List<Appeal> appeals) {
        return appealDaoI.addAppeals(appeals);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean deleteAppeals(List<Appeal> appeals) {
        return appealDaoI.deleteAppeals(appeals);
    }
}
