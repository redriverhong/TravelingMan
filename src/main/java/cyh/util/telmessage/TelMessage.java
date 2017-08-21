package cyh.util.telmessage;

import org.apache.log4j.Logger;

import cyh.util.EmailUtil;
import cyh.util.RandomId;

public class TelMessage {
	
	private static String url = Config.BASE_URL;
	private static String accountSid = Config.ACCOUNT_SID;
	private static String smsContent1 = "【旅途人网】您的验证码为";
	private static String smsContent2 = "，请于20分钟内正确输入，如非本人操作，请忽略此短信。";
	/**
	 * 发送验证短信入口
	 */
	public static void sendMsg(String to,String code){
		Logger logger=Logger.getLogger(EmailUtil.class);
		String smsContent=smsContent1+code+smsContent2;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		logger.info("result:" + System.lineSeparator() + result);
	}
	
	public static void main(String [] args){
		sendMsg("18312569380",RandomId.getTelCode());
	}
}
