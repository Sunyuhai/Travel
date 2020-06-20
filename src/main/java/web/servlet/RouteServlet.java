package web.servlet;

import domain.PageBean;
import domain.Route;
import domain.User;
import service.FavoriteService;
import service.RouteService;
import service.impl.FavoriteServiceImpl;
import service.impl.RoutServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service = new RoutServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取执行的参数
        String cid_str = request.getParameter("cid");
        String currentPage_str = request.getParameter("currentPage");
        String pageSize_str = request.getParameter("pageSize");
        String rname = request.getParameter("rname");
        if(rname==null || rname.length()==0){
            rname=" ";
        }
        //将参数转换为整数类型
        int cid = 1;
        if(cid_str!=null && cid_str.length() >0 && !cid_str.equals("null")){
            cid = Integer.parseInt(cid_str);
        }
        int currentPage = 1;
        if(currentPage_str != null && currentPage_str.length() >0 ){
            currentPage = Integer.parseInt(currentPage_str);
        }
        int pageSize = 5;
        if(pageSize_str != null && pageSize_str.length() >0 ){
            pageSize = Integer.parseInt(pageSize_str);
        }
        PageBean<Route> pageBean = service.PageQuery(cid,currentPage,pageSize,rname);
        writeValueToOutputStream(pageBean,response);
    }
    public void routeInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        Route route = service.findOneRoute(rid);
        writeValueToOutputStream(route,response);
    }
}
