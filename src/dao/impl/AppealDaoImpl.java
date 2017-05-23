package dao.impl;

import dao.i.AppealDaoI;
import team.jiangtao.entity.Appeal;

import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/23.
 */
public class AppealDaoImpl implements AppealDaoI{
    @Override
    public List<Appeal> getAppealsByCondition(Map<String, Object> conditions, boolean... equalConditions) throws Exception {
        return null;
    }

    @Override
    public Appeal getAppealByPK(Appeal appeal) throws Exception {
        return null;
    }

    @Override
    public boolean addAppeal(Appeal appeal) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAppeal(Appeal appeal) throws Exception {
        return false;
    }

    @Override
    public boolean updateAppeal(Appeal appeal) throws Exception {
        return false;
    }
}
