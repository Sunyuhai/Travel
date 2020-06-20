package service.impl;

import dao.FavoriteDao;
import dao.RouteDao;
import dao.RouteImgDao;
import dao.SellerDao;
import dao.impl.FavoriteDaoImpl;
import dao.impl.RouteDaoImpl;
import dao.impl.RouteImgDaoImpl;
import dao.impl.SellerDaoImpl;
import domain.PageBean;
import domain.Route;
import domain.RouteImg;
import domain.Seller;
import service.RouteService;

import java.util.List;

public class RoutServiceImpl implements RouteService {
    private RouteDao Rdao = new RouteDaoImpl();
    private RouteImgDao Idao = new RouteImgDaoImpl();
    private SellerDao Sdao = new SellerDaoImpl();
    private FavoriteDao fDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> PageQuery(int cid, int currentPage, int pageSize,String rname) {
        //总记录数
        int totalCount = Rdao.findTotalCount(cid,rname);
        //总页数
        int totalPage = totalCount%pageSize==0 ? totalCount/pageSize : totalCount/pageSize+1 ;
        //开始数
        int start = pageSize*(currentPage-1);
        //显示路线集合
        List<Route> list = Rdao.findByPage(cid,start,pageSize,rname);
        //封装PageBean对象并返回
        PageBean<Route> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        pb.setList(list);
        return pb;
    }

    @Override
    public Route findOneRoute(String _rid) {
        int rid = Integer.parseInt(_rid);
        //查询route
        Route route = Rdao.findByRoute(rid);
        //查询商家信息并封装到route
        Seller seller = Sdao.findBySeller(route.getSid());
        route.setSeller(seller);
        //查询图片集合并封装到route
        List<RouteImg> list = Idao.findRouteImg(route.getRid());
        route.setRouteImgList(list);
        //查询收藏次数
        int count = fDao.findFavoriteCount(rid);
        route.setCount(count);
        return route;
    }
}
