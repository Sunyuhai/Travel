package dao;

import domain.Favorite;
import domain.Route;

import java.util.List;


public interface FavoriteDao  {

    Favorite findFavorite(int rid, int uid);

    int findFavoriteCount(int  rid);

    void addFavorite(int rid, int uid);

    int findUserFavoriteCount(int uid);

    List<Route> findUserRoute(int uid);

    List<Route> favoritePage(int uid, int start, int end);
}
