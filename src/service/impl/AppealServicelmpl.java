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

/**
 * Created by tose on 2017/5/23.
 */
//@Service(value = "appealService")
public class AppealServicelmpl implements AppealServiceI {
    private AppealDaoI appealDaoI;

//    @Resource(name = "appealDaoI")
    public void setAppealDaoI(AppealDaoI appealDaoI) {
        this.appealDaoI = appealDaoI;
    }

    public AppealDaoI getAppealDaoI() {
        return appealDaoI;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean addAppeals(List<Appeal> appeals) throws Exception {
        //TODO
        return false;
    }

    @Override
    @Resource(name = "getAppealsDao")
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<Appeal> getAppeals(int appealType) throws Exception {
        //TODO

        return null;
    }

    @Override
    @Resource(name = "updateAppealDao")
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public boolean updateAppeal(Appeal appeal) throws Exception {
        //TODO
        return false;
    }
}
