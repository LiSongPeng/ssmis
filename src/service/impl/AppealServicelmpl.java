package service.impl;

import service.i.AppealServiceI;
import team.jiangtao.entity.Appeal;

import java.util.List;

/**
 * Created by tose on 2017/5/23.
 */
public class AppealServicelmpl implements AppealServiceI {
    @Override
    public boolean addAppeals(List<Appeal> appeals) throws Exception {
        return false;
    }

    @Override
    public List<Appeal> getAppeals(int appealType) throws Exception {
        return null;
    }

    @Override
    public boolean updateAppeal(Appeal appeal) throws Exception {
        return false;
    }
}
