package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis宸ュ叿绫�
 */
public final class JedisUtil {
    private static JedisPool jedisPool;

    static {
        //璇诲彇閰嶇疆鏂囦欢
        InputStream is = JedisPool.class.getClassLoader().getResourceAsStream("jedis.properties");
        //鍒涘缓Properties瀵硅薄
        Properties pro = new Properties();
        //鍏宠仈鏂囦欢
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //鑾峰彇鏁版嵁锛岃缃埌JedisPoolConfig涓�
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //鍒濆鍖朖edisPool
        jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));


    }


    /**
     * 鑾峰彇杩炴帴鏂规硶
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 鍏抽棴Jedis
     */
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
