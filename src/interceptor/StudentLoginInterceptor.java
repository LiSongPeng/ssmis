package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import team.jiangtao.entity.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class StudentLoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (isCheck(request.getRequestURI())) {
            Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
            Student currStu = (Student) session.get("currStu");
            if (null == currStu)
                return "studentLogin";
        }
        return actionInvocation.invoke();
    }

    private boolean isCheck(String path) {
        if (path.endsWith("student/login.action") || path.endsWith("student/verifyImgAction.action")||path.endsWith("student/login.jsp"))
            return false;
        if (path.contains("student") && path.endsWith("jsp"))
            return true;
        return false;
    }
}
