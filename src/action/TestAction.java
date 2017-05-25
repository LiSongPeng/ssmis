package action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.*;
import team.jiangtao.entity.Appeal;

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
    private String condition;
    private String json;

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
    public String testHibernate(){
        Appeal appeal  = new Appeal();
        appeal.setContent("a");
        appeal.setDpmId("4");
        appeal.setCrsId("12313");
        json = JSON.toJSONString(appeal);
//        System.out.println(json);
        return SUCCESS;
    }
}
