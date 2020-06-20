package dao.impl;

import dao.RouteImgDao;
import domain.RouteImg;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据rid查询tab_route_img 表并返回封装好的list集合
     * @param id rid
     * @return List<RouteImg>集合
     */
    @Override
    public List<RouteImg> findRouteImg(int id) {
        String sql = "select * from tab_route_img where rid =?";
        return template.query(sql,new BeanPropertyRowMapper<>(RouteImg.class),id);
    }
}
