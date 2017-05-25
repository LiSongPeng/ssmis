package action;

import com.opensymphony.xwork2.ActionSupport;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Action(value = "hibernate",results = @Result(type = "json",params = {"root","json"}))
    public String testHibernate(){

        return SUCCESS;
    }
}
