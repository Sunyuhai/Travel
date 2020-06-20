package dao;

import domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 查询总记录数
     */
    public int findTotalCount(int cid,String rname);
    /**
     * 查询当前页码的记录
     */
    public List<Route> findByPage(int cid,int start,int pageSize,String rname);

    Route findByRoute(int rid);
}
