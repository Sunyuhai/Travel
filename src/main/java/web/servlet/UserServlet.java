package web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


/**
 * 对用户操作模块的封装。
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
     //处理响应结果的对象
    private ResultInfo info = new ResultInfo();
    /**
     * 注册方法
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!checkCode(request)){
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            String json = writeValueToString(info);
            //使用response写回页面
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
            return;
        }

        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service完成注册
        UserService service = new UserServiceImpl();
        boolean flag = service.register(user);

        //响应结果
        if (flag) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
            info.setErrorMsg("注册失败！");
        }
        String json = writeValueToString(info);
        //使用response写回页面
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 登录方法
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!checkCode(request)){
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            writeValueToOutputStream(info,response);
        }

        Map map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        User u = service.login(user);

        if(u == null){
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误！");
        }if(u != null && !"Y".equals(u.getStatus())){
            info.setFlag(false);
            info.setErrorMsg("您还没有激活，请激活！");
        }if(u != null && "Y".equals(u.getStatus())){
            info.setFlag(true);
            //将user存入session
            request.getSession().setAttribute("user",u);
        }
        writeValueToOutputStream(info,response);
    }

    /**
     * 激活邮件
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        UserService service = new UserServiceImpl();
        boolean flag = service.active(code);
        String msg = null;
        if(flag){
            msg = "<h3>激活成功！请<a href='login.html'>登录</a></h3>";
        }else{
            msg = "<h3>注册失败，请联系管理员！</h3>";
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(msg);
    }

    /**
     * 查找用户
     */
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        writeValueToOutputStream(user,response);
    }

    /**
     * 退出方法
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
}
