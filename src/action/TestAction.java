package action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import dao.i.AppealDaoI;
import dao.impl.AppealDaoImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.*;
import service.i.AppealServiceI;
import team.jiangtao.entity.Appeal;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tose on 2017/5/24.
 */
@Namespace("/test")
@ParentPackage("ssmis-default")
@Controller
@Scope(value = "prototype")
public class TestAction extends ActionSupport {
    private AppealServiceI appealServiceI;
    private String condition;
    private String json;


    @Resource(name = "appealService")
    public void setAppealServiceI(AppealServiceI appealServiceI) {
        this.appealServiceI = appealServiceI;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Action(value = "hibernate",results = @Result(type = "json",params = {"root","json"}))
    public String testHibernate() throws Exception {
        List<Appeal> appeals = new ArrayList<>();
        Appeal temp  = new Appeal();
        temp.setCrsId("00000");
        temp.setDpmId("002");
        temp.setTchId("00001");
        temp.setStuId("00001");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse("2017-05-17");
        temp.setDate(new java.sql.Date(parsed.getTime()));
        byte statu = 6;
        temp.setStatus(statu);
        appeals.add(temp);
        boolean flag = appealServiceI.updateAppeals(appeals);
        return SUCCESS;
    }
}
