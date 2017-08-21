package cyh.util;

import java.util.Properties;

public class Config {
	//获取配置文件
	private static Properties prop=PropertiesUtil.getProperties("config.properties");
	
	//redis的相关配置
	private static String IP;
	private static int PORT;
	private static int MAX_ACTIVE;
	private static int MAX_IDLE;
	private static int MAX_WAIT;
	private static int TIMEOUT;
	private static boolean TEST_ON_BORROW;
	
	static{
		IP=prop.getProperty("REDIS_IP");
		PORT=Integer.parseInt(prop.getProperty("REDIS_PORT"));
		MAX_ACTIVE=Integer.parseInt(prop.getProperty("REDIS_MAX_ACTIVE"));
		MAX_IDLE=Integer.parseInt(prop.getProperty("REDIS_MAX_IDLE"));
		MAX_WAIT=Integer.parseInt(prop.getProperty("REDIS_MAX_WAIT"));
		TIMEOUT=Integer.parseInt(prop.getProperty("REDIS_TIMEOUT"));
		TEST_ON_BORROW=Boolean.parseBoolean(prop.getProperty("REDIS_TEST_ON_BORROW"));
	}
	public static Properties getProp() {
		return prop;
	}
	public static void setProp(Properties prop) {
		Config.prop = prop;
	}
	public static String getIP() {
		return IP;
	}
	public static void setIP(String iP) {
		IP = iP;
	}
	public static int getPORT() {
		return PORT;
	}
	public static void setPORT(int pORT) {
		PORT = pORT;
	}
	public static int getMAX_ACTIVE() {
		return MAX_ACTIVE;
	}
	public static void setMAX_ACTIVE(int mAX_ACTIVE) {
		MAX_ACTIVE = mAX_ACTIVE;
	}
	public static int getMAX_IDLE() {
		return MAX_IDLE;
	}
	public static void setMAX_IDLE(int mAX_IDLE) {
		MAX_IDLE = mAX_IDLE;
	}
	public static int getMAX_WAIT() {
		return MAX_WAIT;
	}
	public static void setMAX_WAIT(int mAX_WAIT) {
		MAX_WAIT = mAX_WAIT;
	}
	public static int getTIMEOUT() {
		return TIMEOUT;
	}
	public static void setTIMEOUT(int tIMEOUT) {
		TIMEOUT = tIMEOUT;
	}
	public static boolean isTEST_ON_BORROW() {
		return TEST_ON_BORROW;
	}
	public static void setTEST_ON_BORROW(boolean tEST_ON_BORROW) {
		TEST_ON_BORROW = tEST_ON_BORROW;
	}
}
