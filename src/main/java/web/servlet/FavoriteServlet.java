package web.servlet;

import domain.PageBean;
import domain.Route;
import domain.User;
import service.FavoriteService;
import service.impl.FavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/favorite/*")
public class FavoriteServlet extends BaseServlet {
    private FavoriteService fService = new FavoriteServiceImpl();
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        int uid;
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            uid = user.getUid();
        }else {
            return;
        }
        fService.addFavorite(rid,uid);
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        int uid;
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            uid = user.getUid();
        }else {
            return;
        }
        boolean flag = fService.isFavorite(rid,uid);
        writeValueToOutputStream(flag,response);
    }
    public void myFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid ;
        int currentPage = 1;
        String c = request.getParameter("currentPage");
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            uid = user.getUid();
        }else {
            return;
        }
        if(c!=null && c.length()>0){
            currentPage = Integer.parseInt(c);
        }
        PageBean<Route> pageBean = fService.favoritePage(uid,currentPage);
        writeValueToOutputStream(pageBean,response);
    }
}
