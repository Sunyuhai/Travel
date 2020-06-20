package dao.impl;

import dao.SellerDao;
import domain.Seller;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据sid查询tab_seller表格并返回一个seller对象
     * @param id sid
     * @return Seller对象
     */
    @Override
    public Seller findBySeller(int id) {
        String sql = "select * from tab_seller where sid=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Seller.class),id);
    }
}
