package dao.impl;

import dao.FavoriteDao;
import domain.Favorite;
import domain.Route;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findFavorite(int rid, int uid) {
        Favorite favorite = null;
        try{
            String sql = "select * from tab_favorite where rid=? and uid = ?";
            favorite = template.queryForObject(sql,new BeanPropertyRowMapper<>(Favorite.class),rid,uid);
        }catch (Exception e){}
        return favorite;
    }

    @Override
    public int findFavoriteCount(int id) {
        int count = 0;
        try {
            String sql = "select count(*) from tab_favorite where rid=?";
            count = template.queryForObject(sql, Integer.class, id);
        }catch (Exception e){}
        return count;
    }

    @Override
    public void addFavorite(int rid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?) ";
        template.update(sql,rid,new Date(),uid);
    }

    @Override
    public int findUserFavoriteCount(int uid) {
        String sql = "select count(*) from tab_favorite where uid=?";
        return template.queryForObject(sql,Integer.class,uid);
    }

    @Override
    public List<Route> findUserRoute(int uid) {
        String sql = "select * from tab_route where rid in (elect rid from tab_favorite where uid=?)";
        return template.query(sql,new BeanPropertyRowMapper<>(Route.class),uid);
    }

    @Override
    public List<Route> favoritePage(int uid, int start, int pageSize) {
        String sql = "select * from tab_route where rid in (select rid from tab_favorite where uid=?) LIMIT ?, ?";
        return template.query(sql,new BeanPropertyRowMapper<>(Route.class),uid,start,pageSize);
    }
}
