package dao.impl;

import dao.RouteDao;
import domain.Route;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询当前分类的总记录数
     * @param cid 旅游分类的id号
     * @return 该分类的总记录数
     */
    @Override
    public int findTotalCount(int cid,String rname) {
        String sql = "select count(*) from tab_route where 1=1 ";
        List params = new ArrayList<>();
        StringBuilder sb = new StringBuilder(sql);
        if(cid != 0){
            sb.append(" and cid=?");
            params.add(cid);
        }
        if(rname != null && rname.length()>0){
            sb.append(" and rname like ?");
            params.add("%"+rname+"%");
        }
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class,params.toArray());
    }

    /**
     * 查询当前页面显示旅游线路的集合
     * @param cid 当前分类的id号
     * @param start 开始
     * @param pageSize 每页显示条数
     * @return 当前页面的集合
     */
    @Override
    public List<Route> findByPage(int cid, int start, int pageSize,String rname) {
        String sql = null;
        List<Route> list = null;
        boolean idEmpty = cid==0;
        boolean nameEmpty = rname.equals(" ");
        if(!idEmpty && nameEmpty){
            sql = "select * from tab_route where cid=? limit ? , ? ";
            list = template.query(sql,new BeanPropertyRowMapper<>(Route.class),cid,start,pageSize);
            return list;
        }
        if(idEmpty && !nameEmpty){
            sql = "select * from tab_route where rname like ? limit ? , ? ";
            rname = "%"+rname+"%";
            list = template.query(sql,new BeanPropertyRowMapper<>(Route.class),rname,start,pageSize);
            return list;
        }
        if(idEmpty && nameEmpty){
            sql = "select * from tab_route limit ?,?";
            list = template.query(sql,new BeanPropertyRowMapper<>(Route.class),start,pageSize);
            return list;
        }
        else{
            sql = "SELECT * FROM tab_route WHERE cid=? AND rname LIKE ? LIMIT ?,?";
            rname = "%"+rname+"%";
            list = template.query(sql,new BeanPropertyRowMapper<>(Route.class),cid,rname,start,pageSize);
            return list;
        }
    }

    /**
     * 根据rid查询route信息
     * @param id rid
     * @return 封装好的Route集合
     */
    @Override
    public Route findByRoute(int id) {
        String sql = "select * from tab_route where  rid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Route.class),id);
    }
}
