package cyh.redis;

import cyh.util.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class RedisUtil {
	// 服务器ip，端口
	private static String IP = Config.getIP();
	private static int PORT = Config.getPORT();
	private static int MAX_ACTIVE = Config.getMAX_ACTIVE();
	private static int MAX_IDLE = Config.getMAX_IDLE();
	private static int MAX_WAIT = Config.getMAX_WAIT();
	private static int TIMEOUT = Config.getTIMEOUT();
	private static boolean TEST_ON_BORROW = Config.isTEST_ON_BORROW();

	private static JedisPool jedisPool = null;
	
	/**
	 * 初始化Redis连接池
	 */
	static{
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, IP, PORT, TIMEOUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Jedis实例
	 * @return
	 */
	public synchronized static Jedis getJedis(){
		try {
			if(jedisPool!=null){
				Jedis resource=jedisPool.getResource();
				return resource;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 释放资源
	 * @param jedis
	 */
	@SuppressWarnings("deprecation")
	public static void returnResource(final Jedis jedis){
		if(jedis!=null){
			jedisPool.returnResource(jedis);
		}
	}
}
