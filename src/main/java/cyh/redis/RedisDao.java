package cyh.redis;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import cyh.util.SHAUtil;

public class RedisDao {
	/**
	 * 限时存储验证码键值对
	 * @param emailOrTel
	 * @param code
	 */
	public static void saveCode(String emailOrTel,String code){
		Logger logger=Logger.getLogger(RedisDao.class);
		Jedis jedis=RedisUtil.getJedis();
		Map<String, String> map = new HashMap<String, String>();
		//code加密
		String ecode=SHAUtil.getEncrypted(code);
		// 添加数据
		map.put("emailOrTel", emailOrTel);
		map.put("code", ecode);
		
		jedis.hmset(emailOrTel, map);
		//设置时限为20分钟
		jedis.expire(emailOrTel, 1200);
		
		logger.info("emailOrTel:"+jedis.hmget(emailOrTel, "emailOrTel")+"\n"+"code:"+jedis.hmget(emailOrTel, "code"));
	}
	/**
	 * 获取code
	 * @param emailOrTel
	 * @return
	 */
	public static String getCode(String emailOrTel){
		Logger logger=Logger.getLogger(RedisDao.class);
		Jedis jedis=RedisUtil.getJedis();
		String code=jedis.hmget(emailOrTel, "code").get(0);
		logger.info("emailOrTel:"+jedis.hmget(emailOrTel, "emailOrTel")+"\n"+"code:"+jedis.hmget(emailOrTel, "code"));
		return code;
	}
	
	public static void main(String args[]){
		RedisUtil.getJedis().set("name", "中文测试");
		System.out.println(RedisUtil.getJedis().get("name"));
	}
}
