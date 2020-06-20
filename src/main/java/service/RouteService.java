package service;

import domain.PageBean;
import domain.Route;

public interface RouteService {
    PageBean<Route> PageQuery(int cid, int currentPage, int pageSize,String rname);

    Route findOneRoute(String rid);


}