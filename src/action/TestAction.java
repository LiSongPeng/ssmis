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

import javax.annotation.Resource;
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
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("tch_id","0001");
        stringObjectMap.put("type",5);
        appealServiceI.getAppealsByCondition(stringObjectMap,true);
        return SUCCESS;
    }
}
