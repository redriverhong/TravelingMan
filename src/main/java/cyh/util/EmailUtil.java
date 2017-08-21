package cyh.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class EmailUtil {
	/**
	 * 发送邮件
	 * @param email
	 * @param code
	 * @return
	 */
	public static boolean sendEmail(String email, String code) {
		Logger logger=Logger.getLogger(EmailUtil.class);
		boolean result=false;
		Properties pop = new Properties();
		pop.setProperty("mail.debug", "true");
		pop.setProperty("mail.smtp.auth", "true");
		pop.setProperty("mail.host", "smtp.163.com");
		pop.setProperty("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(pop);

		Message msg = new MimeMessage(session);
		try {
			msg.setSubject("Traveling Man Mailbox verification");
			msg.setText(setMessage(email,code));
			msg.setFrom(new InternetAddress("redriverhong@163.com"));

			Transport ts = session.getTransport();

			ts.connect("redriverhong", "cyh2017");
			ts.sendMessage(msg, new Address[] { new InternetAddress(email) });
			ts.close();
			result=true;
			logger.info("邮件发送成功！");
		} catch (MessagingException e) {
			e.printStackTrace();
			result=false;
			logger.error("邮件发送失败。");
		}
		return result;
	}

	public static String setMessage(String email,String code) {
		Date date = new Date();
		StringBuffer sb = new StringBuffer();
		sb.append("您好：").append("\n");
		sb.append("感谢您注册旅途人网站！你的注册邮箱是：").append(email).append("\n");
		sb.append("您注册的验证码是：").append(code).append("\n");
		sb.append("该验证码在20分钟内有效，20分钟后需要重新注册。").append("\n");
		sb.append(date);
		return sb.toString();
	}

	public static void main(String args[]) throws MessagingException {
		sendEmail("redriverhong@163.com", "qwrewrqg");
	}
}
