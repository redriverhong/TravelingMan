package cyh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {
	/**
	 * 验证用户名(可以为数字，字母，下划线和中文并且长度为3—10)
	 * @param tel
	 * @return true:格式正确
	 */
	public static boolean CheckName(String name){
		if(isEmpty(name)&&name.trim().length()>10){
			return false;
		}
		Pattern p=Pattern.compile("^[\\w\u4e00-\u9fa5]{3,10}$");
		Matcher m=p.matcher(name);
		return m.matches();
	}
	/**
	 * 验证密码(可以为数字，字母，下划线和一般特殊字符并且长度为6—16)
	 * @param tel
	 * @return true:格式正确
	 */
	public static boolean CheckPwd(String name){
		if(isEmpty(name)&&name.trim().length()>16){
			return false;
		}
		Pattern p=Pattern.compile("^[\\w\\@\\#\\$\\%\\&\\*]{3,16}$");
		Matcher m=p.matcher(name);
		return m.matches();
	}
	/**
	 * 验证tel
	 * @param tel
	 * @return true:格式正确
	 */
	public static boolean CheckTel(String tel){
		if(isEmpty(tel)){
			return false;
		}
		Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$");
		Matcher m=p.matcher(tel);
		return m.matches();
	}
	/**
	 * 验证email
	 * @param email
	 * @return true:格式正确
	 */
	public static boolean CheckEmail(String email){
		if(isEmpty(email)){
			return false;
		}
		Pattern p=Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher m=p.matcher(email);
		return m.matches();
	}
	public static boolean isEmpty(String str) {
		return str==null||str.trim().isEmpty()||"null".equals(str);
	}
	/**
	 * Date转String
	 * @param date
	 * @return
	 */
	public static String getStringDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d=sdf.format(date);
		return d;
	}
	
	public static void main(String args[]){
		System.out.println(CheckTel("18312569380"));
		System.out.println(CheckEmail("rrrr@tcl.com"));
		System.out.println(CheckName("ad_f吊死扶伤12"));
		System.out.println(CheckPwd("ad_f@#%&*12"));
	}
}
