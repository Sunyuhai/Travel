package service.impl;

import dao.FavoriteDao;
import dao.impl.FavoriteDaoImpl;
import domain.Favorite;
import domain.PageBean;
import domain.Route;
import service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao fDao = new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(String _rid, int uid) {
        boolean flag = false;
        int rid = Integer.parseInt(_rid);
        Favorite favorite = fDao.findFavorite(rid,uid);
        if(favorite!=null){
            flag = true ;
        }
        return flag;
    }

    @Override
    public void addFavorite(String _rid, int uid) {
        int rid = Integer.parseInt(_rid);
        fDao.addFavorite(rid,uid);
    }

    @Override
    public List<Route> findFavoritePage(int uid,int start,int pageSize) {
        return fDao.favoritePage(uid,start,pageSize);
    }

    @Override
    public PageBean<Route> favoritePage(int uid , int currentPage) {
        PageBean<Route> pageBean = new PageBean<>();
        //总记录数
         int totalCount = fDao.findUserFavoriteCount(uid);
         pageBean.setTotalCount(totalCount);
        //总页数
         int totalPage = totalCount % 12==0 ? totalCount/12 : totalCount/12+1;
         pageBean.setTotalPage(totalPage);
         //当前页码
        pageBean.setCurrentPage(currentPage);
        //每页显示条数
         int pageSize = 12;
         int start = (currentPage-1)*pageSize;
        //每页显示的数据集合
         List<Route> list = findFavoritePage(uid,start,pageSize);
         pageBean.setList(list);
        return pageBean;
    }
}
