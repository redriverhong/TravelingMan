package cyh.util.telmessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class HttpUtil {
	
	/**
	 * post请求
	 * @param url
	 * @param body
	 * @return
	 */
	public static String post(String url,String body){
		
		String result = null;
		try {
			OutputStreamWriter out=null;
			BufferedReader in = null;
			URL realUrl = new URL(url);
			URLConnection conn=realUrl.openConnection();
			
			//设置连接参数
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(2000);
			
			//提交数据
			out=new OutputStreamWriter(conn.getOutputStream(),"utf-8");
			out.write(body);
			out.flush();
			
			//读取返回数据
			in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line="";
			boolean firstLine=true;
			while((line=in.readLine())!=null){
				if(firstLine){
					firstLine=false;
				}else{
					result+=System.lineSeparator();
				}
				result+=line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 构造通用参数
	 * @return
	 */
	public static String createCommonParam(){
		//时间戳
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp=sdf.format(new Date());
		
		//签名
		String sig=DigestUtils.md5Hex(Config.ACCOUNT_SID + Config.AUTH_TOKEN + timestamp);
		return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + Config.RESP_DATA_TYPE;
	}
}
