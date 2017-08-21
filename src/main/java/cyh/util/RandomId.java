package cyh.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public final class RandomId {
	private static String chatrams[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
		"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
		"V", "W", "X", "Y", "Z" };
	public static String getId(){
		StringBuffer sb=new StringBuffer();
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddhhmmss");
		String s=sf.format(d);
		List<String> charList=new ArrayList<String>();
		Collections.addAll(charList, chatrams);
		int length = chatrams.length;
		for(int i=0;i<5;i++){
			sb.append(charList.get(new Random().nextInt(length)));
		}
		return s+sb.toString();
	}
	/**
	 * 生成邮件验证码
	 * @return
	 */
	public static String getEmailCode(){
		
		String result="";
		while(result.matches("(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{0,8}")){
			StringBuffer sb=new StringBuffer();
			List<String> charList=new ArrayList<String>();
			Collections.addAll(charList, chatrams);
			int length = chatrams.length;
			for(int i=0;i<8;i++){
				sb.append(charList.get(new Random().nextInt(length)));
			}
			result=sb.toString();
		}
		return result;
	}
	
	/**
	 * 生成短信验证码
	 * @return
	 */
	public static String getTelCode(){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<6;i++){
			sb.append(new Random().nextInt(9));
		}
		return sb.toString();
	}
public static void main(String args[]){
	//System.out.println(getId());
	System.out.println(getEmailCode());
	//System.out.println(getTelCode());
}
}