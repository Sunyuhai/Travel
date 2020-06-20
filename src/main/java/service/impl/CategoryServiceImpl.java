package service.impl;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import service.CategoryService;
import util.JedisUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        list = dao.findAll();
        list.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getCid()-o2.getCid();
            }
        });
        return list;
    }
}
