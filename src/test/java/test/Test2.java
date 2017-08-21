package test;
import java.io.InputStream; 
import java.util.Iterator;
import java.util.Properties; 

public class Test2 {
    public static void main(String[] args) { 
        Properties prop = new Properties();     
        try{
            //读取属性文件a.properties
            InputStream in = Test2.class.getClassLoader().getResourceAsStream("config.properties");
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
    } 
}