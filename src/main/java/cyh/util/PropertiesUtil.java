package cyh.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * 读取配置文件
	 * @param fileName
	 * @return
	 */
	public static Properties getProperties(String fileName){
		 Properties prop = new Properties();     
	        try{
	            //读取属性文件
	            InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
	            prop.load(in);     //加载属性列表
	            Iterator<String> it=prop.stringPropertyNames().iterator();
	            while(it.hasNext()){
	                String key=it.next();
	                System.out.println(key+":"+prop.getProperty(key));
	            }
	            in.close();
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
			return prop;
	}
	public static void main(String args[]){
		System.out.println(getProperties("config.properties"));
	}
}
