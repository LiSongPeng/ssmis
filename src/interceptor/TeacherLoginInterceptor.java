package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import team.jiangtao.entity.Teacher;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
public class TeacherLoginInterceptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (isCheck(request.getRequestURI())) {
            Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
            Teacher currTea = (Teacher) session.get("currTea");
            if (null == currTea)
                return "teacherLogin";
        }
        return actionInvocation.invoke();
    }

    private boolean isCheck(String path) {
        if (path.endsWith("teacher/login.action") || path.endsWith("student/verifyImgAction.action")||path.endsWith("student/login.jsp"))
            return false;
        if (path.contains("teacher") && path.endsWith("html"))
            return true;
        return false;
    }
}
