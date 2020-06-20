package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

/*
	1. 澹版槑闈欐�佹暟鎹簮鎴愬憳鍙橀噺
	2. 鍒涘缓杩炴帴姹犲璞�
	3. 瀹氫箟鍏湁鐨勫緱鍒版暟鎹簮鐨勬柟娉�
	4. 瀹氫箟寰楀埌杩炴帴瀵硅薄鐨勬柟娉�
	5. 瀹氫箟鍏抽棴璧勬簮鐨勬柟娉�
 */

public class JDBCUtils {
	// 1.	澹版槑闈欐�佹暟鎹簮鎴愬憳鍙橀噺
	private static DataSource ds;

	// 2. 鍒涘缓杩炴帴姹犲璞�
	static {
		// 鍔犺浇閰嶇疆鏂囦欢涓殑鏁版嵁
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

		Properties pp = new Properties();
		try {
			pp.load(is);
			// 鍒涘缓杩炴帴姹狅紝浣跨敤閰嶇疆鏂囦欢涓殑鍙傛暟
			ds = DruidDataSourceFactory.createDataSource(pp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// 3. 瀹氫箟鍏湁鐨勫緱鍒版暟鎹簮鐨勬柟娉�
	public static DataSource getDataSource() {
		return ds;
	}

	// 4. 瀹氫箟寰楀埌杩炴帴瀵硅薄鐨勬柟娉�
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	// 5.瀹氫箟鍏抽棴璧勬簮鐨勬柟娉�
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	// 6.閲嶈浇鍏抽棴鏂规硶
	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
}
