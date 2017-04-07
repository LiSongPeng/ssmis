package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import entity.Student;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (isCheck(request.getRequestURI())) {
            Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
            Student currStu = (Student) session.get("currStu");
            if (null == currStu)
                return Action.LOGIN;
        }
        return actionInvocation.invoke();
    }

    private boolean isCheck(String path) {
        if (path.endsWith("login.action")||path.endsWith("verifyImgAction.action")) {
            return false;
        }
        return true;
    }
}
