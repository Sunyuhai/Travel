package service;

import domain.PageBean;
import domain.Route;

import java.util.List;

public interface FavoriteService {
    boolean isFavorite(String rid, int uid);

    void addFavorite(String rid, int uid);

    List<Route> findFavoritePage(int uid,int start,int pageSize);

    PageBean<Route> favoritePage(int uid , int currentPage);
}
